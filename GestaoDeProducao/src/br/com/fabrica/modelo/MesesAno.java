package br.com.fabrica.modelo;

/**
 * Enumera��o que determina os meses do ano, o n�mero referente a ele e quantos dias 
 * eles possuem.
 * @author Rafaela
 *
 */
public enum MesesAno {
	JANEIRO("Janeiro", 1, 31),
	FEVEREIRO("Fevereiro", 2, 28),
	MAR�O("Mar�o", 3, 31),
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
	 * Obt�m o nome do m�s do ano
	 * @return nome do m�s
	 */
	public String getMes() {
		return mes;
	}
	
	/**
	 * Determina o nome do m�s
	 * @param mes M�s que est� sendo determinado
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * Obt�m o n�meoro do m�s do ano
	 * @return n�mero do m�s
	 */
	public int getNumeroMes() {
		return numeroMes;
	}

	/**
	 * Determina o n�mero do m�s
	 * @param mes numero do mes que est� sendo determinado
	 */
	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	/**
	 * Obt�m a quantidade de dias m�s do ano
	 * @return quantidade de dias do m�s
	 */
	public int getQtdDias() {
		return qtdDias;
	}
	
	/**
	 * Determina a quantidade de dias do m�s
	 * @param mes quantidade de dias do M�s que est� sendo determinado
	 */
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	
	
}
