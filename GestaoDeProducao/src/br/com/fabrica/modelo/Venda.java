package br.com.fabrica.modelo;

public class Venda {
	public final int codigo = ++geraCodigo;
	private static int geraCodigo;
	private int auxiliarCodigo;
	private String data;
	private String hora;
	private Produto produto;
	private int quantidade;// verificar pois o objeto produto já possui o atributo quantidade
	
	public Venda() {	}

	public Venda(String data, String hora, Produto produto, int quantidade) {
		this.data = data;
		this.hora = hora;
		this.produto = produto;
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

	public int getAuxiliarCodigo() {
		return auxiliarCodigo;
	}

	public void setAuxiliarCodigo(int auxiliarCodigo) {
		this.auxiliarCodigo = auxiliarCodigo;
	}
	
	public float valorTotalVendaPorProduto() {
		
		return produto.getPrecoFabricacao() * produto.getQuantidadeProduto();
	}
	
	@Override
	public String toString() {
		return String.format("Codigo: %d, data: %s, hora: %s, produto: %s, quantidade: %d",
				codigo, data, hora, produto, quantidade);
	}
	
}
