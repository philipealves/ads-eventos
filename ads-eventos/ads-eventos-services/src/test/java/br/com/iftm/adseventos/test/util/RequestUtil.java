package br.com.iftm.adseventos.test.util;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.com.iftm.adseventos.test.domain.TestResponse;

public class RequestUtil implements ITestingRequest {
	
	public <T> TestResponse doPost(String uri, T entity) throws Exception {
		
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			return catchResponse(target.request().post(Entity.entity(entity, MediaType.APPLICATION_JSON)));
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	public TestResponse doDelete(String uri) throws Exception {
		
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			
			return catchResponse(target.request().delete());
			
		} catch(Throwable e) {
			throw e;
		}
		
	}
	
	public <T> TestResponse doUpdate(String uri, T entity) throws Exception{
		
		try {

			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			
			return catchResponse(target.request().put(Entity.entity(entity, MediaType.APPLICATION_JSON)));
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	public TestResponse doGet(String uri) throws Exception {
		
		try {
			return doGet(uri, null);
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	public TestResponse doGet(String uri, Map<String, Object> queryParams) throws Exception {
		
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			
			if(queryParams != null) {
				queryParams.forEach((paramName, paramValue) -> target.queryParam(paramName, paramValue));
			}
			
			return catchResponse(target.request().get());
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	private TestResponse catchResponse(Response response) {
		TestResponse result = new TestResponse();
		result.setContent(response.readEntity(String.class));
		result.setStatus(response.getStatus());
		response.close();
		return result;
	}
	
}
