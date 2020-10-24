package br.com.fabrica.modelo;

public class Producao {
	public final int codigo = ++geraCodigo;
	private static int geraCodigo;
	private int auxiliarCodigo;
	private Produto produto;
	private int quantidade;
	private String data;
	private float custoProducao;
	public Producao() {	}

	public Producao(Produto produto, int quantidade, String data, float custoProducao) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
		this.custoProducao = custoProducao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public int getAuxiliarCodigo() {
		return auxiliarCodigo;
	}

	public void setAuxiliarCodigo(int auxiliarCodigo) {
		this.auxiliarCodigo = auxiliarCodigo;
	}

	public float getCustoProducao() {
		return custoProducao;
	}

	public void setCustoProducao(float custoProducao) {
		this.custoProducao = custoProducao;
	}
	
	public float obtemCustoProducao() {
		return produto.getPrecoFabricacao() * quantidade;
	}
	
	@Override
	public String toString() {
		return String.format("Codigo: %d, produto: %s, quantidade: %d, data: %s, custoProducao:%s",
				codigo, produto.getNome(), quantidade, data, custoProducao);
	}
	
}
