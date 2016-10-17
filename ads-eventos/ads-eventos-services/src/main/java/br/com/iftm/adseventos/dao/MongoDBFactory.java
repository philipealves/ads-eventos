package br.com.iftm.adseventos.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Singleton para criar e controlar as conexões com o MongoDB
 * @author ggarcia
 *
 */
final class MongoDBFactory {
	
	private static MongoClient client;
	private static MongoDatabase dataBase;
	
	private MongoDBFactory() {
		client = new MongoClient("localhost", 27017);
		dataBase = client.getDatabase("ads-eventos");
	}

	/**
	 * Recupera a conexão com a base de dados
	 * @return
	 */
	public synchronized static MongoDatabase getDataBase() {
		
		if(dataBase == null) {
			new MongoClient();
		}
		
		return dataBase;
	}
	
}
