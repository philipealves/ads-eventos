package br.com.iftm.adseventos.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.iftm.adseventos.dao.interfaces.IStateDao;
import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.State;

public class StateDao extends MySQLGenericDao<State> implements IStateDao {

	@PersistenceContext(name = "ADSEventosPU")
	private EntityManager manager;

	public StateDao() {

	}

	@Override
	public List<State> findAll() throws Exception {
		return super.findAll(State.class);
	}

	@Override
	public State findById(Long id) throws Exception {

		String hql = "from State where id = :id";
		HashMap<String, Object> params = new HashMap<>();

		params.put("id", id);
		List<State> states = super.findByHql(hql, params);

		if (states == null || states.isEmpty()) {
			return new State();
		}

		return states.get(0);

	}

}
