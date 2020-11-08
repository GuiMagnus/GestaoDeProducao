package br.com.fabrica.gerencia.modelo;

import static br.com.fabrica.validacoes.Data.transformaCalendarEmString;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoHistoricoPreco;
import br.com.fabrica.modelo.HistoricoPreco;

/**
 * Classe responsável por gerenciar o histórico de preços referente aos insumos
 * e aos produtos.
 * @see HistoricoPreco
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
	public boolean insereHistoricoPreco(float preco,  int codigo, String arquivo) {
		ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
		Calendar hoje = Calendar.getInstance();
		String data = transformaCalendarEmString(hoje);
		HistoricoPreco hp = new HistoricoPreco(preco, data);
		hp.setCodigoReferenciaDeDado(codigo);
		boolean cadastrado = ahp.escreveHistoricoNoArquivo(hp, arquivo);
		if(cadastrado)
			return true;
		return false;
	}

	/**
	 * Obtém o preço e a data mais antiga.
	 * @param <code>int</code> código
	 * @return - <code>HistoricoPreco</code> : preço e data mais recente que foram cadastrados.
	 */
	public HistoricoPreco obtemPrecoAntigo(int codigo) {
		ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
		if(ahp.obtemHistorico(codigo).size() > 0) {
			HistoricoPreco hp = ahp.obtemHistorico(codigo).get(0);
			return hp;
		}
		return null;
		
 	}
	/**
	 * Obtém o preço mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que contém os preços
	 * @return - <code>float</code> :preço mais recente que foi cadastrado.
	 */
	public float obtemPrecoMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size()).getPreco();
 	}
	
}
