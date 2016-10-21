package br.com.iftm.adseventos.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iftm.adseventos.dao.interfaces.IPlaceDao;
import br.com.iftm.adseventos.services.domain.Place;

@Path("/place")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlaceService {

	@Inject
	private IPlaceDao placeDao;
	
	@POST
	@Path("/add")
	public void add(Place place) {
		try {
			System.out.println("Add: " + new ObjectMapper().writeValueAsString(place));
			if(place.getCity().getId() == null) {
				
			}
			placeDao.save(place);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("ID to delete: " + id);
	}
	
	@PUT
	@Path("/update")
	public Place update(Place place) {
		try {
			System.out.println("Update: " + new ObjectMapper().writeValueAsString(place));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return place;
	}
	
	@GET
	@Path("/findAll")
	public List<Place> findAll() {
		try {
			return placeDao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@GET
	@Path("/find")
	public List<Place> find(@QueryParam("place") String placeAsJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Place place = mapper.readValue(placeAsJson, Place.class);
			System.out.println("Find by filters: "+ mapper.writeValueAsString(place));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/find/{id}")
	public Place findById(@PathParam("id") Long id) {
		System.out.println("ID to find: " + id);
		return null;
	}
	
}
