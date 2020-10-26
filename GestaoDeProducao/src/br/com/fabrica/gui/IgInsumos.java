package br.com.fabrica.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.ig.GerenciaIgInsumo;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

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
	private JTextField tfTamanho;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox<String> comboBox;
	private List<Produto> listaProdutos;
	public static ArquivoProduto arqProduto = new ArquivoProduto();
	private JButton btnPesquisar;
	/**
	 * Create the panel.
	 */
	public IgInsumos() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);

		// Define que o programa deve ser finalizado quando o usu�rio clicar no bot�o Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como n�o redimension�vel.
		//jf.setResizable(false);

		jf.setSize(501, 595);

		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(267, 495, 96, 25);

		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(379, 495, 83, 25);

		lblNome = new JLabel("Nome do Produto:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(38, 67, 122, 16);

		lblNewLabel_1 = new JLabel("Tamanho da unidade:");
		jf.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(38, 108, 122, 16);


		lblNewLabel = new JLabel("Insumo");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(202, 11, 83, 19);

		tfTamanho = new JTextField();
		tfTamanho.setColumns(10);
		tfTamanho.setBounds(177, 102, 141, 30);
		jf.getContentPane().add(tfTamanho);

		panel = new JPanel();
		panel.setBounds(38, 236, 424, 236);
		jf.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setAutoscrolls(true);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
						"Nome", "Quantidade", "Pre\u00E7o Unit\u00E1rio"
				}
				));
		table.setBounds(new Rectangle(22, 0, 300, 300));
		scrollPane.setViewportView(table);
		//DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		comboBox = new JComboBox<String>();
		comboBox.setBounds(177, 61, 284, 30);
		jf.getContentPane().add(comboBox);

		listaProdutos = new ArquivoProduto().leProdutosNoArquivo();

		for (Produto prod : listaProdutos)
			comboBox.addItem(String.format("%d - %s", prod.getCodigo(),prod.getNome()));



		JLabel lblListaDeInsumos = new JLabel("Lista de Insumos");
		lblListaDeInsumos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListaDeInsumos.setBounds(191, 181, 141, 19);
		jf.getContentPane().add(lblListaDeInsumos);

		JLabel lblNewLabel_2 = new JLabel("A quantidade de insumo  \u00E9 por tamanho de cada unidade do produto.");
		lblNewLabel_2.setBounds(48, 211, 414, 14);
		jf.getContentPane().add(lblNewLabel_2);
		
		btnPesquisar = new JButton("Pesquisar Produto");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(327, 146, 135, 30);
		jf.getContentPane().add(btnPesquisar);

		jf.setVisible(true);
		
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgInsumo.obtemInsumosProduto(Validacoes.obtemCodigo(
						comboBox.getSelectedItem().toString()), table, jf);
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgInsumo.cadastraInsumo(comboBox, tfTamanho, jf, table);
				for (int i = 0; i < table.getColumnCount(); i++) {
					table.setValueAt("", i, 0);
					table.setValueAt("", i, 1);
					table.setValueAt("", i, 2);
				}
				comboBox.setSelectedIndex(0);
				tfTamanho.setText("");
				tfTamanho.setText("");

			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgProdutos igProdutos = new IgProdutos();
				igProdutos.getJf().setVisible(true);
			}
		});

	}
	
	/**
	 * Obt�m a janela
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
