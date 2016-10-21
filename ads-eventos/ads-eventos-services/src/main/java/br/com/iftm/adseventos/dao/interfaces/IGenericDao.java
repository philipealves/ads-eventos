package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

public interface IGenericDao<T> {

	void save(T entity) throws Exception;
	void update(T entity) throws Exception;
	List<T> findAll() throws Exception;
	T findByExample(T entity) throws Exception;
}