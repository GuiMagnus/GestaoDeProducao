package br.com.fabrica.gerencia.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.validacoes.Data;

/**
 * Classe responsável por gerenciar o Relatório de produção
 * @author Rafaela
 *
 */
public class GerenciaRelatorioProducao {
	
	/**
	 * Obtem a produção em um determinado periodo
	 * @param dataI data inicial
	 * @param dataF data final
	 * @return produtos produzidos no período
	 */
	public static List<Producao> producaoPorPeriodo(String dataI, String dataF) {
		Data d1 = new Data(dataI);
		Data d2 = new Data(dataF);
		List<Producao> listaProducao = new ArquivoProducao().leProducoesNoArquivo();
		List<Producao> listaPeriodo = new ArrayList<Producao>();
		for(Producao producao : listaProducao) {
			if(producao.getData().dataDentroDoPeriodo(d1, d2))
				listaPeriodo.add(producao);
		}
		return listaPeriodo;
	}
}
