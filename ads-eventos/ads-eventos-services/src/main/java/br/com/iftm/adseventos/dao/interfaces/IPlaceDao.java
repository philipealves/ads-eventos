package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

import br.com.iftm.adseventos.services.domain.Place;

public interface IPlaceDao {
	
	Place save(Place place) throws Exception;
	void delete(Place place) throws Exception;
	void update(Place place) throws Exception;
	List<Place> findAll() throws Exception;
	Place findById(Long id) throws Exception;
	
}