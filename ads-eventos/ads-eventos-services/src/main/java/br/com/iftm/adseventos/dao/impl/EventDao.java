package br.com.iftm.adseventos.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.Event;
import br.com.iftm.adseventos.services.domain.Participant;

public class EventDao extends MySQLGenericDao<Event> implements IEventDao {

	/* (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.impl.IEventDao#add(br.com.iftm.adseventos.services.domain.Event)
	 */
	@Override
	@Transactional
	public Event add(Event event) throws Exception {
		return super.save(event);
	}
	
	@Override
	@Transactional
	public void update(Event entity) throws Exception {
		super.update(entity);
	}
	
	/* (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.impl.IEventDao#findAll()
	 */
	@Override
	public List<Event> findAll() throws Exception {
		return super.findAll(Event.class);
	}
	
	/* (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.impl.IEventDao#findById(java.lang.Long)
	 */
	@Override
	@Transactional
	public Event findById(Long id) throws Exception {
		
		Event response = new Event();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Event> query = builder.createQuery(Event.class);
		Root<Event> event = query.from(Event.class);
		Join<Event, Participant> join = event.join("participants");
		
		return response;
		
	}
	
}
