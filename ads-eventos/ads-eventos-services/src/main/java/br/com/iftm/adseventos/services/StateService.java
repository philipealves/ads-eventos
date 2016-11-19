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

import br.com.iftm.adseventos.dao.interfaces.IStateDao;
import br.com.iftm.adseventos.services.domain.State;

@Path("/state")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StateService {

	@Inject
	private IStateDao stateDao;

	@GET
	@Path("/findAll")
	public List<State> findAll() {

		try {
			return stateDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@GET
	@Path("/find/{id}")
	public State findById(@PathParam("id") Long id) {

		try {
			return stateDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
