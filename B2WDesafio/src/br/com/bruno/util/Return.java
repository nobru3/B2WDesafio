package br.com.bruno.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude( Include.NON_NULL)
@JsonPropertyOrder({ "returnId", "returnMessage"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Return 
{
	
	@XmlElement(name="returnId", required = true)
	private int m_returnId;
	
	@XmlElement(name="returnMessage", required = true)
	private String m_returnMessage;
	
	public Return( )
	{
		
	}
	
	public Return( int returnId, String message )
	{
		m_returnId      = returnId;
		m_returnMessage = message;
	}
}
