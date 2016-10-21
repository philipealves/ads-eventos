/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iftm.adseventos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * Classe fábria de conexão com o banco de dados
 * @author Gabriel
 */
public class ConnectionFactory {
    
    private static EntityManagerFactory emf;
    private static ConnectionFactory connection;
    
    private ConnectionFactory() {
        emf = Persistence.createEntityManagerFactory("ADSEventosPU");
    }
    
    public synchronized static EntityManager getEntityManager() {
        
        if(connection == null) {
            connection = new ConnectionFactory();
        }
        
        return emf.createEntityManager();
        
    }
    
    
}
