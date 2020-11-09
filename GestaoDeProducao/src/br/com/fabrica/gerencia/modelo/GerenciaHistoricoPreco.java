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
	 * @param codigo - <code>int</code> : código referente a informação que o dado pertence.
	 * @param arquivo - <code>String</code> : arquivo onde serão salvos os dados.
	 * @return <code>true</code> caso consiga inserir. <code>false</code> caso não consiga.
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
	 * @param codigo <code>int</code> código Referência relativo ao dado que deseja obter o preço
	 * @return <code>HistoricoPreco</code> : preço e data mais recente que foram cadastrados.
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
