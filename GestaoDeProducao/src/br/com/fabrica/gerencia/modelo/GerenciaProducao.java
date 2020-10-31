package br.com.fabrica.gerencia.modelo;

import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;

/**
 * Classe responsável por gerenciar a produção de produtos
 * @author Rafaela
 *
 */
public class GerenciaProducao {
	
	/**
	 * Obtém o custo total da produção de um determinado produto.
	 * @param Produto - <code>Produto</code> : produto que irá calcular o custo de produção
	 * @param quantidade - <code>int</code> : Quantidade de prudutos que serão produzidos 
	 * @return - <code>float</code> : valor total dos custos referentes a produção
	 */
	public float calculaCustoTotalProducao(Produto produto, int quantidade) {
		float custo = 0;
		for(Insumo insumo : produto.getInsumos())
			custo += insumo.getPrecoUnitario();
		
		custo *= quantidade;
		return custo;
	}
	
	/**
	 * Obtém o valor total de venda que é possível obter com essa produção.
	 * @param Produto - <code>Produto</code> : produto que irá calcular o custo de produção
	 * @param quantidade - <code>int</code> : Quantidade de prudutos que serão produzidos 
	 * @return - <code>float</code> : valor total dos custos referentes a produção
	 */
	public float calculaValorTotalVenda(Produto produto, int quantidade) {
		float custo = 0;
		GerenciaProduto gp = new GerenciaProduto();
		custo += gp.calculaPrecoVenda(produto) * quantidade;
		
		return custo;
	}
	
	public boolean verificaQuantidadeInsumo(Produto produto, int quantidade) {
		ArquivoInsumo ai = new ArquivoInsumo();
		List<Insumo> insumos = ai.leInsumosNoArquivo();
		List<Insumo> listaInsumosProduto = new GerenciaProduto().obtemListaInsumosProduto(produto);
		//System.out.println("CHEGUEI LISTA");
		if(insumos == null) {
			//System.out.println("INSUMOS");
			return false;
		}
		if(listaInsumosProduto == null) {
			//System.out.println("INSUMOS PRODUTO");
			return false;
		}
		else if(listaInsumosProduto != null) {
			for(Insumo insumoP : listaInsumosProduto) {
				for(Insumo insumo : insumos) {
				//	System.out.println("Insumo:"+insumo.getNome());
					//System.out.println("Insumos Produto:"+insumoP.getNome());
					if(insumo.getNome().equalsIgnoreCase(insumoP.getNome())) {
						//System.out.println("Quantidade:"+insumo.getQuantidade());
						//System.out.println("Resultado:"+((insumoP.getQuantidade() * quantidade)/produto.getTamanhoUnidade()));
						if(insumo.getQuantidade() < ((insumoP.getQuantidade() * quantidade)/produto.getTamanhoUnidade()))
							return false;
					}
				}
			}
		}
		
		return true;
	}
}
