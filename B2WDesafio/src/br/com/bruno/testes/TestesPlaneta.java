package br.com.bruno.testes;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.Test;

import br.com.bruno.entidade.Planeta;
import br.com.bruno.rest.PlanetasServices;

public class TestesPlaneta 
{
	 @Test
	 public void adcionarPlaneta( ) 
	 {
	     PlanetasServices p = new PlanetasServices( "PlanetasTestes" );
	     
	     Response response = p.adcionarPlanetas( new Planeta( "Planeta Teste", "Clima Teste", "Terreno Teste" ) );
		 
		 assertTrue( response.getStatus( ) == 200 );
	 }
	 
	 @Test
	 public void listarPlanetaPorID( ) 
	 {
		 PlanetasServices p = new PlanetasServices( "PlanetasTestes" );
	     
	     Response response = p.listaPlanetas( "", 1 );
	     
		 assertTrue( response.getStatus( ) == 200 );
	 }
	 
	 @Test
	 public void listarPlanetaPorNome( ) 
	 {
		 PlanetasServices p = new PlanetasServices( "PlanetasTestes" );
	     
	     Response response = p.listaPlanetas( "Naboo", 0 );
	     
		 assertTrue( response.getStatus( ) == 200 );
	 }
	 
	 @Test
	 public void listarPlanetaSemFiltro( ) 
	 {
		 PlanetasServices p = new PlanetasServices( "PlanetasTestes" );
	     
	     Response response = p.listaPlanetas( "", 0 );
	     
		 assertTrue( response.getStatus( ) == 200 );
	 }
	 
	 @Test
	 public void removerPlanetas( ) 
	 {
		 PlanetasServices p = new PlanetasServices( "PlanetasTestes" );
	     
	     Response response = p.removerPlanetas( 0 );
		 
		 assertTrue( response.getStatus( ) == 200 );
	 }
}
