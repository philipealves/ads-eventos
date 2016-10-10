package br.com.iftm.adseventos.dao;

import br.com.iftm.adseventos.services.domain.Place;

public class PlaceDao {
	
	public PlaceDao() {
		MongoDatabaseHelper.createCollection("place");
	}
	
	public void add(Place place) {
		MongoDatabaseHelper.test();
	}
	
}
