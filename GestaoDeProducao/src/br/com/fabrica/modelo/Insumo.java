package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafaela e Guilherme
 * 
 * Classe responsável por armazenar os dados de um insumo(Tudo que for necessário para
 * a produção de um produto).
 * Exemplos de Insumo: 
 * -Maquinário, matéria-prima(farinha de trigo, leite, açúcar, ovos, etc).
 */
public class Insumo {
	private int codigoProduto;
	private int codigo;
	private String nome;
	private float quantidade;
	private float precoUnitario;
	private UnidadeMedida medida;
	private List<HistoricoPreco> historico;
	/***
	 * Construtor default da classe Insumo
	 * instancia um novo objeto da classe Insumo e uma lista referente
	 * aos históricos de preço 
	 */
	public Insumo() {
		historico = new ArrayList<HistoricoPreco>();
	}

	/***
	 * Construtor sobrecarregado da classe insumo onde não são atribuídos valores default mas
	 * sim valores passados como parâmetro.
	 * @param nome - <code>String</code>: nomeação dada a um insumo
	 * @param quantidade - <code>int</code>: valor inicial do insumo
	 * @param precoUnitario - <code>float</code>: preço inicial do insumo
	 * @param historico - <code>List</code>: atualização de preços do insumo
	 */
	public Insumo(int codigoProduto, String nome, float quantidade, float precoUnitario, 
			List<HistoricoPreco> historico) {
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.historico = historico;
	}

	/***
	 * Obtém o nome de um insumo
	 * @return <code>String</code>: o nome do insumo definido através de nome.
	 */
	public String getNome() {
		return nome;
	}

	
	/***
	 * Atribui um nome ao objeto da classe Insumo.
	 * @param nome - <code>String</code>: nomeação do insumo a ser atribuída na classe.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/***
	 * Obtém a quantidade de um insumo
	 * @return <code>float</code> : retorna a quantidade disponível do objeto insumo.
	 */
	public float getQuantidade() {
		return quantidade;
	}

	/***
	 * Atribui um valor ao atributo quantidade da classe Insumo.
	 * @param quantidade - <code>float</code>: variável com o valor a ser atribuído ao objeto quantidade da classe insumo.
	 */
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	/***
	 * Obtém o preço unitário do insumo.
	 * @return <code>float</code>: o valor da unitário do objeto insumo
	 */
	public float getPrecoUnitario() {
		return precoUnitario;
	}

	/***
	 * Atribui um preço ao atributo precoUnitario da classe Insumo.
	 * @param precoUnitario - <code>float</code> : Valor a ser atribuído ao precoUnitario da classe Insumo
	 */
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	
	public UnidadeMedida getMedida() {
		return medida;
	}

	public void setMedida(UnidadeMedida medida) {
		this.medida = medida;
	}

	/***
	 * Obtém o histórico de preços do objeto insumo
	 * @return <code>List</code>: Retorna uma lista com todos preços já cadastrados para aquele objeto da classe Insumo
	 */
	public List<HistoricoPreco> getHistorico() {
		return historico;
	}

	/***
	 * Atribui uma lista com todos os preços já cadastrados para aquele objeto da classe Insumo
	 * @param historico <code>List</code>: Lista contendo o histórico de preços a ser atribuída ao objeto da classe Insumo
	 */
	public void setHistorico(List<HistoricoPreco> historico) {
		this.historico = historico;
	}

	
	/**
	 * Retorna o código na qual aquele insumo pertence.
	 * @return <code>int</code>: valor que referencia a que produto este insumo pertence.
	 */
	public int getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * Atribui ao insumo o código na qual aquele produto ele pertence.
	 * @param codigoProduto <code>int</code>: contém a referência indicativa de um produto.
	 */
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	
	/**
	 *Obtém o código de um insumo.
	 * @return <code>int</code>: o valor de um código do insumo.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui um código de identificação para determinado insumo.
	 * @param codigo - <code>int</code>: valor a ser atribuído para identificação de um insumo. 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Representação dos dados do objeto da classe Insumo em forma de Texto.
	 */
	@Override
	public String toString() {
		return String.format("Código: %d, nome: %s, quantidade: %.3f, precoUnitario: %.2f,"
				+ " historico: %s", getCodigo(), nome, quantidade, precoUnitario, historico);
	}
	
	
}
