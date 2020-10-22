package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafaela
 * Classe respons�vel por armazenar os dados de um insumo(Tudo que for necess�rio para
 * a produ��o de um produto).
 * Exemplos de Insumo: 
 * -Maquin�rio, mat�ria-prima(farinha de trigo, leite, a��car, ovos, etc).
 */
public class Insumo {
	public final int codigo = ++geraCodigo;
	private static int geraCodigo;
	private String nome;
	private int quantidade;
	private float precoUnitario;
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
	 * @param nome nomea��o dada a um insumo
	 * @param quantidade valor inicial do insumo
	 * @param precoUnitario pre�o inicial do insumo
	 * @param historico atualiza��o de pre�os do insumo
	 */
	public Insumo(String nome, int quantidade, float precoUnitario, List<HistoricoPreco> historico) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.historico = historico;
	}

	/***
	 * Obt�m o nome de um insumo
	 * @return o nome do insumo definido atrav�s de nome.
	 */
	public String getNome() {
		return nome;
	}

	/***
	 * Atribui um nome ao objeto da classe Insumo.
	 * @param nome nomea��o do insumo a ser atribu�da na classe.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/***
	 * Obt�m a quantidade de um insumo
	 * @return retorna a quantidade dispon�vel do objeto insumo.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/***
	 * Atribui um valor ao atributo quantidade da classe Insumo.
	 * @param quantidade vari�vel com o valor a ser atribu�do ao objeto quantidade da classe insumo.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/***
	 * Obt�m o pre�o unit�rio do insumo.
	 * @return o valor da unit�rio do objeto insumo
	 */
	public float getPrecoUnitario() {
		return precoUnitario;
	}

	/***
	 * Atribui um pre�o ao atributo precoUnitario da classe Insumo.
	 * @param precoUnitario Valor a ser atribu�do ao precoUnitario da classe Insumo
	 */
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/***
	 * Obt�m o hist�rico de pre�os do objeto insumo
	 * @return Retorna uma lista com todos pre�os j� cadastrados para aquele objeto da classe Insumo
	 */
	public List<HistoricoPreco> getHistorico() {
		return historico;
	}

	/***
	 * Atribui uma lista com todos os pre�os j� cadastrados para aquele objeto da classe Insumo
	 * @param historico Lista contendo o hist�rico de pre�os a ser atribu�da ao objeto da classe Insumo
	 */
	public void setHistorico(List<HistoricoPreco> historico) {
		this.historico = historico;
	}

	/**
	 * Representa��o dos dados do objeto da classe Insumo em forma de Texto.
	 */
	@Override
	public String toString() {
		return String.format("C�digo: %d, nome: %s, quantidade: %d, precoUnitario: %.2f,"
				+ " historico: %s", codigo, nome, quantidade, precoUnitario, historico);
	}
	
	
}
