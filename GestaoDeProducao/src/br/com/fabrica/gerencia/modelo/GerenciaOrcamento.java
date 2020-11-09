package br.com.fabrica.gerencia.modelo;

import java.util.Calendar;

import static br.com.fabrica.constantes.Constantes.*;

import java.util.List;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.modelo.MesesAno;
import br.com.fabrica.modelo.Orcamento;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Venda;
import br.com.fabrica.validacoes.Data;

/**
 * Classe responsável por gerenciar o Orcamento
 * @see Orcamento
 * @author Rafaela
 *
 */
public class GerenciaOrcamento {
	
	/**
	 * Soma as despesas de produção de cada mês
	 * @param mes mes que deseja obter as despesas
	 * @return valor das despesas
	 */
	public float somaDespedasMes(String mes) {
		Data dataI = null;
		Data dataF = null;
		float valorDespesa = 0;
		Calendar cal = Calendar.getInstance();
		for(MesesAno mesAno : MesesAno.values()) {
			if(mesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesAno.getNumeroMes(), cal.get(Calendar.YEAR));
				dataF = new Data(mesAno.getQtdDias(), mesAno.getNumeroMes(), cal.get(Calendar.YEAR));
			}		
		}
		ArquivoProducao ap = new ArquivoProducao();
		List<Producao> litaProducao = ap.leProducoesNoArquivo(ARQ_PRODUCAO);
		for(Producao producao : litaProducao) {
			if(producao.getData().dataDentroDoPeriodo(dataI, dataF)) {
				valorDespesa += producao.getCustoProducao();
			}
				
		}
		return valorDespesa;
	}
	
	/**
	 * Obtém o número total de vendas em um mês
	 * @param mes mes que deseja obter as informações
	 * @return quantidade de produtos vendidos
	 */
	public int obtemNumeroTotalDeVendas(String mes) {
		Data dataI = null;
		Data dataF = null;
		int qtdVenda = 0;
		Calendar cal = Calendar.getInstance();
		for(MesesAno mesesAno : MesesAno.values()) {
			if(mesesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesesAno.getNumeroMes(), cal.get(Calendar.YEAR));
				dataF = new Data(mesesAno.getQtdDias(), mesesAno.getNumeroMes(), cal.get(Calendar.YEAR));
			}		
		}
		List<Venda> vendas = new ArquivoVenda().leVendasNoArquivo();
		for(Venda venda : vendas) {
			if(venda.getData().dataDentroDoPeriodo(dataI, dataF)) {
				qtdVenda++;
			}
				
		}
		return qtdVenda;
	}
	
	/**
	 * Obtém o valor total obtido com as vendas
	 * @param mes mes que deseja obter as informações
	 * @return valor total das vendas
	 */
	public float obtemValorTotalDeVendas(String mes) {
		Data dataI = null;
		Data dataF = null;
		float valorVenda = 0;
		Calendar cal = Calendar.getInstance();
		for(MesesAno mesesAno : MesesAno.values()) {
			if(mesesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesesAno.getNumeroMes(), cal.get(Calendar.YEAR));
				dataF = new Data(mesesAno.getQtdDias(), mesesAno.getNumeroMes(), cal.get(Calendar.YEAR));
			}		
		}

		List<Venda> vendas = new ArquivoVenda().leVendasNoArquivo();
		for(Venda venda : vendas) {
			if(venda.getData().dataDentroDoPeriodo(dataI, dataF))
				valorVenda += venda.getValorTotalVenda();
		}
		
		return valorVenda;
	}
	
	/**
	 * Calcula o saldo obtido no mes
	 * @param valorVenda valor obtido com as vendas
	 * @param valorDespesa valor gasto com as despesas
	 * @return saldo obtido no mes
	 */
	public float saldo(float valorVenda, float valorDespesa) {
		return valorVenda - valorDespesa;
	}
}
