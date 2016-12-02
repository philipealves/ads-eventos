package br.com.iftm.adseventos.dao.mysql;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.iftm.adseventos.dao.interfaces.IGenericDao;

public class MySQLGenericDao<T> implements IGenericDao<T> {
	
	@PersistenceContext(name="ADSEventosPU")
	protected EntityManager manager;
	
	@Override
	public T save(T entity) throws Exception {
		manager.persist(entity);
		manager.flush();
		return entity;
	}

	@Override
	public void update(T entity) throws Exception {
		entity = manager.merge(entity);
		manager.persist(entity);
	}
	
	@Override
	public void delete(T entity) throws Exception {
		entity = manager.merge(entity);
		manager.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> clazz) throws Exception {
		Query query = manager.createQuery("from " + clazz.getCanonicalName());
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql, HashMap<String, Object> params) throws Exception {
		Query query = manager.createQuery(hql);
		
		params.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return (List<T>) query.getResultList();
	}
	
}
