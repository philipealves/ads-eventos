package br.com.iftm.adseventos.test;

import java.util.Map;

import javax.ws.rs.core.Response;


public interface ITestingRequest {

	/**
	 * Realiza uma requisição POST para a URI informada e com o entity no body da requisição
	 * @param uri
	 * @param entity
	 * @return
	 */
	<T> Response doPost(String uri, T entity);
	
	/**
	 * Realiza uma requisição DELETE para a URI informada
	 * @param uri
	 * @return
	 */
	Response doDelete(String uri);
	
	/**
	 * Realiza uma requisição PUT para a URI informada e com o entity no body da requisição
	 * @param uri
	 * @param entity
	 * @return
	 */
	<T> Response doUpdate(String uri, T entity);
	
	/**
	 * Realiza uma requisição GET para a URI informada passando o
	 * @param uri
	 * @param queryParam
	 * @return
	 */
	<T> Response doGet(String uri, Map<String, Object> queryParam);
	
}