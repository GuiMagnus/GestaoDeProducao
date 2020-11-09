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

import br.com.fabrica.gerencia.ig.GerenciaIgRelatorioVenda;
import java.awt.Color;

/**
 * Classe responsavel por criar a tela de relatório de Vendas.
 * @author Rafaela e Guilherme
 *
 */
@SuppressWarnings("serial")
public class IgRelatorioVendas extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfDataHoraInicial;
	private JTable table;
	private JTextField tfDataHoraFinal;
	private JTextField tfValorTotalVenda;
	private JLabel lblNome;
	private JLabel lblData;
	private JButton btnObtemDados;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JLabel lblValorDaVenda;
	private JLabel lblNewLabel_1_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnCancelar;
	private JFrame jf;
	private DefaultTableModel defaultTableModel;
	private static String dataHoraInicial,dataHoraFinal;
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
		jf.setResizable(false);
		
		jf.setSize(731, 620);

		jf.setLocationRelativeTo(null);
		
		jf.setTitle("Relatório de Vendas");
		
		lblNewLabel = new JLabel("Venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(305, 20, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("Data ou hora inicial:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(39, 56, 129, 25);
		jf.getContentPane().add(lblNome);
		
		tfDataHoraInicial = new JTextField();
		tfDataHoraInicial.setBounds(178, 59, 83, 20);
		jf.getContentPane().add(tfDataHoraInicial);
		tfDataHoraInicial.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Dados da Produ\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(260, 119, 165, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnCancelar = new JButton("OK");
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
		
		tfDataHoraFinal = new JTextField();
		tfDataHoraFinal.setColumns(10);
		tfDataHoraFinal.setBounds(412, 59, 83, 20);
		jf.getContentPane().add(tfDataHoraFinal);
		
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
				defaultTableModel.setNumRows(0);
				GerenciaIgRelatorioVenda.relatorioVendas(tfDataHoraInicial,tfDataHoraFinal,tfValorTotalVenda,defaultTableModel,colunas);
				dataHoraInicial = tfDataHoraInicial.getText();
				dataHoraFinal = tfDataHoraFinal.getText();
				tfDataHoraInicial.setText("");
				tfDataHoraFinal.setText("");
			}
		});
		btnObtemDados.setBounds(505, 57, 180, 23);
		jf.getContentPane().add(btnObtemDados);
		
		lblValorDaVenda = new JLabel("Valor da venda total");
		lblValorDaVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorDaVenda.setBounds(39, 426, 141, 25);
		jf.getContentPane().add(lblValorDaVenda);
		
		tfValorTotalVenda = new JTextField();
		tfValorTotalVenda.setDisabledTextColor(Color.BLACK);
		tfValorTotalVenda.setEditable(false);
		tfValorTotalVenda.setColumns(10);
		tfValorTotalVenda.setBounds(178, 429, 129, 20);
		jf.getContentPane().add(tfValorTotalVenda);
		
		lblNewLabel_1_1 = new JLabel("Classifica\u00E7\u00E3o das vendas");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(39, 460, 222, 25);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		btnNewButton_3 = new JButton("Classificar relat\u00F3rio por data da venda");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciaIgRelatorioVenda.ordenacaoData(defaultTableModel, dataHoraInicial,dataHoraFinal);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(99, 496, 251, 23);
		jf.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Classificar relat\u00F3rio por hora da venda");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciaIgRelatorioVenda.ordenacaoHora(defaultTableModel, dataHoraInicial,dataHoraFinal);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBounds(368, 496, 261, 23);
		jf.getContentPane().add(btnNewButton_4);
		
		jf.setVisible(true);

		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgMenu igMenu = new IgMenu();
				igMenu.getJf().setVisible(true);
			}
		});
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	
	
}
