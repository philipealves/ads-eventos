package br.com.iftm.adseventos.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.interfaces.IPlaceDao;
import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.Place;

public class PlaceDao extends MySQLGenericDao<Place> implements IPlaceDao  {
	
	public PlaceDao() {
		
	}
	
	@Override
	@Transactional
	public Place save(Place place) throws Exception {
		return super.save(place);
	}
	
	@Override
	@Transactional
	public void update(Place place) throws Exception {
		super.update(place);
	}
	
	@Override
	@Transactional
	public void delete(Place place) throws Exception {
		super.delete(place);
	}
	
	@Override
	public List<Place> findAll() throws Exception {
		return super.findAll(Place.class);
	}
	
	@Override
	public Place findById(Long id) throws Exception {
		
		String hql = "from Place where id = :id"; 
		HashMap<String, Object> params = new HashMap<>();
		
		params.put("id", id);
		List<Place> places = super.findByHql(hql, params);
		
		if(places == null || places.isEmpty()) {
			return new Place();
		}
		
		return places.get(0);
		
	}

}
