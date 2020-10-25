package br.com.fabrica.gui;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;

public class EntradaESaida {
	/**
	 * Exibe uma mensagem informativa em uma caixa de diálogo com o texto da 
	 * barra de título definido em titulo.
	 * @param component Componemte em que a caixa de diálogo vai pertencer
	 * @param mensagem Mensagem que será fornecida ao usuário
	 * @param titulo Titulo da janela de diálogo
	 */
	public static void msgInfo(Component component, String mensagem, String titulo) {
		showMessageDialog(component, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe um componente em uma caixa de diálogo com o texto da barra de título 
	 * definido em titulo.
	 * @param component Componemte em que a caixa de diálogo vai pertencer
	 * @param titulo Titulo da janela de diálogo
	 */
	public static void msgInfo(Object componente, String titulo) {
		showMessageDialog(null, componente, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe uma mensagem de erro em uma caixa de diálogo com o texto da barra de 
	 * título definido em titulo.
	 * @param component Componemte em que a caixa de diálogo vai pertencer
	 * @param mensagem Mensagem que será fornecida ao usuário
	 * @param titulo Titulo da janela de diálogo
	 */
	public static void msgErro(Component component, String mensagem, String titulo) {
		showMessageDialog(component, mensagem, titulo, ERROR_MESSAGE);
	}
	
} // class EntradaESaida