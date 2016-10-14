package br.com.iftm.adseventos.dao;

import br.com.iftm.adseventos.services.domain.Place;

public class PlaceDao extends GenericDao<Place> implements IPlaceDao  {
	
	public PlaceDao() {
		super(PLACE_COLLECTION);
	}
	
	@Override
	public void save(Place place) throws Exception {
		super.save(place);
	}
	
}
