package br.com.fabrica.modelo;

import java.util.List;

public class Venda {
	
	private int codigo;
	private String data;
	private String hora;
	private List<Produto> produtos;
	private int quantidade;// verificar pois o objeto produto já possui o atributo quantidade
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
	public Venda(String data, String hora, List<Produto> produtos, int quantidade) {
		this.data = data;
		this.hora = hora;
		this.produtos = produtos;
		this.quantidade = quantidade;
	}
	/**
	 * Obtém a data da venda do produto.
	 * @return <code>String</code> valor referente data da venda do produto.
	 */
	public String getData() {
		return data;
	}

	

	/**
	 * Atibui ao objeto da classe a data da venda do produto.
	 * @param <code>String</code> valor referente data da venda do produto.
	 */
	public void setData(String data) {
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
	 * Obtém a quantidade de produtos vendidos.
	 * @return <code>int</code> valor referente a quantidade de produtos vendidos. 
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Atribui ao objeto da classe a quantidade de produtos vendidos.
	 * @param <code>int</code> valor referente a quantidade de produtos vendidos. 
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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

	
	public float getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(float valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public float valorTotalVendaPorProduto() {
		float valor = 0;
		for(Produto produto : produtos)
			valor += produto.getPrecoFabricacao() * produto.getQuantidadeProduto();
		return valor;
	}
	
	/**
	 * Representação String contendo os atributos da venda.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, data: %s, hora: %s, produto: %s, quantidade: %d",
				codigo, data, hora, produtos, quantidade);
	}
	
}
