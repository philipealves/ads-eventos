package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

import br.com.iftm.adseventos.services.domain.Event;

public interface IEventDao {

	Event add(Event event) throws Exception;
	List<Event> findAll() throws Exception;
	Event findById(Long id) throws Exception;
	void update(Event event) throws Exception;

}