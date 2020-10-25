package br.com.fabrica.modelo;
/***
 * 
 * @author Rafaela
 * Classe responsável por armazenar o preço atribuído a determinado item
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
	 * parâmetro. 
	 * @param preco valor em dinheiro atual ou não referente ao item.
	 * @param data referente ao período inicial em que determinado preço foi atribuído a um item.
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

	
	/**
	 * Obtém o código de referência ao Produto ou insumo que teve seu preço atual ou antigo ajustado.
	 * @return Obtém o código de referência ao Produto ou insumo que teve seu preço atual ou antigo ajustado e o retorna.
	 */
	public int getCodigoReferenciaDeDado() {
		return codigoReferenciaDeDado;
	}

	
	/**
	 * Atribui o código de referencia do Produto ou insumo que teve seu preço atual ou antigo ajustado.
	 * @param codigoReferenciaDeDado referência do produto ou insumo aquele preço pertence.
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
				"codigo:%s, codigoReferência:%s, preco:%s, data:%s",
				getCodigo(), codigoReferenciaDeDado, preco, data);
	}

	
	
	
	
}
