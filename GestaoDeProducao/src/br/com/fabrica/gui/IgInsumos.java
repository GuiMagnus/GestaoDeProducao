package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.gerencia.ig.GerenciaIgInsumo;

/**
 * Classe responsavel por criar a tela de cadastro de Insumos.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgInsumos extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNome;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JTextField tfPreco;
	private JTextField tfNome;
	
	/**
	 * Create the panel.
	 */
	public IgInsumos() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);

		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		jf.setResizable(false);

		jf.setSize(420, 308);
		jf.setLocationRelativeTo(null);
		jf.setTitle("Cadastro de Insumos");

		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(167, 217, 96, 25);

		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(273, 217, 91, 25);

		lblNome = new JLabel("Nome:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(65, 70, 40, 16);

		lblNewLabel_1 = new JLabel("Quantidade:");
		jf.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(35, 118, 83, 16);


		lblNewLabel = new JLabel("Insumo");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(188, 22, 83, 19);

		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(130, 163, 130, 30);
		jf.getContentPane().add(tfPreco);

		
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(130, 64, 234, 30);
		jf.getContentPane().add(tfNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreo.setBounds(65, 169, 52, 16);
		jf.getContentPane().add(lblPreo);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(130, 113, 130, 29);
		jf.getContentPane().add(spinner);

		jf.setVisible(true);


		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgInsumo.cadastraInsumo(tfNome, spinner, tfPreco, jf);
				tfNome.setText("");
				spinner.setValue(0);
				tfPreco.setText("");

			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgMenu igMenu = new IgMenu();
				igMenu.getJf().setVisible(true);
			}
		});

	}

	/**
	 * Obtém a janela
	 * @return janela contendo 
	 */
	public JFrame getJf() {
		return jf;
	}

	/**
	 * Fornece a janela
	 * @param jf Janela
	 */
	public void setJf(JFrame jf) {
		this.jf = jf;
	}
}
