package br.com.fabrica.modelo;

/**
 * Classe responsável por armazenar os dados do orçamento
 * @author Rafaela
 *
 */
public class Orcamento {
	private int codigo;
	private String mes;
	private float despesaTotal;
	private int quantidadeVendas;
	private float valorVendas;
	
	/**
	 * Construtor default. Instancia um objeto da classe Orcamento
	 * atribuindo valores default aos atributos da mesma.
	 */
	public Orcamento() {	
		
	}

	/**
	 * Construtor sobrecarregado. Instancia um objeto da classe Orcamento com os valores
	 * recebidos como parâmetro.
	 * @param mes - <code>String</code> : Período a ser pedido o orçamento 
	 * @param despesaTotal  - <code>float</code> : valor com todas as despesas referentes ao período
	 * do orçamento
	 * @param quantidadeVendas - <code>int</code> : valor referente ao número de vendas referentes aquele
	 * período.
	 * @param valorVendas - <code>float</code> : valor referente ao dinheiro arrecadado com
	 * as vendas.
	 */
	public Orcamento(String mes, float despesaTotal, int quantidadeVendas, float valorVendas) {
		this.mes = mes;
		this.despesaTotal = despesaTotal;
		this.quantidadeVendas = quantidadeVendas;
		this.valorVendas = valorVendas;
	}

	/**
	 * Obtém o mês a que se pretende fazer o orçamento.
	 * @return <code>String</code> : Contém o mês do orçamento requerido.
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * Atribui ao objeto da classe o mês a que se pretende fazer o orçamento. 
	 * @param mes - <code>String</code> : valor referente ao mês do orçamento.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * Obtém a despesa total referente ao mês de orçamento.
	 * @return <code>float</code> : valor referente ao total das despesas de determinado mês de
	 * orçamento. 
	 */
	public float getDespesaTotal() {
		return despesaTotal;
	}

	/**
	 * Atribui ao objeto da classe Orcamento o valor das despesas totais referentes ao mês de orçamento
	 * @param despesaTotal - <code>float</code> : valor total das despesas de determinado mês 
	 */
	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

	/**
	 *Obtém o valor da quantidade de vendas referentes a determinado mês. 
	 * @return <code>int</code> : valor do número de vendas efetivadas em determinado mês. 
	 */
	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	/**
	 * Atribui a classe Orcamento o número de vendas obtidas em determinado mês.
	 * @param quantidadeVendas valor referente ao número de vendas em um mês.
	 */
	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	/**
	 * Obtém o valor em dinheiro das vendas obtidas em determinado mês. 
	 * @return <code>float</code> : valor obtido com as vendas em um mês.
	 */
	public float getValorVendas() {
		return valorVendas;
	}

	/**
	 * Atribui a classe Orcamento o valor total das vendas em um mês.
	 * @param valorVendas valor referente as vendas de determinado mês.
	 */
	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}

	/**
	 * Obtém o código referente ao código de determinado orçamento em um mês.
	 * @return <code>int</code> : valor referente ao código para identificação de um orçamento.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui a classe Orcamento um codigo para identificar um orcamento em um mês.
	 * @param codigo - <code>int</code> : valor de código para identificar um orcamento. 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Representação String dos atributos da classe Orcamento.
	 * @return <code>String</code> : Uma String contendo os atributos da classe Orcamento.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, mes: %s, despesaTotal: %.2f, quantidadeVendas: %.2f,"
				+ " valorVendas: %.2f", codigo, mes, despesaTotal, quantidadeVendas, valorVendas);
	}
	
	
}
