package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.fabrica.gerencia.ig.GerenciaIgProducao;

import javax.swing.JComboBox;

/**
 * Classe responsavel por criar a tela de cadastro de Produção.
 * @author Rafaela
 *
 */

@SuppressWarnings("serial")
public class IgProducao extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblMargemDeLucro;
	private JLabel lblNewLabel_1;
	private JLabel lblNome;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JTextField tfData;
	private JTextField tfQtdProduzida;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public IgProducao() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		
		jf.setSize(468, 309);
		
		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(221, 209, 96, 25);
		
		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(327, 209, 90, 25);
		
		lblNome = new JLabel("Nome do Produto:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(38, 67, 122, 16);
		
		lblNewLabel_1 = new JLabel("Data da Produ\u00E7\u00E3o:");
		jf.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(38, 108, 122, 16);
		
		
		lblNewLabel = new JLabel("Produ\u00E7\u00E3o");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(184, 22, 83, 19);
		
		lblMargemDeLucro = new JLabel("Quantidade produzida:");
		jf.getContentPane().add(lblMargemDeLucro);
		lblMargemDeLucro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMargemDeLucro.setBounds(13, 149, 147, 16);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(177, 102, 141, 30);
		jf.getContentPane().add(tfData);
		
		tfQtdProduzida = new JTextField();
		tfQtdProduzida.setColumns(10);
		tfQtdProduzida.setBounds(177, 143, 140, 30);
		jf.getContentPane().add(tfQtdProduzida);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(177, 65, 240, 30);
		jf.getContentPane().add(comboBox);
		
		jf.setVisible(true);
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgProducao.cadastrarProducao(comboBox, tfData, tfQtdProduzida, jf);
				comboBox.setSelectedIndex(0);
				tfData.setText("");
				tfQtdProduzida.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}
