package br.com.fabrica.modelo;

public enum UnidadeMedida {
	GRAMA(1, "Grama", "g"),
	QUILOGRAMA(2, "Quilograma", "kg"),
	MILILITRO(3, "Mililitro", "ml"),
	LITRO(4, "Litro", "l");
	
	private int codigo;
	private String nome;
	private String unidade;
	
	private UnidadeMedida(int codigo, String nome, String unidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.unidade = unidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
}
