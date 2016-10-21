package br.com.iftm.adseventos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.iftm.adseventos.services.domain.State;

public class StateDao {
	
	@PersistenceContext(name="ADSEventosPU")
	private EntityManager manager;
	
	public StateDao() {
		
	}
	
	@Transactional
	public void save(State state) {
		manager.merge(state);
	}
	
}
