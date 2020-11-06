package br.com.fabrica.modelo;

/**
 * Enumeração que determina os meses do ano, o número referente a ele e quantos dias 
 * eles possuem.
 * @author Rafaela
 *
 */
public enum MesesAno {
	JANEIRO("Janeiro", 1, 31),
	FEVEREIRO("Fevereiro", 2, 28),
	MARÇO("Março", 3, 31),
	ABRIL("Abril", 4, 30),
	MAIO("Maio", 5, 31),
	JUNHO("Junho", 6, 30),
	JULHO("Julho", 7, 31),
	AGOSTO("Agosto", 8, 31),
	SETEMBRO("Setembro", 9, 30),
	OUTRUBRO("Outubro", 10, 31),
	NOVEMBRO("Novembro", 11, 30),
	DEZEMBRO("Dezembro", 12, 31);
	
	private String mes;
	private int numeroMes;
	private int qtdDias;
	
	private MesesAno(String mes, int numeroMes, int qtdDias) {
		this.mes = mes;
		this.numeroMes = numeroMes;
		this.qtdDias = qtdDias;
	}

	/**
	 * Obtém o nome do mês do ano
	 * @return nome do mês
	 */
	public String getMes() {
		return mes;
	}
	
	/**
	 * Determina o nome do mês
	 * @param mes Mês que está sendo determinado
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * Obtém o númeoro do mês do ano
	 * @return número do mês
	 */
	public int getNumeroMes() {
		return numeroMes;
	}

	/**
	 * Determina o número do mês
	 * @param mes numero do mes que está sendo determinado
	 */
	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	/**
	 * Obtém a quantidade de dias mês do ano
	 * @return quantidade de dias do mês
	 */
	public int getQtdDias() {
		return qtdDias;
	}
	
	/**
	 * Determina a quantidade de dias do mês
	 * @param mes quantidade de dias do Mês que está sendo determinado
	 */
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	
	
}
