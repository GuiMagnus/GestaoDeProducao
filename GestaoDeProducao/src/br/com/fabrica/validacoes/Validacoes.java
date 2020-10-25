package br.com.fabrica.validacoes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validacoes {
	
	public static float transformaEmFloat(String valor) {
		return Float.parseFloat(valor.replaceFirst(",", "."));
	}
	
	public static String obtemHoraAtual() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	
	public static float validaFloat(String valor) {
		return Float.parseFloat(valor.replace(",", "."));
	}
	
	public static int obtemCodigo(String string) {
		return Integer.parseInt(string.split(" - ")[0]);
	}
	
	public static String obtemNome(String string) {
		return string.split(" - ")[1];
	}
	
	
	public static String verificaNome(String dado) {
		if(dado.equalsIgnoreCase(""))
			return null;
		else
			return dado;
	}
	
	public static float verificaQuantidade(String dado) {
		if(dado.equalsIgnoreCase(""))
			return 0;
		else
			return validaFloat(dado);
	}
	
	public static float verificaPreco(String dado) {
		if(dado.equalsIgnoreCase(""))
			return 0;
		else
			return validaFloat(dado);
	}
	

}
