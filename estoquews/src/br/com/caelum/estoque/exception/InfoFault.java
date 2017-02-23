package br.com.caelum.estoque.exception;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	@XmlElement(name="dataerro")
	private Date dataErro;
	
	@XmlElement(name="mensagem")
	private String mensagem;
	
	public InfoFault(String mensagem, Date dataErro) {
		this.dataErro = dataErro;
		this.mensagem = mensagem;
	}

	InfoFault() {
		
	}
}
