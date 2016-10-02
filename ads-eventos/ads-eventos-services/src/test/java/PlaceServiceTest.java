import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import br.com.iftm.adseventos.services.domain.City;
import br.com.iftm.adseventos.services.domain.Place;
import br.com.iftm.adseventos.services.domain.State;

public class PlaceServiceTest {
	
	private static final String URL_BASE = "http://localhost:8080/ads-eventos-services/place";
	
	@Test
	public void add() {
		
		State state = new State();
		state.setName("Firs State");
		
		City city= new City();
		city.setName("First City");
		city.setState(state);
		
		Place place = new Place();
		place.setAddress("First Address");
		place.setNeighborhood("First neighborhood");
		place.setNumber(423);		
		place.setCity(city);
		
		try {
			System.out.println(new ObjectMapper().writeValueAsString(place));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		doPost(URL_BASE +"/add", place);
		
	}
	
	private <T> void doPost(String uri, T entity) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(entity, MediaType.APPLICATION_JSON));
			System.out.println(response.getStatus());
			response.close();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
}
