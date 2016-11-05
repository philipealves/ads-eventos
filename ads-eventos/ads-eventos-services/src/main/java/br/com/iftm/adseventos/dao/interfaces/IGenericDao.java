package br.com.iftm.adseventos.dao.interfaces;

import java.util.HashMap;
import java.util.List;

public interface IGenericDao<T> {

	T save(T entity) throws Exception;
	void update(T entity) throws Exception;
	void delete(T entity) throws Exception;
	List<T> findAll(Class<T> clazz) throws Exception;
	List<T> findByHql(String hql, HashMap<String, Object> params) throws Exception;
	
}