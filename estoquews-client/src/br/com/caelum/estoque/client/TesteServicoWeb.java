package br.com.caelum.estoque.client;

public class TesteServicoWeb {

	public static void main(String[] args) {
		
		EstoqueWS ws = new EstoqueWSService().getEstoqueWSImplPort();
		
		
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("JavaScript");
		filtro.setTipo(TipoItem.LIVRO.value());
		filtros.getFiltro().add(filtro);
		
		ListaItens listaItens = ws.todosOsItens(filtros);
		
		listaItens.getItem().forEach((item) -> {
			System.out.println(item.codigo);
		});
		
	}
	
}
