package gestao.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IgRelatorioProducao extends JFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTable table;
	private JTextField textField_3;
	private JLabel lblNome;
	private JLabel lblData;
	private JButton btnObterDados;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JButton btnCancelar;
	private JFrame jf;

	/**
	 * Create the panel.
	 */
	public IgRelatorioProducao() {

		jf = new JFrame();
		jf.getContentPane().setEnabled(false);
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		
		//jf.setSize(626, 473);
		
		lblNewLabel = new JLabel("Venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(255, 22, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("Data inicial:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(39, 56, 83, 25);
		jf.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(121, 59, 75, 20);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dados da Produ\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(224, 119, 165, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOk.setBounds(356, 480, 89, 23);
		jf.getContentPane().add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(455, 480, 89, 23);
		jf.getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 155, 504, 299);
		jf.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(40, 158, 411, 256);
		scrollPane.setViewportView(table);
		
		lblData = new JLabel("Data final:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(208, 56, 75, 25);
		jf.getContentPane().add(lblData);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(281, 59, 83, 20);
		jf.getContentPane().add(textField_3);
		
		btnObterDados = new JButton("Obter dados produ\u00E7\u00E3o");
		btnObterDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnObterDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnObterDados.setBounds(379, 57, 165, 23);
		jf.getContentPane().add(btnObterDados);
		jf.getContentPane().setLayout(null);
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		jf.setSize(591, 568);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
