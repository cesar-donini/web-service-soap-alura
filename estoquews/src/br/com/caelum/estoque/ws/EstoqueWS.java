package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.exception.AutorizacaoException;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED)
public class EstoqueWS {

	private ItemDao itemDao = new ItemDao();
	
	private TokenDao tokenDao = new TokenDao();
	
	@WebMethod(operationName="TodosItens")
	@ResponseWrapper(localName="itens")
	@WebResult(name="item")
	public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) {
		return itemDao.todosItens(filtros.getLista());
	}
	
	@WebMethod(operationName="CadastrarItem")
	@WebResult(name="item")
	public Item cadastrarItem(
			@WebParam(name="tokenUsuario", header=true) TokenUsuario tokenUsuario,
			@WebParam(name="item") Item item)
					throws AutorizacaoException {
		
		if (!tokenDao.ehValido(tokenUsuario)) {
			throw new AutorizacaoException("Erro ao Autenticar Usuário!");
		}
		
		new ItemValidador(item).validate();
		
		itemDao.cadastrar(item);
		
		return item;
	}
	
}
