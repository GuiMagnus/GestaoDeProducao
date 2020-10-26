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
	
	public Produto() {
		historicoPrecos = new ArrayList<HistoricoPreco>();
		insumos = new ArrayList<Insumo>();
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public float getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(float margemLucro) {
		this.margemLucro = margemLucro;
	}

	public float getPrecoFabricacao() {
		return precoFabricacao;
	}
	
	public void setPrecoFabricacao(float precoFabricacao) {
		this.precoFabricacao = precoFabricacao;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public List<HistoricoPreco> getHistoricoPrecos() {
		return historicoPrecos;
	}

	public void setHistoricoPrecos(List<HistoricoPreco> historicoPrecos) {
		this.historicoPrecos = historicoPrecos;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int auxiliarCodigo) {
		this.codigo = auxiliarCodigo;
	}
	

	
	
	@Override
	public String toString() {
		return String.format(
				"Código: %d, nome: %s, unidadeMedida: %s, margemLucro: %.2f, "
				+ "precoFabricacao: %.2f, precoVenda: %.2f, quantidadeProduto: %d",
				codigo, nome, unidadeMedida.getUnidade(), margemLucro, precoFabricacao,
				precoVenda, quantidadeProduto); 
	}
	
}
