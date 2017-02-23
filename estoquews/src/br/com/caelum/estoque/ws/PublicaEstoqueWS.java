package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		
		EstoqueWS estoqueWS = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("Serviço em pé...");
		
		Endpoint.publish(url, estoqueWS);

	}

}
