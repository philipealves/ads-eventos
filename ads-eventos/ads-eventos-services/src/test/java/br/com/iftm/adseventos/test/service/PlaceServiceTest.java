package br.com.iftm.adseventos.test.service;
import javax.validation.constraints.AssertTrue;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iftm.adseventos.services.domain.City;
import br.com.iftm.adseventos.services.domain.Place;
import br.com.iftm.adseventos.services.domain.State;
import br.com.iftm.adseventos.test.RequestUtil;

public class PlaceServiceTest extends RequestUtil {
	
//	@Injec 
//	@Named("requestUtil") 
//	private ITestingRequest requestUtil;
	
	private static final String URL_BASE = "http://localhost:8080/ads-eventos-services/place";
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void add() {
		
		State state = new State();
		state.setId(1L);
		state.setName("Minas Gerais");
		state.setInitials("MG");
		
		City city= new City();
		city.setId(1L);
		city.setName("Uberlândia");
		city.setState(state);
		
		Place place = new Place();
		place.setAddress("Endereço JUnit 3");
		place.setNeighborhood("Bairro JUnit 3");
		place.setNumber(0);		
		place.setCity(city);
		
		try {
			Response response = super.doPost(URL_BASE +"/add", place);
			Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
					response.getStatus() == HttpStatus.SC_NO_CONTENT);
		} catch (Exception e) {
			Assert.assertTrue("Erro ao adicionar um lugar. Motivo" + e.getMessage(), false);
		}
		
	}
	
//	@Test
//	public void findAll() throws JsonProcessingException {
//		Response response = super.doGet(URL_BASE +"/findAll", null);
//	}
	
//	@Test
//	public void deleteById() {
//		Response response = super.doDelete(URL_BASE + "/delete/" + 1);
//		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
//				response.getStatus() == HttpStatus.SC_NO_CONTENT);
//	}
//	
//	@Test
//	public void update() {
//		State state = new State();
//		state.setName("Test Update Name");
//		
//		City city= new City();
//		city.setName("Test Update City");
//		city.setState(state);
//		
//		Place place = new Place();
//		place.setAddress("Test Update Address");
//		place.setNeighborhood("Test Update neighborhood");
//		place.setNumber(423);		
//		place.setCity(city);
//		
//		Response response = super.doUpdate(URL_BASE + "/update", place);
//		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
//				response.getStatus() == HttpStatus.SC_NO_CONTENT);
//	}
//	
//	@Test
//	public void find() {
//		State state = new State();
//		state.setName("Test Find Name");
//		
//		City city= new City();
//		city.setName("Test Find City");
//		city.setState(state);
//		
//		Place place = new Place();
//		place.setAddress("Test Find Address");
//		place.setNeighborhood("Test Find neighborhood");
//		place.setNumber(423);		
//		place.setCity(city);
//		
//		HashMap<String, Object> queryParam = new HashMap<>();
//		queryParam.put("place", place);
//
//		Response response = super.doGet(URL_BASE + "/find", queryParam);
//		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
//				response.getStatus() == HttpStatus.SC_NO_CONTENT);
//	}
//
//	@Test
//	public void findById() {
//		Response response = super.doGet(URL_BASE + "/find/" + 1, null);
//		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
//				response.getStatus() == HttpStatus.SC_NO_CONTENT);
//	}
	
}
