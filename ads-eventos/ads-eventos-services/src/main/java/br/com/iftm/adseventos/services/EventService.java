package br.com.iftm.adseventos.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.adseventos.services.domain.Event;
import br.com.iftm.adseventos.services.domain.Participant;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventService {
	
	@POST
	@Path("/signIn/{id}")
	public void signIn(@PathParam("id") Long eventId, Participant participant) {
		
	}
	
	@POST
	@Path("/add")
	public void add(Event event) {
		
	}
	
	@GET
	@Path("/find")
	public List<Event> find(Event event) {
		return null;
	}
	
}
