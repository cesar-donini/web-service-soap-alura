package br.com.caelum.estoque.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143100627881326860L;

	public AutorizacaoException(String string) {
		super(string);
	}
	
	public InfoFault getFaultInfo() {
	    return new InfoFault("Token invalido", new Date());
	}
	
}
