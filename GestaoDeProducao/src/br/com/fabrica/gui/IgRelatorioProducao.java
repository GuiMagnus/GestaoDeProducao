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

import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

/**
 * Classe responsavel por criar a tela de Relatorio de produção
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgRelatorioProducao extends JFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_3;
	private JLabel lblNome;
	private JLabel lblData;
	private JButton btnObterDados;
	private JButton btnOk;
	private JButton btnCancelar;
	private JFrame jf;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public IgRelatorioProducao() {
		System.out.println("-------------------->");
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
		String[] colunas = new String[] {"Nome do produto", "Quantidade produzida","Custo total de produção"};
		defaultTableModel = new DefaultTableModel(colunas, 0);

		//defaultTableModel.insertRow(defaultTableModel.getRowCount(), new Object[] {prod.getNome(), prod.getQuantidadeProduto()+(int)spinner.getValue(),prod.getPrecoFabricacao()});
		// Define a posição, o tamanho e exibe a janela.
		
		
		
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
		
		
		btnObterDados.setBounds(379, 57, 165, 23);
		jf.getContentPane().add(btnObterDados);
		jf.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(39, 151, 505, 318);
		jf.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		
		scrollPane.setViewportView(table);
		
		defaultTableModel = new DefaultTableModel(colunas, 0);
		table.setModel(defaultTableModel);
		//defaultTableModel.insertRow(defaultTableModel.getRowCount(), new Object[] {prod.getNome(), prod.getQuantidadeProduto()+(int)spinner.getValue(),prod.getPrecoFabricacao()});
		// Define a posição, o tamanho e exibe a janela.
		setBounds(100, 100, 428, 314);
		
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
		jf.setVisible(true);
		btnObterDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto("Aaa",UnidadeMedida.QUILOGRAMA,5.0f,10.0f,1,null,null);
				Producao producao = new Producao(produto,1,"02/01/1997",5.0f);
				defaultTableModel.insertRow(defaultTableModel.getRowCount(),
						new Object[] {producao.getCodigo(), producao.getQuantidade(),
								producao.getCustoProducao()});
				//System.out.println("aqui");
			}
		});
	}
}
