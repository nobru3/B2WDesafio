package br.com.bruno.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.bruno.dao.Dao;
import br.com.bruno.entidade.Planeta;

@Path("/planetas")
public class PlanetasServices 
{
	private Dao m_dao;
	
	public PlanetasServices( )
	{
		m_dao = new Dao("StarWars", "Planetas" );
	}
	
	/**
	 * Utilizado para testes de integração
	 */
	public PlanetasServices( String strCollection )
	{
		m_dao = new Dao( "StarWars", strCollection );
	}
	
	@GET
	@Path("/listar")
	@Produces( MediaType.APPLICATION_JSON )
	public Response listaPlanetas( @QueryParam("nome") String nome, @QueryParam("id") Integer id )
	{
		try
		{
			return Response.ok( ).entity( m_dao.listaPlanetas( nome, id ) ).build( );
		}
		catch( Exception e )
		{
			return Response.serverError( ).entity( e.getMessage( ) ).build( );
		}
	}
	
	@POST
	@Path("/adcionar")
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response adcionarPlanetas( Planeta p )
	{
		try
		{
			return Response.ok( ).entity( m_dao.adcionarPlanetas( p ) ).build( );
		}
		catch( Exception e )
		{
			return Response.serverError( ).entity( e.getMessage( ) ).build( );
		}
	}
	
	@PUT
	@Path("/remover/{id}")
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response removerPlanetas( @PathParam("id") int id )
	{
		try
		{
			return Response.ok( ).entity( m_dao.removerPlanetas( id ) ).build( );
		}
		catch( Exception e )
		{
			return Response.serverError( ).entity( e.getMessage( ) ).build( );
		}
	}
}
