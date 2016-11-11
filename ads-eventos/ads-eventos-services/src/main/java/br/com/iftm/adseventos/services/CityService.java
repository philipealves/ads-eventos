package br.com.iftm.adseventos.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.adseventos.dao.interfaces.ICityDao;
import br.com.iftm.adseventos.services.domain.City;

@Path("/city")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityService {

	@Inject
	private ICityDao cityDao;

	@GET
	@Path("/findByState/{id}")
	public List<City> findByStateId(@PathParam("id") Long id) {

		try {
			return cityDao.findByStateId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@GET
	@Path("/find/{id}")
	public City findById(@PathParam("id") Long id) {

		try {
			return cityDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
