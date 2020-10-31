package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafaela e Guilherme
 * 
 * Classe respons�vel por armazenar os dados de um insumo(Tudo que for necess�rio para
 * a produ��o de um produto).
 * Exemplos de Insumo: 
 * -Maquin�rio, mat�ria-prima(farinha de trigo, leite, a��car, ovos, etc).
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
	 * aos hist�ricos de pre�o 
	 */
	public Insumo() {
		historico = new ArrayList<HistoricoPreco>();
	}

	/***
	 * Construtor sobrecarregado da classe insumo onde n�o s�o atribu�dos valores default mas
	 * sim valores passados como par�metro.
	 * @param nome - <code>String</code>: nomea��o dada a um insumo
	 * @param quantidade - <code>int</code>: valor inicial do insumo
	 * @param precoUnitario - <code>float</code>: pre�o inicial do insumo
	 * @param historico - <code>List</code>: atualiza��o de pre�os do insumo
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
	 * Obt�m o nome de um insumo
	 * @return <code>String</code>: o nome do insumo definido atrav�s de nome.
	 */
	public String getNome() {
		return nome;
	}

	
	/***
	 * Atribui um nome ao objeto da classe Insumo.
	 * @param nome - <code>String</code>: nomea��o do insumo a ser atribu�da na classe.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/***
	 * Obt�m a quantidade de um insumo
	 * @return <code>float</code> : retorna a quantidade dispon�vel do objeto insumo.
	 */
	public float getQuantidade() {
		return quantidade;
	}

	/***
	 * Atribui um valor ao atributo quantidade da classe Insumo.
	 * @param quantidade - <code>float</code>: vari�vel com o valor a ser atribu�do ao objeto quantidade da classe insumo.
	 */
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	/***
	 * Obt�m o pre�o unit�rio do insumo.
	 * @return <code>float</code>: o valor da unit�rio do objeto insumo
	 */
	public float getPrecoUnitario() {
		return precoUnitario;
	}

	/***
	 * Atribui um pre�o ao atributo precoUnitario da classe Insumo.
	 * @param precoUnitario - <code>float</code> : Valor a ser atribu�do ao precoUnitario da classe Insumo
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
	 * Obt�m o hist�rico de pre�os do objeto insumo
	 * @return <code>List</code>: Retorna uma lista com todos pre�os j� cadastrados para aquele objeto da classe Insumo
	 */
	public List<HistoricoPreco> getHistorico() {
		return historico;
	}

	/***
	 * Atribui uma lista com todos os pre�os j� cadastrados para aquele objeto da classe Insumo
	 * @param historico <code>List</code>: Lista contendo o hist�rico de pre�os a ser atribu�da ao objeto da classe Insumo
	 */
	public void setHistorico(List<HistoricoPreco> historico) {
		this.historico = historico;
	}

	
	/**
	 * Retorna o c�digo na qual aquele insumo pertence.
	 * @return <code>int</code>: valor que referencia a que produto este insumo pertence.
	 */
	public int getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * Atribui ao insumo o c�digo na qual aquele produto ele pertence.
	 * @param codigoProduto <code>int</code>: cont�m a refer�ncia indicativa de um produto.
	 */
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	
	/**
	 *Obt�m o c�digo de um insumo.
	 * @return <code>int</code>: o valor de um c�digo do insumo.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui um c�digo de identifica��o para determinado insumo.
	 * @param codigo - <code>int</code>: valor a ser atribu�do para identifica��o de um insumo. 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Representa��o dos dados do objeto da classe Insumo em forma de Texto.
	 */
	@Override
	public String toString() {
		return String.format("C�digo: %d, nome: %s, quantidade: %.3f, precoUnitario: %.2f,"
				+ " historico: %s", getCodigo(), nome, quantidade, precoUnitario, historico);
	}
	
	
}
