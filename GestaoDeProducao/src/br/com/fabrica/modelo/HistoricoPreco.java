package br.com.fabrica.modelo;
/***
 * 
 * @author Rafaela
 * Classe responsável por armazenar o preço atribuído a determinado item
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
	 * parâmetro 
	 * @param preco valor em dinheiro atual ou não referente ao item
	 * @param data referente ao período inicial em que determinado preço foi atribuído a um item
	 */
	public HistoricoPreco(float preco, String data) {
		this.preco = preco;
		this.data = data;
	}

	/**
	 * Obtém o valor em dinheiro atribuído a um item.
	 * @return o preço referente a variável que define o valor de um item.
	 */
	public float getPreco() {
		return preco;
	}
	/**
	 * Atribui a variável preço um valor referente a um item.
	 * @param preco valor a ser atribuído a um objeto da classe item.
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * Obtém a data em que foi determinado o preço referente a um item
	 * @return data referente a variável que define a data que o preço foi alterado.
	 */
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Preço: %.2f, data: %s", preco, data);
	}
	
	
	
	
}
