package br.com.fabrica.validacoes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;

import br.com.fabrica.modelo.UnidadeMedida;
import static br.com.fabrica.constantes.Constantes.*;
/**
 * Classe responsável por implementar validações.
 * @author Rafaela
 *
 */
public class Validacoes {
	
	/**
	 * Obtém a unidade de medida de um produto.
	 * @param comboBox - <code>JCombobox</code> : fornece a opção de unidade de medida
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
	 * Obtém um valor do tipo <code>String</code> e transforma em um valor do tipo
	 *  <code>float</code>
	 * @param valor - <code>String</code> : valor a ser convertido.
	 * @return - <code>float</code> valor transformado.
	 */
	public static float transformaEmFloat(String valor) {
		if(valor.equals(""))
			return 0;
		return Float.parseFloat(valor.replaceFirst(",", "."));
	}
	
	
	/**
	 * Obtém um valor do tipo <code>String</code> e transforma em um valor do tipo
	 *  <code>int</code>
	 * @param valor - <code>String</code> : valor a ser convertido.
	 * @return - <code>int</code> valor transformado.
	 */
	public static int transformaEmInt(String valor) {
		return Integer.parseInt(valor);
	}
	
	/**
	 * Obtem a hora atual.
	 * @return - <code>String</code> : horário atual
	 */
	public static String obtemHoraAtual() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);

	}
	
	/**
	 * Obtém um código a partir de uma string
	 * @param string - <code>String</code> : texto de onde irá tirar o código.
	 * @return - <code>int</code> : código extraido
	 */
	public static int obtemCodigo(String string) {
		if(string.equalsIgnoreCase(VALOR_DEFAULT_COMBOBOX))
			return 0;
		return Integer.parseInt(string.split(" - ")[0]);
	}
	
	/**
	 * Obtém um nome a partir de uma string
	 * @param string - <code>String</code> : texto de onde irá tirar o nome.
	 * @return - <code>int</code> : nome extraido
	 */
	public static String obtemNome(String string) {
		return string.split(" - ")[1];
	}
	
	/**
	 * Verifica se o nome informado é válido
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
	 * Verifica se a quantidade informado é válido
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
	 * Verifica se o preço informado é válido
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
	 * Verifica se na <code>String</code> passada como parâmentro contém letra;
	 * @param string <code>String</code> a ser verificada.
	 * @return a <code>String</code> se nela conter apenas números.
	 */
	public static String verificaContemNumero(String string) {
		if(string.contains("\\D+"))
			return "";
		return string;
	}

	
	/**
	 * Verifica a medida que está armazenada na variável passada como parâmetro com os valores da enum UnidadeMedida e 
	 * caso contenha, retorna esse valor. 
	 * 
	 * @param medida valor a ser comparado com o atributo da enum para verificação de que tipo de medida está sendo usado(kg,g,ml,l)
	 * @return retorna o tipo da medida ou um valor nulo.
	 */
	public static UnidadeMedida verificaMedida(String medida) {
		for ( UnidadeMedida dado : UnidadeMedida.values()) {
			if(dado.getUnidade().equalsIgnoreCase(medida))
				return dado;
		}
		return null;
	}

}
