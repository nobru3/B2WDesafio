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
	@GET
	@Path("/listar")
	@Produces( MediaType.APPLICATION_JSON )
	public Response listaPlanetas( @QueryParam("nome") String nome, @QueryParam("id") Integer id )
	{
		try
		{
			Dao dao = new Dao( "StarWars", "Planetas" );
			
			return Response.ok( ).entity( dao.listaPlanetas( nome, id ) ).build( );
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
			Dao dao = new Dao( "StarWars", "Planetas" );
			
			return Response.ok( ).entity( dao.adcionarPlanetas( p ) ).build( );
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
	public Response adcionarPlanetas( @PathParam("id") int id )
	{
		try
		{
			Dao dao = new Dao( "StarWars", "Planetas" );
			
			return Response.ok( ).entity( dao.removerPlanetas( id ) ).build( );
		}
		catch( Exception e )
		{
			return Response.serverError( ).entity( e.getMessage( ) ).build( );
		}
	}
}
