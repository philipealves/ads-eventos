package br.com.iftm.adseventos.test.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iftm.adseventos.services.domain.City;
import br.com.iftm.adseventos.services.domain.Place;
import br.com.iftm.adseventos.services.domain.State;
import br.com.iftm.adseventos.test.domain.TestResponse;
import br.com.iftm.adseventos.test.util.RequestUtil;

public class PlaceServiceTest extends RequestUtil {
	
	@Test
	public void add() {
		
		try {
			doAdd();
		} catch (Exception e) {
			Assert.assertTrue("Erro ao adicionar um lugar. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void findAll() throws Exception {
		
		
		try {
			
			TestResponse response = super.doGet(URL_BASE +"/place/findAll", null);
			Assert.assertTrue("Ocorreu um erro na consulta dos lugares!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
			List<Place> places = doFindAll();
			Assert.assertTrue("Nenhum registro encontrado! ", places.size() > 0);
			
		} catch(Exception e) {
			Assert.assertTrue("Erro ao consultar os lugares. Motivo: " + e.getMessage(), false);
		}
		
	
	}
	
	@Test
	public void findById() {
		
		try {
			
			//adiciona e recupera um lugar
			Place place = doAdd();

			//valida
			place = doFindById(place.getId());
			Assert.assertTrue("Lugar ou ID do lugar estão nulos!", place != null && place.getId() != null);
			
		} catch(Exception e) {
			Assert.assertTrue("Erro ao consultar o lugar pelo ID. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void deleteById() {
		try {
			
			//adiciona e recupera um lugar
			Place place = doAdd();
			
			//deleta
			TestResponse response = super.doDelete(URL_BASE + "/place/delete/" + place.getId());
			Assert.assertTrue("Erro ao tentar deletar o lugar!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
			place = doFindById(place.getId());
			Assert.assertTrue("O lugar não foi deletado!", place.getId() == null);
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao deletar o lugar. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void update() {
		
		try {
			
			String addressBefore;
			String addressAfter;
			
			//adiciona
			Place place = doAdd();
			addressBefore = place.getAddress();
			
			System.out.println("Antes: " + place.getId() + " " + addressBefore);
			
			do {
				addressAfter = "JUnit " + new Random().nextInt(100);
			} while(addressBefore.equals(addressAfter));
			
			//atualiza
			place.setAddress(addressAfter);
			TestResponse response = super.doUpdate(URL_BASE + "/place/update", place);
			Assert.assertTrue("Erro ao atualizar o lugar!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
			//consulta e valida
			place = doFindById(place.getId());
			addressAfter = place.getAddress();
			System.out.println("Depois: " + place.getId() + " " + addressAfter);
			Assert.assertTrue("Erro ao atualizar o lugar!", !addressBefore.equals(addressAfter));
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao atualizar o lugar. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	private List<Place> doFindAll() throws Exception {
		
		try {
			
			TestResponse response = super.doGet(URL_BASE +"/place/findAll", null);
			Assert.assertTrue("Ocorreu um erro na consulta dos lugares!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
			return mapper.readValue(response.getContent(), new TypeReference<List<Place>>(){});
			
		} catch(Exception e) {
			Assert.assertTrue("Erro ao consultar os lugares. Motivo: " + e.getMessage(), false);
		}
		
		return new ArrayList<>();
	}
	
	private Place doFindById(Long id) throws Exception {

		Place place = new Place();

		try {
			
			TestResponse response = super.doGet(URL_BASE + "/place/find/" + id);
			place = mapper.readValue(response.getContent(), Place.class);
			
			Assert.assertTrue("Erro ao consultar o lugar!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK ||
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao consultar o lugar. Motivo: " + e.getMessage(), false);
		}

		return place;
	}

	private Place doAdd() {
		
		Place place = new Place();
		
		try {

			State state = new State();
			state.setId(1L);
			state.setName("Minas Gerais");
			state.setInitials("MG");
			
			City city= new City();
			city.setId(1L);
			city.setName("Uberlândia");
			city.setState(state);
			
			place.setAddress("JUnit " + new Random().nextInt(100));
			place.setNeighborhood("JUnit " + new Random().nextInt(100));
			place.setNumber(0);		
			place.setCity(city);
			
			TestResponse response = super.doPost(URL_BASE +"/place/add", place);
			place = mapper.readValue(response.getContent(), Place.class);
			Assert.assertTrue("Erro ao adicionar o lugar!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT || 
					place == null || place.getId() == null);
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao adicionar um lugar. Motivo: " + e.getMessage(), false);
		}
		
		return place;
		
	}
	
}
