package br.com.iftm.adseventos.test.util;

import java.util.Map;

import br.com.iftm.adseventos.test.domain.TestResponse;


public interface ITestingRequest {

	/**
	 * Realiza uma requisição POST para a URI informada e com o entity no body da requisição
	 * @param uri
	 * @param entity
	 * @return
	 */
	<T> TestResponse doPost(String uri, T entity) throws Exception;
	
	/**
	 * Realiza uma requisição DELETE para a URI informada
	 * @param uri
	 * @return
	 */
	TestResponse doDelete(String uri) throws Exception;
	
	/**
	 * Realiza uma requisição PUT para a URI informada e com o entity no body da requisição
	 * @param uri
	 * @param entity
	 * @return
	 */
	<T> TestResponse doUpdate(String uri, T entity) throws Exception;
	
	/**
	 * Realiza uma requisição GET para a URI informada passando o
	 * @param uri
	 * @param queryParam
	 * @return
	 * @throws Exception 
	 */
	TestResponse doGet(String uri, Map<String, Object> queryParam) throws Exception;
	
}