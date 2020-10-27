package br.com.fabrica.gerencia.modelo;

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

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getNumeroMes() {
		return numeroMes;
	}

	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	
	
}
