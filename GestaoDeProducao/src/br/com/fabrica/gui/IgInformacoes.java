package br.com.fabrica.gui;

import javax.swing.JFrame;
import static br.com.fabrica.gui.EntradaESaida.*;

@SuppressWarnings("serial")
public class IgInformacoes extends JFrame{
	private JFrame jf;
	private String mensagem;
	private String titulo;

	/**
	 * Create the panel.
	 */
	public IgInformacoes() {
		criaTela();
		
	}
	
	public void criaTela() {
		//jf.setTitle("");
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		jf.setSize(525, 187);
		jf.setVisible(true);
		jf.getContentPane().setLayout(null);
	}
	
	//public void informacaoInfo
	

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
	
}
