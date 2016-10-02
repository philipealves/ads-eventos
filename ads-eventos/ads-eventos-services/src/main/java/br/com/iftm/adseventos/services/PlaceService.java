package br.com.iftm.adseventos.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.adseventos.services.domain.Place;

@Path("/place")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlaceService {

	@POST
	@Path("/add")
	public void add(Place place) {
		System.out.println(place.getAddress() +  place.getNeighborhood() + place.getNumber());
//		try {
//			System.out.println(new ObjectMapper().writeValueAsString(place));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id") Long id) {
		
	}
	
	@PUT
	@Path("/update")
	public Place update(Place place) {
		return place;
	}
	
	@GET
	@Path("/find")
	public List<Place> find(Place place) {
		return null;
	}
	
	@GET
	@Path("/find/{id}")
	public Place findById(@PathParam("id") Long id) {
		return null;
	}
	
}
