package br.com.iftm.adseventos.dao.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.interfaces.IGenericDao;

public class MySQLGenericDao<T> implements IGenericDao<T> {
	
	@PersistenceContext(name="ADSEventosPU")
	private EntityManager manager;
	
	@Override
	@Transactional
	public void save(T entity) throws Exception {
		manager.persist(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findByExample(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
