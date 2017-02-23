
package br.com.caelum.estoque.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EstoqueWS", targetNamespace = "http://ws.estoque.caelum.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EstoqueWS {


    /**
     * 
     * @param filtros
     * @return
     *     returns br.com.caelum.estoque.client.models.ListaItens
     */
    @WebMethod(operationName = "TodosOsItens", action = "http://ws.estoque.caelum.com.br/EstoqueWS/TodosOsItensRequest")
    @WebResult(name = "itens", targetNamespace = "")
    @RequestWrapper(localName = "TodosOsItens", targetNamespace = "http://ws.estoque.caelum.com.br/", className = "br.com.caelum.estoque.client.models.TodosOsItens")
    @ResponseWrapper(localName = "TodosOsItensResponse", targetNamespace = "http://ws.estoque.caelum.com.br/", className = "br.com.caelum.estoque.client.models.TodosOsItensResponse")
    @Action(input = "http://ws.estoque.caelum.com.br/EstoqueWS/TodosOsItensRequest", output = "http://ws.estoque.caelum.com.br/EstoqueWS/TodosOsItensResponse")
    public ListaItens todosOsItens(
        @WebParam(name = "filtros", targetNamespace = "http://ws.estoque.caelum.com.br/")
        Filtros filtros);

    /**
     * 
     * @param tokenUsuario
     * @param parameters
     * @return
     *     returns br.com.caelum.estoque.client.models.CadastrarItemResponse
     * @throws AutorizacaoFault
     */
    @WebMethod(operationName = "CadastrarItem", action = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItemRequest")
    @WebResult(name = "CadastrarItemResponse", targetNamespace = "http://ws.estoque.caelum.com.br/", partName = "result")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItemRequest", output = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItemResponse", fault = {
        @FaultAction(className = AutorizacaoFault.class, value = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItem/Fault/AutorizacaoException")
    })
    public CadastrarItemResponse cadastrarItem(
        @WebParam(name = "CadastrarItem", targetNamespace = "http://ws.estoque.caelum.com.br/", partName = "parameters")
        CadastrarItem parameters,
        @WebParam(name = "tokenUsuario", targetNamespace = "http://ws.estoque.caelum.com.br/", header = true, partName = "tokenUsuario")
        TokenUsuario tokenUsuario)
        throws AutorizacaoFault
    ;

}
