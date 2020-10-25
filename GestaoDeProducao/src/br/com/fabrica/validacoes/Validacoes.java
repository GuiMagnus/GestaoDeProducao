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
}
