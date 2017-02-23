package br.com.caelum.estoque.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.TipoItem;

public class Marshall {

	public static void main(String[] args) throws JAXBException {
		Item item = new Item.Builder().comNome("MEAN").comCodigo("MEA")
				.comQuantidade(20).comTipo(TipoItem.LIVRO.getNome()).build();

		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(item, new File("item.xml"));
		
	}

}
