package br.com.iftm.adseventos.test.service;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.iftm.adseventos.services.domain.City;
import br.com.iftm.adseventos.services.domain.Place;
import br.com.iftm.adseventos.services.domain.State;
import br.com.iftm.adseventos.test.ITestingRequest;

public class PlaceServiceTest {
	
	@Inject 
	@Named("requestUtil") 
	private ITestingRequest requestUtil;
	
	private static final String URL_BASE = "http://localhost:8080/ads-eventos-services/place";
	
	@Test
	public void add() {
		
		State state = new State();
		state.setName("Test Add Name");
		
		City city= new City();
		city.setName("Test Add City");
		city.setState(state);
		
		Place place = new Place();
		place.setAddress("Test Add Address");
		place.setNeighborhood("Test Add neighborhood");
		place.setNumber(423);		
		place.setCity(city);
		
		Response response = requestUtil.doPost(URL_BASE +"/add", place);
		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
				response.getStatus() == HttpStatus.SC_NO_CONTENT);
	}
	
	@Test
	public void deleteById() {
		Response response = requestUtil.doDelete(URL_BASE + "/delete/" + 1);
		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
				response.getStatus() == HttpStatus.SC_NO_CONTENT);
	}
	
	@Test
	public void update() {
		State state = new State();
		state.setName("Test Update Name");
		
		City city= new City();
		city.setName("Test Update City");
		city.setState(state);
		
		Place place = new Place();
		place.setAddress("Test Update Address");
		place.setNeighborhood("Test Update neighborhood");
		place.setNumber(423);		
		place.setCity(city);
		
		Response response = requestUtil.doUpdate(URL_BASE + "/update", place);
		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
				response.getStatus() == HttpStatus.SC_NO_CONTENT);
	}
	
	@Test
	public void find() throws JsonProcessingException {
		State state = new State();
		state.setName("Test Find Name");
		
		City city= new City();
		city.setName("Test Find City");
		city.setState(state);
		
		Place place = new Place();
		place.setAddress("Test Find Address");
		place.setNeighborhood("Test Find neighborhood");
		place.setNumber(423);		
		place.setCity(city);
		
		HashMap<String, Object> queryParam = new HashMap<>();
		queryParam.put("place", place);

		Response response = requestUtil.doGet(URL_BASE + "/find", queryParam);
		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
				response.getStatus() == HttpStatus.SC_NO_CONTENT);
	}

	@Test
	public void findById() {
		Response response = requestUtil.doGet(URL_BASE + "/find/" + 1, null);
		Assert.assertTrue("Erro ao executar o serviço!", response.getStatus() == HttpStatus.SC_OK || 
				response.getStatus() == HttpStatus.SC_NO_CONTENT);
	}
	
}
