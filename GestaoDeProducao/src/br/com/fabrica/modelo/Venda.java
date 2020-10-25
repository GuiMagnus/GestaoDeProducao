package br.com.fabrica.modelo;

import java.util.List;

public class Venda {
	
	private int codigo;
	private String data;
	private String hora;
	private List<Produto> produtos;
	private int quantidade;// verificar pois o objeto produto já possui o atributo quantidade
	
	public Venda() {	}

	public Venda(String data, String hora, List<Produto> produtos, int quantidade) {
		this.data = data;
		this.hora = hora;
		this.produtos = produtos;
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float valorTotalVendaPorProduto() {
		float valor = 0;
		for(Produto produto : produtos)
			valor += produto.getPrecoFabricacao() * produto.getQuantidadeProduto();
		return valor;
	}
	
	@Override
	public String toString() {
		return String.format("Codigo: %d, data: %s, hora: %s, produto: %s, quantidade: %d",
				codigo, data, hora, produtos, quantidade);
	}
	
}
