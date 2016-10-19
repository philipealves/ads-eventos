package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

import br.com.iftm.adseventos.services.domain.Place;

public interface IPlaceDao {
	
	void save(Place place) throws Exception;
	List<Place> findAll() throws Exception;
	
}