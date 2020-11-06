package br.com.fabrica.modelo;

/**
 * Classe respons�vel por armazenar os dados do or�amento
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
	 * recebidos como par�metro.
	 * @param mes - <code>String</code> : Per�odo a ser pedido o or�amento 
	 * @param despesaTotal  - <code>float</code> : valor com todas as despesas referentes ao per�odo
	 * do or�amento
	 * @param quantidadeVendas - <code>int</code> : valor referente ao n�mero de vendas referentes aquele
	 * per�odo.
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
	 * Obt�m o m�s a que se pretende fazer o or�amento.
	 * @return <code>String</code> : Cont�m o m�s do or�amento requerido.
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * Atribui ao objeto da classe o m�s a que se pretende fazer o or�amento. 
	 * @param mes - <code>String</code> : valor referente ao m�s do or�amento.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * Obt�m a despesa total referente ao m�s de or�amento.
	 * @return <code>float</code> : valor referente ao total das despesas de determinado m�s de
	 * or�amento. 
	 */
	public float getDespesaTotal() {
		return despesaTotal;
	}

	/**
	 * Atribui ao objeto da classe Orcamento o valor das despesas totais referentes ao m�s de or�amento
	 * @param despesaTotal - <code>float</code> : valor total das despesas de determinado m�s 
	 */
	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

	/**
	 *Obt�m o valor da quantidade de vendas referentes a determinado m�s. 
	 * @return <code>int</code> : valor do n�mero de vendas efetivadas em determinado m�s. 
	 */
	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	/**
	 * Atribui a classe Orcamento o n�mero de vendas obtidas em determinado m�s.
	 * @param quantidadeVendas valor referente ao n�mero de vendas em um m�s.
	 */
	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	/**
	 * Obt�m o valor em dinheiro das vendas obtidas em determinado m�s. 
	 * @return <code>float</code> : valor obtido com as vendas em um m�s.
	 */
	public float getValorVendas() {
		return valorVendas;
	}

	/**
	 * Atribui a classe Orcamento o valor total das vendas em um m�s.
	 * @param valorVendas valor referente as vendas de determinado m�s.
	 */
	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}

	/**
	 * Obt�m o c�digo referente ao c�digo de determinado or�amento em um m�s.
	 * @return <code>int</code> : valor referente ao c�digo para identifica��o de um or�amento.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui a classe Orcamento um codigo para identificar um orcamento em um m�s.
	 * @param codigo - <code>int</code> : valor de c�digo para identificar um orcamento. 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Representa��o String dos atributos da classe Orcamento.
	 * @return <code>String</code> : Uma String contendo os atributos da classe Orcamento.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, mes: %s, despesaTotal: %.2f, quantidadeVendas: %.2f,"
				+ " valorVendas: %.2f", codigo, mes, despesaTotal, quantidadeVendas, valorVendas);
	}
	
	
}
