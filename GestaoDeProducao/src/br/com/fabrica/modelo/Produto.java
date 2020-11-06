package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável por armazenar os dados do produto
 * @author Rafaela
 *
 */
public class Produto implements Comparable<Produto>, Comparator<Produto>{
	
	private int codigo;
	private int codigoVenda;
	private String nome;
	private UnidadeMedida unidadeMedida;
	private float tamanhoUnidade;
	private float margemLucro;
	private float precoFabricacao;
	private float precoVenda;
	private int quantidade;
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
	 * @param precoVenda - <code>float</code> : valor referente ao preço da venda de um produto. 
	 * @param quantidade - <code>int</code> :  valor referente a quantidade do produto 
	 * cadastrado
	 * @param historicoPrecos - <code>List</code> : Lista contendo todos os precos já registrados para determinado produto. 
	 * @param insumos - <code>List</code> : Lista contendo todos os insumos necessários
	 *  para a fabricação de um produto.
	 */
	public Produto(String nome, UnidadeMedida unidadeMedida, float margemLucro, float precoVenda,
			int quantidade, List<HistoricoPreco> historicoPrecos, List<Insumo> insumos) {
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.margemLucro = margemLucro;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.historicoPrecos = historicoPrecos;
		this.insumos = insumos;
	}

	/**
	 * Obtém o nome do produto.
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
	 * Obtém a unidade de medida do produto (KG,g,Ml,l) 
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
	 * Obtém a margem de lucro obtida com a venda do produto.
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
	 * Obtém o preço referente a fabricação do produto ou seja o valor de seus insumos.
	 * @return <code>float</code> - valor referente a fabricação do produto.
	 */
	public float getPrecoFabricacao() {
		return precoFabricacao;
	}
	
	public void setPrecoFabricacao(float precoFabricacao) {
		this.precoFabricacao = precoFabricacao;
	}

	/**
	 * Obtém o preço da venda estabelecido para o produto.
	 * @return <code>float</code> valor do preco de venda do produto.
	 */
	public float getPrecoVenda() {
		return precoVenda;
	}

	/**
	 * Atribui ao objeto da classe o preço estabelecido de venda do produto.
	 * @param precoVenda - <code>float</code> : preço estabelecido para venda do produto.
	 */
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	/**
	 * Obtém a quantidade cadastrada do produto.
	 * @return <code>int</code> : valor contendo a quantidade cadastrada do produto.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Atribui ao objeto da classe a quantidade cadastrada do produto.
	 * @param quantidade - <code>int</code> : valor referente a quantidade cadastrada para o produto. 
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getTamanhoUnidade() {
		return tamanhoUnidade;
	}

	public void setTamanhoUnidade(float tamanhoUnidade) {
		this.tamanhoUnidade = tamanhoUnidade;
	}


	/**
	 * Obtém a Lista contendo todos os preços já estabelecidos para o produto.
	 * @return <code>List</code> : Uma lista com todos os preços já estabelecidos para um produto.
	 */
	public List<HistoricoPreco> getHistoricoPrecos() {
		return historicoPrecos;
	}

	/**
	 * Atribui ao objeto da classe produto uma lista contendo os preços estabelecidos para um produto.
	 * @param historicoPrecos - <code>List</code> : Uma lista contendo todos os preços já atrbuídos a um produto.
	 */
	public void setHistoricoPrecos(List<HistoricoPreco> historicoPrecos) {
		this.historicoPrecos = historicoPrecos;
	}

	/**
	 * Obtém a lista de insumos necessários para a fabricação de um produto.
	 * @return <code>List</code> Uma lista com todos os insumos necessários para fabricação do produto.
	 */
	public List<Insumo> getInsumos() {
		return insumos;
	}

	/**
	 * Atribui ao objeto da classe uma lista de insumos necessários para a fabricação de um produto.
	 * @param insumos <code>List</code> : Uma lista com os insumos necessários para fabricação do produto.
	 */
	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	/**
	 * Obtém o código para identificação do produto;
	 * @return <code>int</code> : O código de identificação do produto;
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe o código para identificação do produto;
	 * @return <code>int</code> : O código de identificação do produto;
	 */
	public void setCodigo(int auxiliarCodigo) {
		this.codigo = auxiliarCodigo;
	}
	
	public int getCodigoVenda() {
		return codigoVenda;
	}


	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}


	/**
	 * Representação String contendo os dados dos atributos do produto.
	 */
	

	/**
	 * Compara os objetos do tipo Produto usando o nome do produto. A comparação é case insensitive.
	*/
	@Override
	public int compareTo(Produto produto) {
		return nome.compareToIgnoreCase(produto.nome);
	}

	@Override
	public String toString() {
		return String.format(
				"Produto [codigo=%s, nome=%s, unidadeMedida=%s, tamanhoUnidade=%s, margemLucro=%s, precoFabricacao=%s, precoVenda=%s, quantidadeProduto=%s]",
				codigo, nome, unidadeMedida, tamanhoUnidade, margemLucro, precoFabricacao, precoVenda,
				quantidade);
	}


	/**
	 * Compara os objetos do tipo Produto usando o preço do produto.  
	 */
	@Override
	public int compare(Produto produto1, Produto produto2) {
		return Integer.compare(produto1.codigo, produto2.codigo);
	}
	
}
