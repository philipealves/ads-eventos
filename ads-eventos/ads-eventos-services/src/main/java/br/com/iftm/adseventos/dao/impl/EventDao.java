package br.com.iftm.adseventos.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.Event;

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
	public Event findById(Long id) throws Exception {
		
		String hql = "from Event where id = :id";
		HashMap<String, Object> params = new HashMap<>();
		
		params.put("id", id);
		List<Event> events = super.findByHql(hql, params);
		
		if(events == null || events.isEmpty()) {
			return new Event();
		}
		
		return events.get(0);
		
	}
	
}
