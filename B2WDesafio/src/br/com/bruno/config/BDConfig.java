package br.com.bruno.config;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Classe responsável por disponibilizar uma conexão com o banco de dados.
 *
 */
public class BDConfig 
{
	public static MongoCollection<Document> getConnection( String nomeBanco, String nomeCollection )
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://bruno:bruno@starwars-6okl6.mongodb.net/test?retryWrites=true&w=majority");

		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient( uri );
		
		MongoDatabase bd                     = mongoClient.getDatabase( nomeBanco      );
		MongoCollection<Document> collection = bd.getCollection       ( nomeCollection );
			
		return collection;
	}
}
