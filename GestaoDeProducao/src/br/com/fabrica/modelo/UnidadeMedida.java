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
	 * e atribui os valores passados como par�metro aos atributos da classe  
	 * @param codigo - <code>int</code> : C�digo referente ao tipo da enum
	 * @param nome - <code>String</code> : nome referente ao tipo da unidade da enum.
	 * @param unidade - <code>String</code> : abrevia��o do tipo da unidade do produto.
	 */
	private UnidadeMedida(int codigo, String nome, String unidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.unidade = unidade;
	}

	/**
	 * Obt�m o c�digo referente a unidade da enum.
	 * @return <code>int</code> c�digo referente ao tipo da unidade da enum.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Atribui ao objeto da classe o c�digo referente a unidade da enum.
	 * @return <code>int</code> c�digo referente ao tipo da unidade da enum.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obt�m o nome da unidade da enum.
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
	 * Obt�m a abrevia��o da unidade da enum
	 * @return <code>String</code> : Abrevia��o do nome da unidade da enum.
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * Atribui ao objeto da classe abrevia��o da unidade da enum
	 * @return <code>String</code> : Abrevia��o do nome da unidade da enum.
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
}
