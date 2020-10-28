package br.com.fabrica.gerencia.modelo;

import static br.com.fabrica.validacoes.Data.transformaCalendarEmString;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.modelo.HistoricoPreco;

/**
 * Classe responsável por gerenciar o histórico de preços referente aos insumos
 * e aos produtos.
 * @author Rafaela
 *
 */
public class GerenciaHistoricoPreco {
	/**
	 * Insere o novo preço e a nova data no histórico de preço. A data a ser
	 * atribuida sempre será a data do dia.
	 * @param preco - <code>float</code> : novo preço a ser cadastrado.
	 * @param historico - <code>List</code> : lista que irá receber o novo preço;
	 */
	public void insereHistoricoPreco(float preco, List<HistoricoPreco> historico, int codigo) {
		Calendar hoje = Calendar.getInstance();
		String data = transformaCalendarEmString(hoje);
		HistoricoPreco hp = new HistoricoPreco(preco, data);
		hp.setCodigoReferenciaDeDado(codigo);
		historico.add(hp);
	}
	
	/**
	 * Obtém o preço e a data mais recente.
	 * @param historicoPrecoshistorico - <code>List</code> : lista que contém os preços
	 * @return - <code>HistoricoPreco</code> : preço e data mais recente que foram cadastrados.
	 */
	public HistoricoPreco obtemPrecoRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1);
 	}
	
	/**
	 * Obtém o preço mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que contém os preços
	 * @return - <code>float</code> :preço mais recente que foi cadastrado.
	 */
	public float obtemPrecoMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getPreco();
 	}
	
	/**
	 * Obtém a data mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que contém os preços
	 * @return - <code>String</code> : data mais recente que foi cadastrada.
	 */
	public String obtemDataMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getData();
 	}
}
