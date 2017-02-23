package br.com.caelum.estoque.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TesteServicoWeb2 {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");

        Service service = Service.create(url, qname);
        
        EstoqueWS cliente = service.getPort(EstoqueWS.class);
        
        Filtro filtro = new Filtro();
        filtro.setTipo(TipoItem.LIVRO.value());
        filtro.setNome("Teste");
        Filtros filtros = new Filtros();
        filtros.getFiltro().add(filtro);
        
        ListaItens listaItens = cliente.todosOsItens(filtros);
        
        listaItens.getItem().forEach((value) -> {
        	System.out.println(value.getNome());
        });

	}

}
