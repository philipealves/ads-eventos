package br.com.iftm.adseventos.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.iftm.adseventos.dao.interfaces.ICityDao;
import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.City;

public class CityDao extends MySQLGenericDao<City> implements ICityDao {

	@PersistenceContext(name = "ADSEventosPU")
	private EntityManager manager;

	public CityDao() {

	}

	@Override
	public City findById(Long id) throws Exception {

		String hql = "from City where id = :id";
		HashMap<String, Object> params = new HashMap<>();

		params.put("id", id);
		List<City> cities = super.findByHql(hql, params);

		if (cities == null || cities.isEmpty()) {
			return new City();
		}

		return cities.get(0);

	}

	@Override
	public List<City> findByStateId(Long id) throws Exception {
		String hql = "from City where state.id = :id";
		HashMap<String, Object> params = new HashMap<>();

		params.put("id", id);
		List<City> cities = super.findByHql(hql, params);

		return cities;
	}

}
