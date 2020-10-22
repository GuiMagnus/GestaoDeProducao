package br.com.fabrica.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafaela
 * Classe responsável por armazenar os dados de um insumo(Tudo que for necessário para
 * a produção de um produto).
 * Exemplos de Insumo: 
 * -Maquinário, matéria-prima(farinha de trigo, leite, açúcar, ovos, etc).
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
	 * aos históricos de preço 
	 */
	public Insumo() {
		historico = new ArrayList<HistoricoPreco>();
	}

	/***
	 * Construtor sobrecarregado da classe insumo onde não são atribuídos valores default mas
	 * sim valores passados como parâmetro.
	 * @param nome nomeação dada a um insumo
	 * @param quantidade valor inicial do insumo
	 * @param precoUnitario preço inicial do insumo
	 * @param historico atualização de preços do insumo
	 */
	public Insumo(String nome, int quantidade, float precoUnitario, List<HistoricoPreco> historico) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.historico = historico;
	}

	/***
	 * Obtém o nome de um insumo
	 * @return o nome do insumo definido através de nome.
	 */
	public String getNome() {
		return nome;
	}

	/***
	 * Atribui um nome ao objeto da classe Insumo.
	 * @param nome nomeação do insumo a ser atribuída na classe.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/***
	 * Obtém a quantidade de um insumo
	 * @return retorna a quantidade disponível do objeto insumo.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/***
	 * Atribui um valor ao atributo quantidade da classe Insumo.
	 * @param quantidade variável com o valor a ser atribuído ao objeto quantidade da classe insumo.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/***
	 * Obtém o preço unitário do insumo.
	 * @return o valor da unitário do objeto insumo
	 */
	public float getPrecoUnitario() {
		return precoUnitario;
	}

	/***
	 * Atribui um preço ao atributo precoUnitario da classe Insumo.
	 * @param precoUnitario Valor a ser atribuído ao precoUnitario da classe Insumo
	 */
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/***
	 * Obtém o histórico de preços do objeto insumo
	 * @return Retorna uma lista com todos preços já cadastrados para aquele objeto da classe Insumo
	 */
	public List<HistoricoPreco> getHistorico() {
		return historico;
	}

	/***
	 * Atribui uma lista com todos os preços já cadastrados para aquele objeto da classe Insumo
	 * @param historico Lista contendo o histórico de preços a ser atribuída ao objeto da classe Insumo
	 */
	public void setHistorico(List<HistoricoPreco> historico) {
		this.historico = historico;
	}

	/**
	 * Representação dos dados do objeto da classe Insumo em forma de Texto.
	 */
	@Override
	public String toString() {
		return String.format("Código: %d, nome: %s, quantidade: %d, precoUnitario: %.2f,"
				+ " historico: %s", codigo, nome, quantidade, precoUnitario, historico);
	}
	
	
}
