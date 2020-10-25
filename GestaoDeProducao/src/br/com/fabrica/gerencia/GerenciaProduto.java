package br.com.fabrica.gerencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;

/**
 * Classe responsável por gerenciar os produtos que a fábrica possui.
 * @author Rafaela
 *
 */
public class GerenciaProduto {
	
	/**
	 * Calcula o valor que custa produzir uma unidade de um determinado produto.
	 * @param produto - <code>Produto</code> : produto que irá obter o valor dos custos.
	 * @return - <code>float</code> : valor de fabricação de um produto.
	 */
	public float calculaPrecoFabricacao(Produto produto) {
		GerenciaHistoricoPreco gerenciaDeHistorico = new GerenciaHistoricoPreco();
		float precoFabricacao = 0;
		
		for (Insumo insumo : produto.getInsumos())
			precoFabricacao += gerenciaDeHistorico.obtemPrecoMaisRecente(insumo.getHistorico());
		
		return precoFabricacao;
	}
	
	/**
	 * Calcula o valor de venda de um determinado produto.
	 * @param produto - <code>Produto</code> : Produto que irá obter o valor de venda.
	 * @return - <code>float</code> : valor de venda de um produto.
	 */
	public float calculaPrecoVenda(Produto produto) {
		float precoFabricacao = calculaPrecoFabricacao(produto);
		float precoVenda = precoFabricacao + precoFabricacao * (produto.getMargemLucro() / 100);
		return precoVenda;
	}
	
	/**
	 * Calcula o valor do aumento percentual de um produto.
	 * @param produto - <code>Produto</code> : Produto que terá seu percentual alterado.
	 * @return - <code>float</code> : novo percentual de lucro do produto.
	 */
	public float calculaAumentoPercentual(Produto produto) {
		float valorAumento = produto.getPrecoVenda() - produto.getPrecoFabricacao();
		
		float margem = (valorAumento / produto.getPrecoFabricacao()) / 100;
		
		return margem;
	}
	
	/**
	 * Obtém a lista de produtos cadastrados.
	 * @param arquivoProdutos - <code>ArquivoProdutos</code> : Arquivo onde os 
	 * produtos estão salvos
	 * @return - <code>List</code> : Lista de produtos cadastrados
	 */
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
