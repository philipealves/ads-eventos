package br.com.iftm.adseventos.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Singleton para criar e controlar as conexões com o MongoDB
 * @author ggarcia
 *
 */
public final class MongoDatabaseHelper {
	
	private static final MongoDatabaseHelper helper = new MongoDatabaseHelper();
	private static MongoClient client;
	private static MongoDatabase dataBase;
	private static List<String> collections;
	
	private MongoDatabaseHelper() {
		connect();
	}
	
	/**
	 * Realiza uma conexão no banco de dados MongoDB
	 */
	private void connect() {
		client = new MongoClient("localhost", 27017);
		collections = new ArrayList<>();
		dataBase = client.getDatabase("ads-eventos");
		dataBase.listCollectionNames()
			.iterator()
			.forEachRemaining(name -> collections.add(name));
	}
	
	/**
	 * Recupera a instância do helper de conexões com o MongoDB
	 * @return
	 */
	public static MongoDatabaseHelper getMongoDatabaseHelper() {
		return helper;
	}
	
	/**
	 * Valida se a coleção já existe
	 * @param collectionName
	 * @return
	 */
	private static Boolean isThisCollectionNew(String collectionName) {
		return !collections.contains(collectionName);
	}
	
	/**
	 * Cria uma coleção se não existir
	 * @param collectionName
	 */
	public static void createCollection(String collectionName) {
		if(isThisCollectionNew(collectionName)) {
			dataBase.createCollection(collectionName);
			collections.add(collectionName);
		}
	}
	
	public static void test() {
		collections.forEach(System.out::println);
	}
	
}
