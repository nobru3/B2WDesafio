package br.com.bruno.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe respons�vel por uma representa��o de um planeta
 *
 */
public class Planeta 
{
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("clima")
	private String clima;
	
	@JsonProperty("terreno")
	private String terreno;
	
	private Integer id;
	private Integer numeroFilmes;
	
	/**
	 * Retorno o atributo ID
	 */
	public Integer getId( )
	{
		return this.id;
	}
	
	public void setNumFilmes( Integer numFilmes )
	{
		this.numeroFilmes = numFilmes;
	}
	
	/**
	 * Retorno o atributo N�mero de Filmes
	 */
	public Integer getNumFilmes( )
	{
		return this.numeroFilmes;
	}
	
	public void setId( Integer id )
	{
		this.id = id;
	}
	
	/**
	 * Retorno o atributo Nome
	 */
	public String getNome( )
	{
		return this.nome;
	}
	
	public void setNome( String nome )
	{
		this.nome = nome;
	}
	
	/**
	 * Retorno o atributo Clima
	 */
	public String getClima( )
	{
		return this.clima;
	}
	
	public void setClima( String clima )
	{
		this.clima = clima;
	}
	
	/**
	 * Retorno o atributo Terreno
	 */
	public String getTerreno( )
	{
		return this.terreno;
	}
	
	public void setTerreno( String terreno )
	{
		this.terreno = terreno;
	}
}
