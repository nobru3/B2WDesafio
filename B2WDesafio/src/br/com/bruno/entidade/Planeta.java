package br.com.bruno.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe responsável por uma representação de um planeta
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
	private Integer filmes;
	
	/**
	 * Retorno o atributo ID
	 */
	public Integer getId( )
	{
		return this.id;
	}
	
	public void setFilmes( Integer filmes )
	{
		this.filmes = filmes;
	}
	
	/**
	 * Retorno o atributo Número de Filmes
	 */
	public Integer getFilmes( )
	{
		return this.filmes;
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
