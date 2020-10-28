package br.com.fabrica.validacoes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;

import br.com.fabrica.modelo.UnidadeMedida;

/**
 * Classe respons�vel por implementar valida��es.
 * @author Rafaela
 *
 */
public class Validacoes {
	
	/**
	 * Obt�m a unidade de medida de um produto.
	 * @param comboBox - <code>JCombobox</code> : fornece a op��o de unidade de medida
	 * @return - <code>UnidadeMedida</code> : a unidade de medida selecionada.
	 * @see UnidadeMedida
	 */
	public static UnidadeMedida obtemUnidade(JComboBox<String> comboBox) {
		UnidadeMedida unidade = null;
		for(UnidadeMedida um : UnidadeMedida.values()) {
			if(comboBox.getSelectedItem().toString().contains(um.getNome()))
				unidade = um;
		}
		
		return unidade;
	}
	
	/**
	 * Obt�m um valor do tipo <code>String</code> e transforma em um valor do tipo
	 *  <code>float</code>
	 * @param valor - <code>String</code> : valor a ser convertido.
	 * @return - <code>float</code> valor transformado.
	 */
	public static float transformaEmFloat(String valor) {
		return Float.parseFloat(valor.replaceFirst(",", "."));
	}
	
	/**
	 * Obtem a hora atual.
	 * @return - <code>String</code> : hor�rio atual
	 */
	public static String obtemHoraAtual() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);

	}
	
	/**
	 * Obt�m um c�digo a partir de uma string
	 * @param string - <code>String</code> : texto de onde ir� tirar o c�digo.
	 * @return - <code>int</code> : c�digo extraido
	 */
	public static int obtemCodigo(String string) {
		return Integer.parseInt(string.split(" - ")[0]);
	}
	
	/**
	 * Obt�m um nome a partir de uma string
	 * @param string - <code>String</code> : texto de onde ir� tirar o nome.
	 * @return - <code>int</code> : nome extraido
	 */
	public static String obtemNome(String string) {
		return string.split(" - ")[1];
	}
	
	/**
	 * Verifica se o nome informado � v�lido
	 * @param dado - <code>String</code> : string a ser verificada.
	 * @return- <code>String</code> : string verificada ou nulo
	 */
	public static String verificaNome(String dado) {
		if(dado.equalsIgnoreCase(null))
			return null;
		else
			return dado;
	}
	
	/**
	 * Verifica se a quantidade informado � v�lido
	 * @param dado - <code>String</code> : string a ser verificada.
	 * @return- <code>float</code> : string convertida em float ou o valor 0;
	 */
	public static float verificaQuantidade(String dado) {
		if(dado.equalsIgnoreCase(""))
			return 0;
		else
			return transformaEmFloat(dado);
	}
	
	/**
	 * Verifica se o pre�o informado � v�lido
	 * @param dado - <code>String</code> : string a ser verificada.
	 * @return- <code>float</code> : string convertida em float ou o valor 0;
	 */
	public static float verificaPreco(String dado) {
		if(dado.equalsIgnoreCase(""))
			return 0;
		else
			return transformaEmFloat(dado);
	}
	
	public static String obtemExpressoes(String palavra, String expressaoRegular) {
		String palavras = "";
		
		Pattern pattern = Pattern.compile(expressaoRegular);
		
		Matcher matcher = pattern.matcher(palavra);
		
		while (matcher.find())
			palavras += String.format("%s\n", matcher.group());

		return palavras;
	}
	
	/**
	 * Verifica se na <code>String</code> passada como par�mentro cont�m letra;
	 * @param string <code>String</code> a ser verificada.
	 * @return a <code>String</code> se nela conter apenas n�meros.
	 */
	public static String verificaContemNumero(String string) {
		if(string.contains("\\D+"))
			return "";
		return string;
	}
	
	public static void main(String[] args) {
		System.out.println(obtemExpressoes("121", "\\w+"));
	}
	


}
