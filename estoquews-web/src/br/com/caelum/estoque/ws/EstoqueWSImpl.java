package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.ws.Item.ItemBuilder;

@WebService(endpointInterface="br.com.caelum.estoque.ws.EstoqueWS", serviceName="EstoqueWS")
public class EstoqueWSImpl implements EstoqueWS {

	@Override
	public ListaItens todosOsItens(Filtros filtros) {
		ListaItens listaItens = new ListaItens();
		listaItens.item = getItems();
		return listaItens;
	}

	@Override
	public CadastrarItemResponse cadastrarItem(CadastrarItem parameters, TokenUsuario tokenUsuario)
			throws AutorizacaoFault {
		CadastrarItemResponse item = new CadastrarItemResponse();
		item.setItem(getItems().get(0));
		return item;
	}

	private List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		items.add(new ItemBuilder()
				.comCodigo("JS1")
				.comNome("JavaScript")
				.comQuantidade(20)
				.comTipo(TipoItem.LIVRO)
				.build());
		items.add(new ItemBuilder()
				.comCodigo("MEA")
				.comNome("MEAN")
				.comQuantidade(10)
				.comTipo(TipoItem.LIVRO)
				.build());
		items.add(new ItemBuilder()
				.comCodigo("IPH")
				.comNome("Iphone 6s")
				.comQuantidade(20)
				.comTipo(TipoItem.CELULAR)
				.build());
		return items;
	}
}
