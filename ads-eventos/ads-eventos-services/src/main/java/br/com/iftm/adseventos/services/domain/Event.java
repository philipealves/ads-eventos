package br.com.iftm.adseventos.services.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
	
	private Long id;
	private String name;
	private String description;
	private LocalDateTime date;
	private Place eventPlace;
	private List<Participant> participants;

	public Event() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Place getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(Place eventPlace) {
		this.eventPlace = eventPlace;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
