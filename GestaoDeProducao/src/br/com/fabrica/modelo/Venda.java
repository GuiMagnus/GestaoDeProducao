package br.com.fabrica.modelo;

import java.util.Comparator;
import java.util.List;

import br.com.fabrica.validacoes.Data;

/**
 * Classe responsável por armazenar os dados referentes a venda
 * @author Rafaela e Guilherme.
 *
 */
public class Venda implements Comparator<Venda>{
	
	private int codigo;
	private Data data;
	private String hora;
	private List<Produto> produtos;
	private float valorTotalVenda;
	/**
	 * Construtor default da classe Venda.
	 * Atribui valores default aos atributos da classe.
	 */
	public Venda() {	
	}

	/**
	 * Construtor sobrecarregado da classe Venda, atribui valores passados 
	 * como parâmetro para os atributos da classe
	 * @param data <code>String</code> Representa a data da venda
	 * @param hora <code>String</code> Representa a hora da venda
	 * @param produtos <code>List</code> Lista contendo os produtos que foram vendidos
	 * @param quantidade <code>int</code> valor referente a quantidade vendida.
	 */
	public Venda(Data data, String hora, List<Produto> produtos) {
		this.data = data;
		this.hora = hora;
		this.produtos = produtos;
	}
	
	/**
	 * Obtém a data da venda do produto.
	 * @return <code>String</code> valor referente data da venda do produto.
	 */
	public Data getData() {
		return data;
	}

	/**
	 * Atibui ao objeto da classe a data da venda do produto.
	 * @param <code>String</code> valor referente data da venda do produto.
	 */
	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * Obtém a hora da venda do produto.
	 * @return <code>String</code> valor referente hora da venda do produto.
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Atribui ao objeto da classe a hora da venda do produto.
	 * @param <code>String</code> valor referente a hora da venda do produto.
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Obtém a lista de produtos vendidos.
	 * @return <code>List</code> Lista contendo os produtos vendidos.
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Atribui ao objeto da classe a lista de produtos vendidos.
	 * @param <code>List</code> Lista contendo os produtos vendidos.
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	/**
	 * Obtém o código de identificação da venda.
	 * @return <code>int</code> : Um código de identificação da venda
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe o código de identificação da venda.
	 * @param <code>int</code>Um código de identificação da venda
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtém o valor total da venda.
	 * @return contem o valor da venda.
	 */
	public float getValorTotalVenda() {
		return valorTotalVenda;
	}
	
	/**
	 * Atribui ao objeto da classe venda o valor total daquela venda.
	 * @param valorTotalVenda contém o valor total da venda.
	 */
	public void setValorTotalVenda(float valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	
	/**
	 * Representação String contendo os atributos da venda.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, data: %s, hora: %s, produto: %s",
				codigo, data, hora, produtos);
	}
	
	/**
	 * Comparação entre duas datas. 
	 * @param data1 data a ser comparada.
	 * @param data2 data a ser comparada.
	 * @return retorna o valor indicando o resultado obtido da comparação das datas.
	 */
	@Override
	public int compare(Venda data1, Venda data2) {
		return data1.getData().compareTo(data2.getData());
	}
	
}
