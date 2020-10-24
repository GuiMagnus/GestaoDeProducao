package br.com.fabrica.gerencia;

import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivo.aleatorio.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;




public class GerenciaProduto {
	
	public float precoFabricacao(Produto produto) {
		
		GerenciaHistoricoPreco gerenciaDeHistorico = new GerenciaHistoricoPreco();
		float precoFabricacao = 0;
		
		for (Insumo insumo : produto.getInsumos())
			precoFabricacao+= gerenciaDeHistorico.obtemPrecoMaisRecente(insumo.getHistorico());
		
		return precoFabricacao;
	}
	
	public float precoVenda() {
		
		return 0;
		
	}
	
	public List<String> obtemProdutosCadastrados(ArquivoProduto produtos) {
		List<String> listaProdutos = new ArrayList<String>();
		
		produtos.leProdutoNoArquivo();
		return listaProdutos;
	}
}
