package br.com.fabrica.gerencia;

import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;

public class GerenciaProducao {
	
	public float calculaCustoTotalProducao(Produto produto, Producao producao) {
		float custo = 0;
		for(Insumo insumo : produto.getInsumos())
			custo += insumo.getPrecoUnitario();
		
		custo *= producao.getQuantidade();
		return custo;
	}
	
	public float calculaPrecoTotalVenda(Produto produto, Producao producao) {
		float custo = 0;
		GerenciaProduto gp = new GerenciaProduto();
		custo += gp.calculaPrecoVenda(produto) * producao.getQuantidade();
		
		return custo;
	}
}
