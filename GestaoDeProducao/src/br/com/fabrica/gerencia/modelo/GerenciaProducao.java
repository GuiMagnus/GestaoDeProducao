package br.com.fabrica.gerencia.modelo;

import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.arquivos.ArquivoInsumoProduto;
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
		for(Insumo insumo : produto.getInsumos()) {
			custo += insumo.getPrecoUnitario();
		}
		
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
		float custo = verificaInsumosECalculaPreco(produto, quantidade), valor = 0;
		if(custo > 0)
			valor = produto.getMargemLucro() / 100 * custo;
		return valor;
	}
	
	/**
	 * Obt�m o valor total de venda que � poss�vel obter com essa produ��o.
	 * @param Produto - <code>Produto</code> : produto que ir� calcular o custo de produ��o
	 * @param quantidade - <code>int</code> : Quantidade de prudutos que ser�o produzidos 
	 * @return - <code>float</code> : valor total dos custos referentes a produ��o
	 */
	public float calculaVendaProduto(Produto produto, int quantidade) {
		float custo = verificaInsumosECalculaPreco(produto, quantidade), valor = 0;
		if(custo > 0)
			valor =  (custo/ quantidade) + ((produto.getMargemLucro()/100) * (custo/ quantidade));
		return valor;
	}
	
	/**
	 * Verifica se a quantidade de insumos presentes no estoque � o suficiente
	 * para realizar a produ��o. Se possuir insumos suficientes, calcula-se o 
	 * valor de referente a produ��o do produto
	 * @param produto <code>Produto</code> que deseja ser produzido
	 * @param quantidade <code>int</code> quantidade de produtos que deseja produzir
	 * @return <code>float</code> referente ao pre�o do produto
	 */
	public float verificaInsumosECalculaPreco(Produto produto, int quantidade) {
		ArquivoInsumo ai = new ArquivoInsumo();
		List<Insumo> insumos = ai.leInsumosNoArquivo();
		List<Insumo> listaInsumosProduto = new GerenciaProduto().obtemListaInsumosProduto(produto);
		float qtde = 0,valor = 0;
		if(insumos == null)
			return 0;
		
		if(listaInsumosProduto == null)
			return 0;
		
		else if(listaInsumosProduto != null) {
			for(Insumo insumoP : listaInsumosProduto) {
				for(Insumo insumo : insumos) {
					if(insumo.getNome().equalsIgnoreCase(insumoP.getNome())) {
						qtde = ((insumoP.getQuantidade() * quantidade)/produto.getTamanhoUnidade());
						if(insumo.getQuantidade() < qtde)
							return 0;
						valor += qtde * insumo.getPrecoUnitario();
						new ArquivoInsumoProduto().alteraInsumo(insumo.getCodigo(), insumo.getCodigoProduto(), qtde * insumo.getPrecoUnitario());
					
					}
				}
			}
		}
		return valor;
	}
	
}
