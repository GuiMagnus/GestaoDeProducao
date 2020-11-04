package br.com.fabrica.gerencia.modelo;

import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumo;
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
		float custo = verificaInsumos(produto, quantidade), valor = 0;
		if(custo > 0)
			valor = produto.getMargemLucro() * custo;
		return valor;
	}
	
	public float verificaInsumos(Produto produto, int quantidade) {
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
						new ArquivoInsumo().alteraInsumo(insumo, insumoP.getQuantidade() * quantidade);
					
					}
				}
			}
		}
		System.out.println("VALOR PROD->"+valor);
		return valor;
	}
	
}
