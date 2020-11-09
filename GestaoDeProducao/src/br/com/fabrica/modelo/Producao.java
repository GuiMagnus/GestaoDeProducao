package br.com.fabrica.modelo;

import br.com.fabrica.validacoes.Data;

/**
 * Classe responsável por armazenar os dados da produção
 * @author Rafaela
 *
 */
public class Producao implements Comparable<Producao>{
	private int codigo;
	private Produto produto;
	private Data data;
	private float custoProducao;
	/**
	 * Construtor default da classe Producao. Instancia um objeto producao atribuindo
	 * valores default ao seus atributos.
	 */
	public Producao() {	}

	/**
	 * Construtor sobrecarregado da classe <code>Producao</code>. Instancia um objeto producao atribuindo
	 * valores passado como parâmetro.
	 * 
	 * @param produto -<code>Produto</code> : dados do produto a serem usados na produção como o nome do produto
	 * a quantidade e preço
	 * @param data - <code>String</code> : Data da produção do produto.
	 * @param custoProducao <code>float</code> : Custo da produção de determinado produto.
	 */
	public Producao(Produto produto, Data data, float custoProducao) {
		this.produto = produto;
		this.data = data;
		this.custoProducao = custoProducao;
	}

	/**
	 * Obtém um objeto produto com os dados do produto que será produzido.
	 * @return <code>int</code> : Um objeto produto a ser produzido.
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Recebe um parâmetro com os dados de determinado produto a ser produzido e atribui a variável
	 * produto da classe Producao.
	 * @param produto - <code>Produto</code> : valor referente ao produto que será produzido.
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Obtém a data da produção de um produto.
	 * @return <code>String</code> : String referente a data de uma produção.
	 */
	public Data getData() {
		return data;
	}

	/**
	 * Atribui ao objeto da classe a string referente a data da produção de um produto.
	 * @param data - <code>String</code> : string referente a data de uma produção.
	 */
	public void setData(Data data) {
		this.data = data;
	}
	
	/**
	 * Obtém o código de identificação de uma produção.
	 * @return <code>int</code> : código de identificação da produção de um produto
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe um código para identificação de uma produção
	 * @param codigo - <code>int</code> : codigo referente a identificacao da produção de um produto 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtém o custo da produção de um produto.
	 * @return - <code>float</code> : valor referente ao custo da produção de um produto. 
	 */
	public float getCustoProducao() {
		return custoProducao;
	}

	/**
	 * Atribui ao objeto da classe o valor referente ao custo de produção de um produto.
	 * @param custoProducao - <code>float</code> : valor referente ao custo da produção de um produto.
	 */
	public void setCustoProducao(float custoProducao) {
		this.custoProducao = custoProducao;
	}
	
	/**
	 * Representação String dos atributos da classe Produção
	 * @return <code>String</code> : string contendo os atributos da classe Producao.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, produto: %s, data: %s, custoProducao:%s",
				getCodigo(), produto.getNome(), data, custoProducao);
	}

	/**
	 * Compara os nomes dos produtos de uma produção
	 * @return int indicando se é igual maior ou menor o resultado da comparação
	 */
	@Override
	public int compareTo(Producao producao) {
		return producao.produto.getNome().compareToIgnoreCase(producao.produto.getNome());
	}
	
}
