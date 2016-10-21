package br.com.iftm.adseventos.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.interfaces.IPlaceDao;
import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.Place;

public class PlaceDao extends MySQLGenericDao<Place> implements IPlaceDao  {
	
	public PlaceDao() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.mysql.MySQLGenericDao#save(java.lang.Object)
	 */
	@Transactional
	public void save(Place place) throws Exception {
		super.save(place);
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.mysql.MySQLGenericDao#update(java.lang.Object)
	 */
	public void update(Place place) throws Exception {
		
	}

	@Override
	public List<Place> findAll() throws Exception {
		return null;
	}
	
}
