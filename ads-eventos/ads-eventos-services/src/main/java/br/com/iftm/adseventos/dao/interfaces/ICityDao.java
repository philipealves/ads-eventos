package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

import br.com.iftm.adseventos.services.domain.City;

public interface ICityDao {

	List<City> findByStateId(Long id) throws Exception;

	City findById(Long id) throws Exception;

}
