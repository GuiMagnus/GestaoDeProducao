package br.com.fabrica.gerencia;

import static br.com.fabrica.validacoes.Data.transformaCalendarEmString;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.modelo.HistoricoPreco;

public class GerenciaHistoricoPreco {
	
	public void insereHistoricoPreco(float preco, List<HistoricoPreco> historico) {
		Calendar hoje = Calendar.getInstance();
		String data = transformaCalendarEmString(hoje);
		HistoricoPreco hp = new HistoricoPreco(preco, data);
		historico.add(hp);
	}
	
	public HistoricoPreco obtemPrecoRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1);
 	}
	
	public float obtemPrecoMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getPreco();
 	}
	
	public String obtemDataMaisRecente(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.get(historicoPrecos.size() - 1).getData();
 	}
}
