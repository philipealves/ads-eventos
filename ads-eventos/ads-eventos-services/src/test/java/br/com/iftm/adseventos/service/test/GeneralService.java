package br.com.iftm.adseventos.service.test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class GeneralService {
	
	protected <T> Response doPost(String uri, T entity) {
		
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
	
	protected Response doDelete(String uri) {
		
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
	
	protected <T> Response doUpdate(String uri, T entity) {
		
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

	protected <T> Response doGet(String uri) {
		
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().get();
			response.close();
			return response;
		} catch(Throwable e) {
			throw e;
		}
		
	}
}
