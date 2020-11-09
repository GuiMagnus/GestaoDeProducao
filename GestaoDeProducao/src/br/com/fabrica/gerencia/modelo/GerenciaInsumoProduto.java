package br.com.fabrica.gerencia.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumoProduto;
import br.com.fabrica.modelo.Insumo;

/**
 * Classe responsável por gerenciar os insumos
 * @see Insumo
 * @author Rafaela e Guilherme
 *
 */
public class GerenciaInsumoProduto {
	/**
	 * Obtem os insumos referentes a um produto.
	 * @param codigo - <code>int</code> código do produto.
	 * @return <code>List</code> lista de insumos de um produto
	 */
	public List<Insumo> obtemInsumosProduto(int codigo){
		ArquivoInsumoProduto arquivoInsumo = new ArquivoInsumoProduto();
		List<Insumo> lista = arquivoInsumo.leInsumosNoArquivo();
		List<Insumo> listaInsumoProduto = null;
		if(lista != null)
			listaInsumoProduto = new ArrayList<Insumo>();
			for(Insumo insumo : lista) {
				if(insumo.getCodigoProduto() == codigo)
					listaInsumoProduto.add(insumo);
				
			}
		return listaInsumoProduto;
	}
	
}
