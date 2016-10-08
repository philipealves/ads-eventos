package br.com.iftm.adseventos.test;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Named;

@Named
public class RequestUtil implements ITestingRequest {
	
	public <T> Response doPost(String uri, T entity) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(entity, MediaType.APPLICATION_JSON));
			response.close();
			return response;
		} catch(Throwable e) {
			throw e;
		}
		
	}
	
	public Response doDelete(String uri) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().delete();
			response.close();
			return response;
		} catch(Throwable e) {
			throw e;
		}
		
	}
	
	public <T> Response doUpdate(String uri, T entity) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().put(Entity.entity(entity, MediaType.APPLICATION_JSON));
			response.close();
			return response;
		} catch(Throwable e) {
			throw e;
		}
		
	}

	public <T> Response doGet(String uri, Map<String, Object> queryParams) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			
			if(queryParams != null) {
				queryParams.forEach((paramName, paramValue) -> target.queryParam(paramName, paramValue));
			}
			
			Response response = target.request().get();
			response.close();
			return response;
		} catch(Throwable e) {
			throw e;
		}
		
	}
}
