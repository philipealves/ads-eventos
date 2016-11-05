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
import javax.ws.rs.core.Response;

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
	public Place add(Place place) {
		try {
			return placeDao.save(place);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new Place();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id") Long id) {

		try {
			System.out.println("id to delete: "+ id);
			placeDao.delete(new Place(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PUT
	@Path("/update")
	public Place update(Place place) {
		
		try {
			System.out.println("Update: " + new ObjectMapper().writeValueAsString(place));
			placeDao.update(place);
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
	@Path("/find/{id}")
	public Place findById(@PathParam("id") Long id) {
		
		try {
			return placeDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
