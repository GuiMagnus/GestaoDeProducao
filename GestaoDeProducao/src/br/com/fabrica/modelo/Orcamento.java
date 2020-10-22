package br.com.fabrica.modelo;

public class Orcamento {
	public final int codigo = ++geraCodigo;
	private static int geraCodigo;
	private String mes;
	private float despesaTotal;
	private int quantidadeVendas;
	private float valorVendas;
	
	public Orcamento() {	}

	public Orcamento(String mes, float despesaTotal, int quantidadeVendas, float valorVendas) {
		this.mes = mes;
		this.despesaTotal = despesaTotal;
		this.quantidadeVendas = quantidadeVendas;
		this.valorVendas = valorVendas;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public float getDespesaTotal() {
		return despesaTotal;
	}

	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	public float getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}
	
	public float calculaSaldo() {
		return valorVendas - despesaTotal;
	}

	@Override
	public String toString() {
		return String.format("Codigo: %d, mes: %s, despesaTotal: %.2f, quantidadeVendas: %.2f,"
				+ " valorVendas: %.2f", codigo, mes, despesaTotal, quantidadeVendas, valorVendas);
	}
	
	
}
