package br.com.fabrica.gerencia.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.modelo.Insumo;

/**
 * Classe respons�vel por gerenciar os insumos
 * @author Rafaela
 *
 */
public class GerenciaInsumo {
	//metedos para altera��o de pre�o e para adicionar as infos no hist�rico
	/**
	 * Obtem os insumos referentes a um produto.
	 * @param codigo - <code>int</code> c�digo do produto.
	 * @return <code>List</code> lista de insumos de um produto
	 */
	public List<Insumo> obtemInsumosProduto(int codigo){
		ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
		List<Insumo> lista = arquivoInsumo.leInsumosNoArquivo();
		List<Insumo> listaInsumoProduto = new ArrayList<Insumo>();
		if(lista != null)
			for(Insumo insumo : lista) {
				if(insumo.getCodigoProduto() == codigo)
					listaInsumoProduto.add(insumo);
			}
		return listaInsumoProduto;
	}
	
	/**
	 * Verifica se determinado insumo j� foi cadastrado.
	 * @param nome - <code>String</code> nome do insumo que deseja verificar.
	 * @param insumos - <code>List</code> lista de insumos de um produto.
	 * @return <code>boolean</code> Retorna <code>true</code> caso encontre. 
	 * Caso n�o escontre, retorna <code>false</code>
	 */
	public boolean verificaInsumoCadastrado(String nome, List<Insumo> insumos) {
		for(Insumo insumo : insumos) {
			if(insumo.getNome().equalsIgnoreCase(nome))
				return true;
		}
		return false;
	}
	//????
	public boolean alteraPrecoInsumo(List<Insumo> insumos, float novoPreco, int codigoInsumo) {
		for(Insumo insumo : insumos) {
			if(insumo.getCodigo() == codigoInsumo) {
				insumo.setPrecoUnitario(novoPreco);
				return true;
			}
		}
		return false;
	}
	
}
