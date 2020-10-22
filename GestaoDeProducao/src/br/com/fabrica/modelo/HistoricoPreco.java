package br.com.fabrica.modelo;
/***
 * 
 * @author Rafaela
 * Classe respons�vel por armazenar o pre�o atribu�do a determinado item
 */
public class HistoricoPreco {
	public final int codigo = ++geraCodigo;
	private static int geraCodigo;
	private float preco;
	private String data;
	
	/**
	 * Construtor default. Instancia um objeto da classe HistoricoPreco
	 * atribuindo valores default aos atributos da mesma.
	 */
	public HistoricoPreco() {	}

	/**
	 * Construtor sobrecarregado da Classe HistoricoPreco atribuindo os valores passados como 
	 * par�metro 
	 * @param preco valor em dinheiro atual ou n�o referente ao item
	 * @param data referente ao per�odo inicial em que determinado pre�o foi atribu�do a um item
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

	@Override
	public String toString() {
		return String.format("Pre�o: %.2f, data: %s", preco, data);
	}
	
	
	
	
}
