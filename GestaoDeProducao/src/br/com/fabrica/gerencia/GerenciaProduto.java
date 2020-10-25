package br.com.fabrica.gerencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;

public class GerenciaProduto {
	
	public float calculaPrecoFabricacao(Produto produto) {
		GerenciaHistoricoPreco gerenciaDeHistorico = new GerenciaHistoricoPreco();
		float precoFabricacao = 0;
		
		for (Insumo insumo : produto.getInsumos())
			precoFabricacao += gerenciaDeHistorico.obtemPrecoMaisRecente(insumo.getHistorico());
		
		return precoFabricacao;
	}
	
	public float calculaPrecoVenda(Produto produto) {
		float precoFabricacao = calculaPrecoFabricacao(produto);
		float precoVenda = precoFabricacao + precoFabricacao * (produto.getMargemLucro() / 100);
		return precoVenda;
	}
	
	public float calculaAumentoPercentual(Produto produto) {
		float valorAumento = produto.getPrecoVenda() - produto.getPrecoFabricacao();
		
		float margem = (valorAumento / produto.getPrecoFabricacao()) / 100;
		
		return margem;
	}
	
	public List<String> obtemProdutosCadastrados(ArquivoProduto arquivoProdutos) {
		List<String> listaProdutos = new ArrayList<String>();
		try {
			for (int i = 0; i < arquivoProdutos.recordQuantity(); i++) 
				listaProdutos.add(arquivoProdutos.leProdutoNoArquivo(i).getNome());
			return listaProdutos;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
