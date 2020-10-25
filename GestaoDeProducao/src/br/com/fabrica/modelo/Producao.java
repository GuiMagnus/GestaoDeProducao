package br.com.fabrica.modelo;

public class Producao {
	private int codigo;
	private Produto produto;
	private int quantidade;
	private String data;
	private float custoProducao;
	/**
	 * Construtor default da classe Producao. Instancia um objeto producao atribuindo
	 * valores default ao seus atributos.
	 */
	public Producao() {	}

	/**
	 * Construtor sobrecarregado da classe <code>Producao</code>. Instancia um objeto producao atribuindo
	 * valores passado como par�metro.
	 * 
	 * @param produto -<code>Produto</code> : dados do produto a serem usados na produ��o como o nome do produto
	 * a quantidade e pre�o
	 * @param quantidade <code>int</code> : valor de quantidade a ser produzido.
	 * @param data - <code>String</code> : Data da produ��o do produto.
	 * @param custoProducao <code>float</code> : Custo da produ��o de determinado produto.
	 */
	public Producao(Produto produto, int quantidade, String data, float custoProducao) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
		this.custoProducao = custoProducao;
	}

	/**
	 * Obt�m um objeto produto com os dados do produto que ser� produzido.
	 * @return <code>int</code> : Um objeto produto a ser produzido.
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Recebe um par�metro com os dados de determinado produto a ser produzido e atribui a vari�vel
	 * produto da classe Producao.
	 * @param produto - <code>Produto</code> : valor referente ao produto que ser� produzido.
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Obt�m a quantidade a ser produzida de determinado produto.
	 * @return <code>int </code> : Retorna a quantidade da produ��o.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Atribui ao objeto da classe a quantidade a ser produzida de determinado produto.
	 * @param quantidade - <code>int</code> : valor referente a quantidade a ser produzida.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Obt�m a data da produ��o de um produto.
	 * @return <code>String</code> : String referente a data de uma produ��o.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Atribui ao objeto da classe a string referente a data da produ��o de um produto.
	 * @param data - <code>String</code> : string referente a data de uma produ��o.
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Obt�m o c�digo de identifica��o de uma produ��o.
	 * @return <code>int</code> : c�digo de identifica��o da produ��o de um produto
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe um c�digo para identifica��o de uma produ��o
	 * @param codigo - <code>int</code> : codigo referente a identificacao da produ��o de um produto 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obt�m o custo da produ��o de um produto.
	 * @return - <code>float</code> : valor referente ao custo da produ��o de um produto. 
	 */
	public float getCustoProducao() {
		return custoProducao;
	}

	/**
	 * Atribui ao objeto da classe o valor referente ao custo de produ��o de um produto.
	 * @param custoProducao - <code>float</code> : valor referente ao custo da produ��o de um produto.
	 */
	public void setCustoProducao(float custoProducao) {
		this.custoProducao = custoProducao;
	}
	
	/**
	 * Representa��o String dos atributos da classe Produ��o
	 * @return <code>String</code> : string contendo os atributos da classe Producao.
	 */
	@Override
	public String toString() {
		return String.format("Codigo: %d, produto: %s, quantidade: %d, data: %s, custoProducao:%s",
				getCodigo(), produto.getNome(), quantidade, data, custoProducao);
	}
	
}
