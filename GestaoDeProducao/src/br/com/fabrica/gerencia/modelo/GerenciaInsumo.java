package br.com.fabrica.gerencia.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.modelo.Insumo;

/**
 * Classe responsável por gerenciar os insumos
 * @see Insumo
 * @author Rafaela
 *
 */
public class GerenciaInsumo {
	
	/**
	 * Obtém o preço dos insumos cadastrados no estoque
	 * @param insumosProduto lista de insumos de um produto
	 * @return lista de insumos de um produto que também está presente no estoque
	 */
	public List<Insumo> obtemPrecoInsumosEstoque(List<Insumo> insumosProduto){
		ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
		List<Insumo> listaEstoque = arquivoInsumo.leInsumosNoArquivo();
		List<Insumo> insumosEstoqueDeUmProduto = new ArrayList<Insumo>();
		for (Insumo insumoProduto : insumosProduto)
			for (Insumo insumoEstoque : listaEstoque) 
				if(insumoProduto.getNome().equalsIgnoreCase(insumoEstoque.getNome()))
					insumosEstoqueDeUmProduto.add(insumoEstoque);
		
		return insumosEstoqueDeUmProduto;
	}
}
