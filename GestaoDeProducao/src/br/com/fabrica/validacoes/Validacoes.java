package br.com.fabrica.validacoes;

public class Validacoes {
	
	public static float validaFloat(String valor) {
		return Float.parseFloat(valor.replaceFirst(",", "."));
	}
	
	

}
