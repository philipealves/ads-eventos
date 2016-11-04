package br.com.iftm.adseventos.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.iftm.adseventos.dao.impl.IEventDao;
import br.com.iftm.adseventos.services.domain.Event;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventService {
	
	@Inject
	private IEventDao eventDao;
	
	@POST
	@Path("/signIn/{id}")
	public void signIn(@PathParam("id") Long eventId, @QueryParam("participant") String participantAsJson) {
		
	}
	
	@POST
	@Path("/add")
	public Event add(Event event) {
		
		try {
			event = eventDao.add(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return event;
	}
	
	@GET
	@Path("/find/{id}")
	public Event findById(Long id) {
		
		try {
			return eventDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return new Event();
	}
	
	@GET
	@Path("/findAll")
	public List<Event> findAll() {
List<Event> events = new ArrayList<>();
		
		try {
			events = eventDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return events;
	}
	
}
