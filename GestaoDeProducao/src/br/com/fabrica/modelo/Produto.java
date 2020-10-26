package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	private int codigo;
	private String nome;
	private UnidadeMedida unidadeMedida;
	private float margemLucro;
	private float precoFabricacao;
	private float precoVenda;
	private int quantidadeProduto;
	private List<HistoricoPreco> historicoPrecos;
	private List<Insumo> insumos;
	
	/**
	 * Construtor default da classe Produto. 
	 * Atribui valores default aos atributos da mesma. 
	 */
	public Produto() {
		historicoPrecos = new ArrayList<HistoricoPreco>();
		insumos = new ArrayList<Insumo>();
	}

	
	/**
	 * Construtor sobrecarregado da classe Produto.
	 * @param nome - <code>String</code> : valor contendo o nome do produto.
	 * @param unidadeMedida - <code>UnidadeMedida</code> : valor referente a
	 *  unidade de medida do produto podendo conter (KG,g,Ml,l). 
	 * @param margemLucro - <code>float</code> : valor referente a margem de lucro
	 *  obtido com a venda do produto.
	 * @param precoVenda - <code>float</code> : valor referente ao pre�o da venda de um produto. 
	 * @param quantidadeProduto - <code>int</code> :  valor referente a quantidade do produto 
	 * cadastrado
	 * @param historicoPrecos - <code>List</code> : Lista contendo todos os precos j� registrados para determinado produto. 
	 * @param insumos - <code>List</code> : Lista contendo todos os insumos necess�rios
	 *  para a fabrica��o de um produto.
	 */
	public Produto(String nome, UnidadeMedida unidadeMedida, float margemLucro, float precoVenda,
			int quantidadeProduto, List<HistoricoPreco> historicoPrecos, List<Insumo> insumos) {
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.margemLucro = margemLucro;
		this.precoVenda = precoVenda;
		this.quantidadeProduto = quantidadeProduto;
		this.historicoPrecos = historicoPrecos;
		this.insumos = insumos;
	}

	/**
	 * Obt�m o nome do produto.
	 * @return <code>String</code> : string contendo o nome do produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui ao objeto da classe Produto uma string com o nome do produto.
	 * @param nome - <code></code> : String contendo o nome do produto.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obt�m a unidade de medida do produto (KG,g,Ml,l) 
	 * @return <code>UnidadeMedida</code> : Um objeto contendo a unidade de medida do produto.
	 */
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * Atribui ao objeto da classe a unidade de medida do produto.
	 * @param unidadeMedida <code>UnidadeMedida</code> Tipo de medida do produto((KG,g,Ml,l).
	 */
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	/**
	 * Obt�m a margem de lucro obtida com a venda do produto.
	 * @return - <code>float</code> : valor referente ao lucro obtido com a venda do produto.
	 */
	public float getMargemLucro() {
		return margemLucro;
	}

	/**
	 * Atribui ao objeto da classe o valor referente a margem de lucro obtida com a venda  do produto
	 * @param margemLucro - <code>float</code> : valor contendo a margem de lucro do produto. 
	 */
	public void setMargemLucro(float margemLucro) {
		this.margemLucro = margemLucro;
	}

	/**
	 * Obt�m o pre�o referente a fabrica��o do produto ou seja o valor de seus insumos.
	 * @return <code>float</code> - valor referente a fabrica��o do produto.
	 */
	public float getPrecoFabricacao() {
		return precoFabricacao;
	}
	
	public void setPrecoFabricacao(float precoFabricacao) {
		this.precoFabricacao = precoFabricacao;
	}

	/**
	 * Obt�m o pre�o da venda estabelecido para o produto.
	 * @return <code>float</code> valor do preco de venda do produto.
	 */
	public float getPrecoVenda() {
		return precoVenda;
	}

	/**
	 * Atribui ao objeto da classe o pre�o estabelecido de venda do produto.
	 * @param precoVenda - <code>float</code> : pre�o estabelecido para venda do produto.
	 */
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	/**
	 * Obt�m a quantidade cadastrada do produto.
	 * @return <code>int</code> : valor contendo a quantidade cadastrada do produto.
	 */
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	/**
	 * Atribui ao objeto da classe a quantidade cadastrada do produto.
	 * @param quantidadeProduto - <code>int</code> : valor referente a quantidade cadastrada para o produto. 
	 */
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	/**
	 * Obt�m a Lista contendo todos os pre�os j� estabelecidos para o produto.
	 * @return <code>List</code> : Uma lista com todos os pre�os j� estabelecidos para um produto.
	 */
	public List<HistoricoPreco> getHistoricoPrecos() {
		return historicoPrecos;
	}

	/**
	 * Atribui ao objeto da classe produto uma lista contendo os pre�os estabelecidos para um produto.
	 * @param historicoPrecos - <code>List</code> : Uma lista contendo todos os pre�os j� atrbu�dos a um produto.
	 */
	public void setHistoricoPrecos(List<HistoricoPreco> historicoPrecos) {
		this.historicoPrecos = historicoPrecos;
	}

	/**
	 * Obt�m a lista de insumos necess�rios para a fabrica��o de um produto.
	 * @return <code>List</code> Uma lista com todos os insumos necess�rios para fabrica��o do produto.
	 */
	public List<Insumo> getInsumos() {
		return insumos;
	}

	/**
	 * Atribui ao objeto da classe uma lista de insumos necess�rios para a fabrica��o de um produto.
	 * @param insumos <code>List</code> : Uma lista com os insumos necess�rios para fabrica��o do produto.
	 */
	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	/**
	 * Obt�m o c�digo para identifica��o do produto;
	 * @return <code>int</code> : O c�digo de identifica��o do produto;
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe o c�digo para identifica��o do produto;
	 * @return <code>int</code> : O c�digo de identifica��o do produto;
	 */
	public void setCodigo(int auxiliarCodigo) {
		this.codigo = auxiliarCodigo;
	}
	
	/**
	 * Representa��o String contendo os dados dos atributos do produto.
	 */
	@Override
	public String toString() {
		return String.format(
				"C�digo: %d, nome: %s, unidadeMedida: %s, margemLucro: %.2f, "
				+ "precoFabricacao: %.2f, precoVenda: %.2f, quantidadeProduto: %d",
				codigo, nome, unidadeMedida.getUnidade(), margemLucro, precoFabricacao,
				precoVenda, quantidadeProduto); 
	}
	
}
