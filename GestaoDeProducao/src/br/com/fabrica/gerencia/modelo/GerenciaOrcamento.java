package br.com.fabrica.gerencia.modelo;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.modelo.MesesAno;
import br.com.fabrica.modelo.Orcamento;
import br.com.fabrica.modelo.Produto;
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
	 * @param produtos lista de produtos que geraram despesas
	 * @return valor das despesas
	 */
	public float somaDespedasMes(String mes, List<Produto> produtos) {
		Data dataI = null;
		Data dataF = null;
		float valorDespesa = 0;
		for(MesesAno mesesAno : MesesAno.values()) {
			if(mesesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesesAno.getNumeroMes(), Calendar.YEAR);
				dataF = new Data(mesesAno.getQtdDias(), mesesAno.getNumeroMes(), Calendar.YEAR);
			}		
		}
		Data data = new Data();
		for(Produto produto : produtos) {
			if(data.dataDentroDoPeriodo(dataI, dataF))
				valorDespesa += produto.getPrecoFabricacao();
		}
		
		return valorDespesa;
	}
	
	/**
	 * Obtém o número total de vendas em um mês
	 * @param mes mes que deseja obter as informações
	 * @param vendas lista de produtos que foram vendidos
	 * @return quantidade de produtos vendidos
	 */
	public int obtemNumeroTotalDeVendas(String mes, List<Venda> vendas) {
		Data dataI = null;
		Data dataF = null;
		int qtdVenda = 0;
		for(MesesAno mesesAno : MesesAno.values()) {
			if(mesesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesesAno.getNumeroMes(), Calendar.YEAR);
				dataF = new Data(mesesAno.getQtdDias(), mesesAno.getNumeroMes(), Calendar.YEAR);
			}		
		}
		Data data = new Data();
		for(int i = 0; i < vendas.size(); i++) {
			if(data.dataDentroDoPeriodo(dataI, dataF))
				qtdVenda++;
		}
		
		return qtdVenda;
	}
	
	/**
	 * Obtém o valor total obtido com as vendas
	 * @param mes mes que deseja obter as informações
	 * @param vendas lista de produtos que foram vendidos
	 * @return valor total das vendas
	 */
	public float obtemValorTotalDeVendas(String mes, List<Venda> vendas) {
		Data dataI = null;
		Data dataF = null;
		float valorVenda = 0;
		for(MesesAno mesesAno : MesesAno.values()) {
			if(mesesAno.getMes().equalsIgnoreCase(mes)) {
				dataI = new Data(1, mesesAno.getNumeroMes(), Calendar.YEAR);
				dataF = new Data(mesesAno.getQtdDias(), mesesAno.getNumeroMes(), Calendar.YEAR);
			}		
		}
		Data data = new Data();
		for(Venda venda : vendas) {
			if(data.dataDentroDoPeriodo(dataI, dataF))
				valorVenda += venda.valorTotalVendaPorProduto();
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
