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
	 * @param preco <code>float</code>: valor em dinheiro atual ou não referente ao item.
	 * @param data <code>String</code>: referente ao período inicial em que determinado preço foi atribuído a um item.
	 */
	public HistoricoPreco(float preco, String data) {
		this.preco = preco;
		this.data = data;
	}

	/**
	 * Obtém o valor em dinheiro atribuído a um item.
	 * @return <code>float</float>: preço referente a variável que define o valor de um item.
	 */
	public float getPreco() {
		return preco;
	}
	

	/**
	 * Atribui a variável preço um valor referente a um item.
	 * @param preco <code>float</code>: valor a ser atribuído a um objeto da classe item.
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * Obtém a data em que foi determinado o preço referente a um item
	 * @return data - <code>String</code>: valor referente a variável que define
	 *  a data que o preço foi alterado.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Atribui uma data no formato de string de uma definição ou substituição 
	 * do preço de um produto ou insumo
	 * @param data - <code>String</code> : valor referente a uma data em que um preço
	 * de um produto/insumo foi atualizado ou definido. 
	 */
	public void setData(String data) {
		this.data = data;
	}

	
	/**
	 * Obtém o código de referência ao Produto ou insumo que teve seu preço atual ou antigo ajustado.
	 * @return - <code>int</code>: Obtém o código de referência ao Produto ou insumo que teve seu preço atual ou antigo ajustado e o retorna.
	 */
	public int getCodigoReferenciaDeDado() {
		return codigoReferenciaDeDado;
	}

	
	/**
	 * Atribui o código de referencia do Produto ou insumo que teve seu preço atual 
	 * ou antigo ajustado.
	 * @param codigoReferenciaDeDado  <code>int</code>: referência do produto ou 
	 * insumo aquele preço pertence.
	 */
	public void setCodigoReferenciaDeDado(int codigoReferenciaDeDado) {
		this.codigoReferenciaDeDado = codigoReferenciaDeDado;
	}

	/**
	 * Obtém o código de determinada atualização do preço do produto/insumo.
	 * @return <code>int</code> código da atualização de preço de um produto ou insumo.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui um código para a atualização do preço do produto/insumo.
	 * @param codigo <code>int</code> valor de código para identificação da atualização do preço
	 * de um produto ou insumo.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Representação em forma de string com os atributos da classe HistoricoPreco.
	 * @return <code>String</code> : Uma string com os dados de um objeto da classe HistoricoPreco.
	 */
	@Override
	public String toString() {
		return String.format(
				"codigo:%s, codigoReferência:%s, preco:%s, data:%s",
				getCodigo(), codigoReferenciaDeDado, preco, data);
	}

	
	
	
	
}
