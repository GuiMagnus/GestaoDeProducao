package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IgOrcamento extends JFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNome;
	private JComboBox<?> comboBox;
	private JLabel lblOramento;
	private JLabel lblNewLabel_1;
	private JLabel lblPreoUnitrio;
	private JLabel lblMargemDeLucro;
	private JLabel lblSaldo;
	private JLabel lblSaldo_1;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JFrame jf;

	/**
	 * Create the panel.
	 */
	public IgOrcamento() {
		jf = new JFrame();
		
		lblNewLabel = new JLabel("Per\u00EDodo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(179, 23, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("M\u00EAs:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(30, 57, 47, 25);
		jf.getContentPane().add(lblNome);
		
		lblNewLabel_1 = new JLabel("Valor total dos insumos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 132, 161, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(201, 135, 161, 20);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 211, 161, 20);
		jf.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(165, 369, 89, 23);
		jf.getContentPane().add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(273, 369, 89, 23);
		jf.getContentPane().add(btnCancelar);
		
		
		lblPreoUnitrio = new JLabel("N\u00FAmero total de vendas");
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreoUnitrio.setBounds(30, 169, 161, 25);
		jf.getContentPane().add(lblPreoUnitrio);
		
		lblMargemDeLucro = new JLabel("Valor total das vendas");
		lblMargemDeLucro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMargemDeLucro.setBounds(30, 208, 161, 25);
		jf.getContentPane().add(lblMargemDeLucro);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 172, 161, 20);
		jf.getContentPane().add(textField_2);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(74, 59, 161, 22);
		jf.getContentPane().add(comboBox);
		
		lblOramento = new JLabel("Or\u00E7amento");
		lblOramento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOramento.setBounds(165, 96, 89, 25);
		jf.getContentPane().add(lblOramento);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSaldo.setBounds(177, 257, 89, 25);
		jf.getContentPane().add(lblSaldo);
		
		lblSaldo_1 = new JLabel("Saldo");
		lblSaldo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSaldo_1.setBounds(30, 299, 47, 25);
		jf.getContentPane().add(lblSaldo_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(74, 302, 161, 20);
		jf.getContentPane().add(textField_3);
		
		
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usu�rio clicar no bot�o Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como n�o redimension�vel.
		//jf.setResizable(false);
		
		jf.setSize(415, 473);
		
		jf.setVisible(true);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}