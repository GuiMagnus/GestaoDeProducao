package br.com.fabrica.gerencia.modelo;

import static br.com.fabrica.validacoes.Data.transformaCalendarEmString;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoHistoricoPreco;
import br.com.fabrica.modelo.HistoricoPreco;

/**
 * Classe respons�vel por gerenciar o hist�rico de pre�os referente aos insumos
 * e aos produtos.
 * @see HistoricoPreco
 * @author Rafaela
 *
 */
public class GerenciaHistoricoPreco {
	/**
	 * Insere o novo pre�o e a nova data no hist�rico de pre�o. A data a ser
	 * atribuida sempre ser� a data do dia.
	 * @param preco - <code>float</code> : novo pre�o a ser cadastrado.
	 * @param codigo - <code>int</code> : c�digo referente a informa��o que o dado pertence.
	 * @param arquivo - <code>String</code> : arquivo onde ser�o salvos os dados.
	 * @return <code>true</code> caso consiga inserir. <code>false</code> caso n�o consiga.
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
	 * Obt�m o pre�o e a data mais antiga.
	 * @param codigo <code>int</code> c�digo Refer�ncia relativo ao dado que deseja obter o pre�o
	 * @return <code>HistoricoPreco</code> : pre�o e data mais recente que foram cadastrados.
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
	 * Obt�m o pre�o mais recente.
	 * @param historicoPrecos - <code>List</code> : lista que cont�m os pre�os
	 * @return - <code>float</code> :pre�o mais recente que foi cadastrado.
	 */
	public float obtemPrecoMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size()).getPreco();
 	}
	
}
