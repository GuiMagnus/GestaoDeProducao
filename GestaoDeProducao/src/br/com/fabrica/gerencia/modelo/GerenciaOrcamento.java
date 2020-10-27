package br.com.fabrica.gerencia.modelo;

import java.util.Calendar;
import java.util.List;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;
import br.com.fabrica.validacoes.Data;

public class GerenciaOrcamento {
	
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
	
	public float saldo(float valorVenda, float valorDespesa) {
		return valorVenda - valorDespesa;
	}
}
