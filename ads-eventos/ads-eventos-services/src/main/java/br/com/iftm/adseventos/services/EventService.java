package br.com.iftm.adseventos.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iftm.adseventos.dao.interfaces.IEventDao;
import br.com.iftm.adseventos.dao.interfaces.IParticipantDao;
import br.com.iftm.adseventos.services.domain.Event;
import br.com.iftm.adseventos.services.domain.Participant;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventService {

	@Inject
	private IEventDao eventDao;

	@Inject
	private IParticipantDao participantDao;

	@POST
	@Path("/signIn/{id}")
	public void signIn(Participant participant, @PathParam("id") Long eventId) {

		try {

			Event event = eventDao.findById(eventId);

			if (event.getId() != null) {
				participant = participantDao.add(participant);
				event.getParticipants().add(participant);
//				participant.getEvents().add(event);
				eventDao.update(event);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@POST
	@Path("/add")
	public Event add(Event event) {

		try {
			event.getParticipants().clear();
			event = eventDao.add(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	@PUT
	@Path("/update")
	public Event update(Event event) {

		try {
			eventDao.update(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	@GET
	@Path("/find/{id}")
	public String findById(@PathParam("id") Long id) {

		try {
			Event event = eventDao.findById(id);
			return new ObjectMapper().writeValueAsString(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
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
