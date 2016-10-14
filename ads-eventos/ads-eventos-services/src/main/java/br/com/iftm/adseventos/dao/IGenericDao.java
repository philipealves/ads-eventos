package br.com.iftm.adseventos.dao;

public interface IGenericDao<T> {

	void save(T entity) throws Exception;
	
}