package br.com.iftm.adseventos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.iftm.adseventos.services.domain.City;

public class CityDao {
	
	@PersistenceContext(name="ADSEventosPU")
	private EntityManager manager;
	
	public CityDao() {
		
	}
	
	public void save(City city) {
		
	}
	
}
