package br.com.bruno.dao;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;

import br.com.bruno.config.BDConfig;
import br.com.bruno.entidade.Planeta;
import br.com.bruno.util.Return;

public class Dao 
{
	MongoCollection<Document> m_collection;
	
	public Dao( String nomeBanco, String nomeCollection )
	{
		m_collection = BDConfig.getConnection( nomeBanco, nomeCollection ); 
	}
	
	public List<Planeta> listaPlanetas( String nome, Integer id ) throws Exception
	{
		List<Planeta> planetas = new ArrayList<Planeta>();
		BasicDBObject filter   = new BasicDBObject( );
		
		if( nome != null && !nome.isEmpty( ) )
			filter.put( "nome", nome );
		
		if( id != null )
			filter.put( "_id", id );
		
		FindIterable <Document> findIterable = m_collection.find( filter );
		
		for ( Document doc : findIterable )
        {
            Planeta p = new Planeta( );
            
            p.setId       ( doc.getInteger( "_id"     )     );
            p.setNome     ( doc.getString ( "nome"    )     ); 
            p.setClima    ( doc.getString ( "clima"   )     );
            p.setTerreno  ( doc.getString ( "terreno" )     );
            p.setNumFilmes( coletaQtdFilmes( p.getNome( ) ) );
            
            planetas.add( p );
        }
		
		return planetas;
	}
	
	private Integer coletaQtdFilmes( String nomePlaneta ) throws Exception
	{
		Client client = ClientBuilder.newClient( new ClientConfig( ).register( LoggingFilter.class ) );
		 
		WebTarget webTarget = client.target( "https://swapi.co/api/" ).path( "planets" ).queryParam( "search", nomePlaneta );
		 
		Invocation.Builder invocationBuilder = webTarget.request( MediaType.APPLICATION_JSON);
		String             response          = invocationBuilder.get( String.class );
		
		System.out.println( response );
		//System.out.println( doc.get("results.Document.name") );
		
		return 0;
	}
	
	private Object buscaIdPlaneta(  ) throws Exception
	{
		MongoCollection<Document> collection = BDConfig.getConnection( "StarWars", "Contadores" );
		
	    BasicDBObject find = new BasicDBObject( );
	    
	    find.put("_id", "idPlanetas" );
	    
	    BasicDBObject update = new BasicDBObject( );
	    
	    update.put( "$inc", new BasicDBObject( "seq", 1 ) );
	    
	    Document doc = collection.findOneAndUpdate( find, update, new FindOneAndUpdateOptions( ).returnDocument( ReturnDocument.AFTER ) );
		    
	    return doc.get( "seq" );
	}
	
	/**
	 * Adciona planetas no banco de dados
	 * @param p {@link Planeta}
	 * @return
	 * @throws Exception
	 */
	public Return adcionarPlanetas( Planeta p ) throws Exception
	{
		try
		{
			int idPlaneta = (int) buscaIdPlaneta( );
			
			Document doc = new Document( );
			
			doc.put( "nome",    p.getNome   ( ) );
			doc.put( "clima",   p.getClima  ( ) );
			doc.put( "terreno", p.getTerreno( ) );
			
			doc.put( "_id",  idPlaneta );
			
			m_collection.insertOne( doc );
			
			return new Return( idPlaneta, "Planeta inclu�do com sucesso." );
		}
		catch ( Exception e )
		{
			return new Return( 0, e.getMessage( ) );
		}
	}
	
	public Return removerPlanetas( int id ) throws Exception
	{
		try
		{
			BasicDBObject find = new BasicDBObject();
		    find.put("_id", id );
			
			m_collection.deleteOne( find );
			
			return new Return( id, "Planeta removido com sucesso." );
		}
		catch ( Exception e )
		{
			return new Return( id, e.getMessage( ) );
		}
	}
}