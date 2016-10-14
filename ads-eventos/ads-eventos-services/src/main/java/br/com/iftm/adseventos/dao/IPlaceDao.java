package br.com.iftm.adseventos.dao;

import br.com.iftm.adseventos.services.domain.Place;

public interface IPlaceDao {
	
	String PLACE_COLLECTION = "place";
	
	void save(Place place) throws Exception;

}