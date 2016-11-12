package br.com.iftm.adseventos.services.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="event")
@JsonInclude(Include.NON_NULL)
public class Event {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="moment")
	private Date date;
	
	@OneToOne
	@JoinColumn(name="id_place")
	private Place eventPlace;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="event_participants", 
		joinColumns = {@JoinColumn(name="id_event", nullable=false, updatable=false)},
		inverseJoinColumns = {@JoinColumn(name="id_participant", nullable=false, updatable=false)}
	)
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
		if(participants == null) {
			participants = new ArrayList<>();
		}
		
		this.participants = participants;
	}

}
