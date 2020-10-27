package br.com.fabrica.gerencia.modelo;

import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;

/**
 * Classe respons�vel por gerenciar a produ��o de produtos
 * @author Rafaela
 *
 */
public class GerenciaProducao {
	
	/**
	 * Obt�m o custo total da produ��o de um determinado produto.
	 * @param Produto - <code>Produto</code> : produto que ir� calcular o custo de produ��o
	 * @param quantidade - <code>int</code> : Quantidade de prudutos que ser�o produzidos 
	 * @return - <code>float</code> : valor total dos custos referentes a produ��o
	 */
	public float calculaCustoTotalProducao(Produto produto, int quantidade) {
		float custo = 0;
		for(Insumo insumo : produto.getInsumos())
			custo += insumo.getPrecoUnitario();
		
		custo *= quantidade;
		return custo;
	}
	
	/**
	 * Obt�m o valor total de venda que � poss�vel obter com essa produ��o.
	 * @param Produto - <code>Produto</code> : produto que ir� calcular o custo de produ��o
	 * @param quantidade - <code>int</code> : Quantidade de prudutos que ser�o produzidos 
	 * @return - <code>float</code> : valor total dos custos referentes a produ��o
	 */
	public float calculaValorTotalVenda(Produto produto, int quantidade) {
		float custo = 0;
		GerenciaProduto gp = new GerenciaProduto();
		custo += gp.calculaPrecoVenda(produto) * quantidade;
		
		return custo;
	}
}