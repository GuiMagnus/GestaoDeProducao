package br.com.fabrica.modelo;

public enum UnidadeMedida {
	/**
	 * 
	 */
	GRAMA(1, "Grama", "g"), 
	QUILOGRAMA(2, "Quilograma", "kg"),
	MILILITRO(3, "Mililitro", "ml"),
	LITRO(4, "Litro", "l");
	
	private int codigo;
	private String nome;
	private String unidade;
	
	/**
	 * Instancia o construtor sobrecarregado da enum UnidadeMedida 
	 * e atribui os valores passados como parâmetro aos atributos da classe  
	 * @param codigo - <code>int</code> : Código referente ao tipo da enum
	 * @param nome - <code>String</code> : nome referente ao tipo da unidade da enum.
	 * @param unidade - <code>String</code> : abreviação do tipo da unidade do produto.
	 */
	private UnidadeMedida(int codigo, String nome, String unidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.unidade = unidade;
	}

	/**
	 * Obtém o código referente a unidade da enum.
	 * @return <code>int</code> código referente ao tipo da unidade da enum.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe o código referente a unidade da enum.
	 * @return <code>int</code> código referente ao tipo da unidade da enum.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtém o nome da unidade da enum.
	 * @return <code>String</code> Retorna o nome da unidade da enum.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui ao objeto o nome da unidade da enum.
	 * @return <code>String</code> : nome da unidade da enum.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém a abreviação da unidade da enum
	 * @return <code>String</code> : Abreviação do nome da unidade da enum.
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * Atribui ao objeto da classe abreviação da unidade da enum
	 * @return <code>String</code> : Abreviação do nome da unidade da enum.
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
}
