package br.com.fabrica.gerencia;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;

public class GerenciaVenda {
	
	public float calculaValorTotalProduto(Produto produto, int quantidade) {
		float valor = produto.getPrecoVenda() * quantidade;
		return valor;
	}
	
	//Conferir
	public float calculaValorTotalVenda(Venda venda) {
		float valor = 0;
		for(Produto produto : venda.getProdutos())
			valor += calculaValorTotalProduto(produto, venda.getQuantidade());
		return valor;
	}
}
