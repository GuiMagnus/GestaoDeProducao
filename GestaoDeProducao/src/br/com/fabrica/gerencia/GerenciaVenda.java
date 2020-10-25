package br.com.fabrica.gerencia;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;

/**
 * Classe respons�vel por gerenciar a venda de produtos.
 * @author Rafaela
 *
 */
public class GerenciaVenda {
	
	/**
	 * Calcula o valor total do produto que est� sendo vendido.
	 * @param produto - <code>Produto</code> : Produto que ser� vendido
	 * @param quantidade - <code>int</code> : Quantidade do produto que ser� vendido. 
	 * @return - <code>float</code> : valor total de venda do produto
	 */
	public float calculaValorTotalProduto(Produto produto, int quantidade) {
		float valor = produto.getPrecoVenda() * quantidade;
		return valor;
	}
	
	//Conferir
	/**
	 * Calcula o valor total da venda. Esse valor � a soma de todos os produtos que
	 * est�o sendo vendidos.
	 * @param venda - <code>Venda</code> : Cont�m informa��es sobre uma determinada venda
	 * @return - <code>float</code> : Valor total da venda.
	 */
	public float calculaValorTotalVenda(Venda venda) {
		float valor = 0;
		for(Produto produto : venda.getProdutos())
			valor += calculaValorTotalProduto(produto, venda.getQuantidade());
		return valor;
	}
}
