package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.modelo.Venda;

/**
 * Classe responsavel por criar a tela de relatório de Vendas.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgRelatorioVendas extends JFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblData;
	private JButton btnObtemDados;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JLabel lblValorDaVenda;
	private JLabel lblNewLabel_1_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnOk;
	private JButton btnCancelar;
	private JFrame jf;
	private DefaultTableModel defaultTableModel;

	/**
	 * Create the panel.
	 */
	public IgRelatorioVendas() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		
		jf.setSize(731, 620);

		
		lblNewLabel = new JLabel("Venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(305, 20, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("Data ou hora inicial:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(39, 56, 129, 25);
		jf.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(178, 59, 83, 20);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Dados da Produ\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(260, 119, 165, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOk.setBounds(497, 543, 89, 23);
		jf.getContentPane().add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(596, 543, 89, 23);
		jf.getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 155, 645, 260);
		jf.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(40, 158, 411, 256);
		scrollPane.setViewportView(table);
		
		lblData = new JLabel("Data ou hora final:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(281, 56, 121, 25);
		jf.getContentPane().add(lblData);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(412, 59, 83, 20);
		jf.getContentPane().add(textField_3);
		
		btnObtemDados = new JButton("Obter dados das vendas");
		btnObtemDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBounds(new Rectangle(22, 0, 300, 300));
		scrollPane.setViewportView(table);
		
		String[] colunas = new String[] {"Código da Venda", "Nome do produto","Quantidade","Preço Unitário","Valor Total"};
		defaultTableModel = new DefaultTableModel(colunas, 0);
		table.setModel(defaultTableModel);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);

		btnObtemDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venda venda = new Venda("02/01/1997", "02:01", null,3); 
				defaultTableModel.insertRow(defaultTableModel.getRowCount(),
					new Object[] {venda.getCodigo(), "a",
								2.5f,37.5f,105.6f});
			}
		});
		btnObtemDados.setBounds(505, 57, 180, 23);
		jf.getContentPane().add(btnObtemDados);
		
		lblValorDaVenda = new JLabel("Valor da venda total");
		lblValorDaVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorDaVenda.setBounds(39, 426, 141, 25);
		jf.getContentPane().add(lblValorDaVenda);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(178, 429, 129, 20);
		jf.getContentPane().add(textField_1);
		
		lblNewLabel_1_1 = new JLabel("Classifica\u00E7\u00E3o das vendas");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(39, 460, 222, 25);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		btnNewButton_3 = new JButton("Classificar relat\u00F3rio por data da venda");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(99, 496, 251, 23);
		jf.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Classificar relat\u00F3rio por hora da venda");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBounds(368, 496, 261, 23);
		jf.getContentPane().add(btnNewButton_4);
		
		jf.setVisible(true);

		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
