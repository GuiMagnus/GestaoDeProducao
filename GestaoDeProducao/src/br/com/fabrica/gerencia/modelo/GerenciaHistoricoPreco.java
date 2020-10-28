package br.com.fabrica.gerencia.modelo;

import static br.com.fabrica.validacoes.Data.transformaCalendarEmString;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.modelo.HistoricoPreco;

/**
 * Classe respons�vel por gerenciar o hist�rico de pre�os referente aos insumos
 * e aos produtos.
 * @author Rafaela
 *
 */
public class GerenciaHistoricoPreco {
	/**
	 * Insere o novo pre�o e a nova data no hist�rico de pre�o. A data a ser
	 * atribuida sempre ser� a data do dia.
	 * @param preco - <code>float</code> : novo pre�o a ser cadastrado.
	 * @param historico - <code>List</code> : lista que ir� receber o novo pre�o;
	 */
	public void insereHistoricoPreco(float preco, List<HistoricoPreco> historico, int codigo) {
		Calendar hoje = Calendar.getInstance();
		String data = transformaCalendarEmString(hoje);
		HistoricoPreco hp = new HistoricoPreco(preco, data);
		hp.setCodigoReferenciaDeDado(codigo);
		historico.add(hp);
	}
	
	/**
	 * Obt�m o pre�o e a data mais recente.
	 * @param historicoPrecoshistorico - <code>List</code> : lista que cont�m os pre�os
	 * @return - <code>HistoricoPreco</code> : pre�o e data mais recente que foram cadastrados.
	 */
	public HistoricoPreco obtemPrecoRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1);
 	}
	
	/**
	 * Obt�m o pre�o mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que cont�m os pre�os
	 * @return - <code>float</code> :pre�o mais recente que foi cadastrado.
	 */
	public float obtemPrecoMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getPreco();
 	}
	
	/**
	 * Obt�m a data mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que cont�m os pre�os
	 * @return - <code>String</code> : data mais recente que foi cadastrada.
	 */
	public String obtemDataMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getData();
 	}
}
