package br.com.iftm.adseventos.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.iftm.adseventos.dao.interfaces.IGenericDao;

public class MongoDBGenericDao<T> implements IGenericDao<T> {
	
	private Class<T> classType;
	private final ObjectMapper mapper;
	private final MongoCollection<Document> collection;
	private final MongoDatabase database;
	private final List<String> collections;

	public MongoDBGenericDao(String collectionName) {
		this.collections = new ArrayList<>();
		this.mapper = new ObjectMapper();
		this.database = MongoDBFactory.getDataBase();
		this.database.listCollectionNames()
				.iterator()
				.forEachRemaining(name -> collections.add(name));
		this.collection = createCollection(collectionName);
	}
			
	/**
	 * Transforma um T em um Document
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private Document entityToDocument(T entity) throws Exception {
		String json = mapper.writeValueAsString(entity);
		return Document.parse(json);
	}
	
	/**
	 * Transforma um Documento em um T
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private T documentToEntity(Document document) throws Exception {
		String json = document.toJson();
		return mapper.readValue(json, classType);
	}
	
	/**
	 * Valida se a coleção já existe
	 * @param collectionName
	 * @return
	 */
	private Boolean isThisCollectionNew(String collectionName) {
		return !collections.contains(collectionName);
	}
	
	/**
	 * Cria uma coleção se não existir e recupera a mesma
	 * @param collectionName
	 * @return 
	 */
	private MongoCollection<Document> createCollection(String collectionName) {
		
		if(isThisCollectionNew(collectionName)) {
			database.createCollection(collectionName);
			collections.add(collectionName);
		}
		
		return database.getCollection(collectionName);
	}
	
	/* (non-Javadoc)
	 * @see br.com.iftm.adseventos.dao.IGenericDao#save(T)
	 */
	@Override
	public void save(T entity) throws Exception {
		Document document = entityToDocument(entity);
		collection.insertOne(document);
	}

	@Override
	public void update(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() throws Exception {
		List<T> listAll = new ArrayList<>();
		FindIterable<Document> iterable = collection.find();
		
		iterable.forEach(new Block<Document>() {
				
			@Override
			public void apply(Document document) {
				try {
					listAll.add(documentToEntity(document));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		return listAll;
			
	}

	@Override
	public T findByExample(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
