package br.com.iftm.adseventos.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iftm.adseventos.services.domain.City;
import br.com.iftm.adseventos.services.domain.Event;
import br.com.iftm.adseventos.services.domain.Participant;
import br.com.iftm.adseventos.services.domain.Place;
import br.com.iftm.adseventos.services.domain.State;
import br.com.iftm.adseventos.test.domain.TestResponse;
import br.com.iftm.adseventos.test.util.RequestUtil;

public class EventServiceTest extends RequestUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void add() {
		
		try {
			doAdd();
		} catch (Exception e) {
			Assert.assertTrue("Erro ao adicionar o evento. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void findById() {
		
		try {
			
			//adiciona e recupera um lugar
			Event event = doAdd();

			//valida
			event = doFindById(event.getId());
			Assert.assertTrue("Evento ou ID do evento estão nulos!", event != null && event.getId() != null);
			
		} catch(Exception e) {
			Assert.assertTrue("Erro ao consultar o lugar pelo ID. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void update() {
		
		try {
			
			String before;
			String after;
			
			//adiciona
			Event event = doAdd();
			before = event.getDescription();
			
			System.out.println("Antes: " + event.getId() + " " + before);
			
			do {
				after = "JUnit " + new Random().nextInt(100);
			} while(before.equals(after));
			
			//atualiza
			event.setDescription(after);
			TestResponse response = super.doUpdate(URL_BASE + "/event/update", event);
			Assert.assertTrue("Erro ao atualizar o lugar!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
			//consulta e valida
			event = doFindById(event.getId());
			after = event.getDescription();
			System.out.println("Depois: " + event.getId() + " " + after);
			Assert.assertTrue("Erro ao atualizar o evento!", !before.equals(after));
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao atualizar o evento. Motivo: " + e.getMessage(), false);
		}
		
	}
	
	@Test
	public void signIn() {
		
		try {
			
			Event event = doAdd();
			Participant participant;
			TestResponse response;
			int count = 0;
			
			do {
				participant = new Participant();
				participant.setEmail("participante@junit.com.br");
				participant.setName("JUnit " + new Random().nextInt(100));
				
				event.getParticipants().add(participant);
				response = super.doPost(URL_BASE + "/event/signIn/" + event.getId(), participant);
				
				count++;
				Assert.assertTrue("Erro ao realizar a inscrição do evento: " + response.getContent(), 
						response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
						response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
				
			} while(count < 2);
			
			event = doFindById(event.getId());
			
			if(event.getParticipants().isEmpty()) {
				Assert.assertTrue("Os participantes não foram inseridos no evento. Motivo: " + response.getContent(),
						false);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue("Erro ao realizar a inscrição no evento. Motivo: " + e, false);
		}
		
	}
	
	private Event doAdd() {
		
		Event event = new Event();
		
		try {
			
			Place place = createPlace();
			
			event.setDate(new Date());
			event.setDescription("Evento JUnit " + new Random().nextInt(100));
			event.setEventPlace(place);

			Participant p = new Participant();
			p.setEmail(new Random().nextInt(100) + "@email.com");
			p.setName("JUnit " + new Random().nextInt(100));
			
			List<Participant> list = new ArrayList<>();
			list.add(p);
			
			event.setName("Evento JUnit");
			event.setParticipants(list);
			
			TestResponse response = super.doPost(URL_BASE +"/event/add", event);
			event = mapper.readValue(response.getContent(), Event.class);
			Assert.assertTrue("Erro ao adicionar o evento!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK || 
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT || 
					event == null || event.getId() == null);
			
		} catch (Exception e) {
			Assert.assertTrue("Erro ao adicionar o evento. Motivo: " + e.getMessage(), false);
		}
		
		return event;
		
	}
	
	private Place createPlace() {
		
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
			place.setNickname("nickname");
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
	
	private Event doFindById(Long id) throws Exception {

		Event event = new Event();

		try {
			
			TestResponse response = super.doGet(URL_BASE + "/event/find/" + id);
			event = mapper.readValue(response.getContent(), Event.class);
			
			Assert.assertTrue("Erro ao consultar o evento!", 
					response.getStatus().getStatusCode() == HttpStatus.SC_OK ||
					response.getStatus().getStatusCode() == HttpStatus.SC_NO_CONTENT);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("Erro ao consultar o evento. Motivo: " + e.getMessage(), false);
		}

		return event;
	}

}
