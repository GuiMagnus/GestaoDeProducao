package br.com.fabrica.modelo;
/***
 * 
 * @author Rafaela
 * Classe respons�vel por armazenar o pre�o atribu�do a determinado item
 */
public class HistoricoPreco {
	private int codigo;
	private int codigoReferenciaDeDado;
	private float preco;
	private String data;
	
	/**
	 * Construtor default. Instancia um objeto da classe HistoricoPreco
	 * atribuindo valores default aos atributos da mesma.
	 */
	public HistoricoPreco() {	}

	/**
	 * Construtor sobrecarregado da Classe HistoricoPreco atribuindo os valores passados como 
	 * par�metro. 
	 * @param preco valor em dinheiro atual ou n�o referente ao item.
	 * @param data referente ao per�odo inicial em que determinado pre�o foi atribu�do a um item.
	 */
	public HistoricoPreco(float preco, String data) {
		this.preco = preco;
		this.data = data;
	}

	/**
	 * Obt�m o valor em dinheiro atribu�do a um item.
	 * @return o pre�o referente a vari�vel que define o valor de um item.
	 */
	public float getPreco() {
		return preco;
	}
	

	/**
	 * Atribui a vari�vel pre�o um valor referente a um item.
	 * @param preco valor a ser atribu�do a um objeto da classe item.
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * Obt�m a data em que foi determinado o pre�o referente a um item
	 * @return data referente a vari�vel que define a data que o pre�o foi alterado.
	 */
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	/**
	 * Obt�m o c�digo de refer�ncia ao Produto ou insumo que teve seu pre�o atual ou antigo ajustado.
	 * @return Obt�m o c�digo de refer�ncia ao Produto ou insumo que teve seu pre�o atual ou antigo ajustado e o retorna.
	 */
	public int getCodigoReferenciaDeDado() {
		return codigoReferenciaDeDado;
	}

	
	/**
	 * Atribui o c�digo de referencia do Produto ou insumo que teve seu pre�o atual ou antigo ajustado.
	 * @param codigoReferenciaDeDado refer�ncia do produto ou insumo aquele pre�o pertence.
	 */
	public void setCodigoReferenciaDeDado(int codigoReferenciaDeDado) {
		this.codigoReferenciaDeDado = codigoReferenciaDeDado;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return String.format(
				"codigo:%s, codigoRefer�ncia:%s, preco:%s, data:%s",
				getCodigo(), codigoReferenciaDeDado, preco, data);
	}

	
	
	
	
}
