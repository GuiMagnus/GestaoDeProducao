package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.ig.GerenciaIgAlteraPrecoProduto;
import br.com.fabrica.modelo.Produto;

/**
 * Classe responsavel por criar a tela de cadastro de Insumos.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgAlteraPrecoVendaProduto extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JComboBox<String> comboBox;
	private List<Produto> listaProdutos;
	public static ArquivoProduto arqProduto = new ArquivoProduto();
	private JTextField tfPreco;
	private JLabel lblNovaMargemDe;
	private JButton btnPreco;
	private JButton btnMargem;
	/**
	 * Create the panel.
	 */
	public IgAlteraPrecoVendaProduto() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);

		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		jf.setResizable(false);

		jf.setSize(545, 326);
		jf.setLocationRelativeTo(null);
		
		jf.setTitle("Alteração de preços do produto");

		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(306, 234, 96, 25);

		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(412, 234, 95, 25);

		lblNome = new JLabel("Nome do Produto:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(49, 66, 122, 19);


		lblNewLabel = new JLabel("Alterar pre\u00E7o de venda");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(165, 11, 184, 19);
		//DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		comboBox = new JComboBox<String>();
		comboBox.setBounds(177, 61, 330, 30);
		jf.getContentPane().add(comboBox);

		listaProdutos = new ArquivoProduto().leProdutosNoArquivo();

		for (Produto prod : listaProdutos)
			comboBox.addItem(String.format("%d - %s", prod.getCodigo(),prod.getNome()));
		
		JLabel lblNovoPreo = new JLabel("Novo Pre\u00E7o:");
		lblNovoPreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovoPreo.setBounds(20, 155, 83, 16);
		jf.getContentPane().add(lblNovoPreo);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(101, 149, 112, 30);
		jf.getContentPane().add(tfPreco);
		tfPreco.setColumns(10);
		
		lblNovaMargemDe = new JLabel("Nova margem de lucro:");
		lblNovaMargemDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovaMargemDe.setBounds(242, 155, 151, 16);
		jf.getContentPane().add(lblNovaMargemDe);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(401, 149, 106, 30);
		jf.getContentPane().add(spinner);
		
		btnPreco = new JButton("Alterar Pre\u00E7o");
		btnPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPreco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPreco.setBounds(61, 111, 122, 25);
		jf.getContentPane().add(btnPreco);
		
		btnMargem = new JButton("Alterar Margem");
		btnMargem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMargem.setBounds(306, 111, 139, 25);
		jf.getContentPane().add(btnMargem);

		jf.setVisible(true);
		
		tfPreco.setEnabled(false);
		spinner.setEnabled(false);
		
		btnPreco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfPreco.setEnabled(true);
				spinner.setEnabled(false);
			}
		});
		
		btnMargem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				spinner.setEnabled(true);
				tfPreco.setEnabled(false);
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgAlteraPrecoProduto.alteraPreco(comboBox, tfPreco, spinner, jf);
				comboBox.setSelectedIndex(0);
				tfPreco.setText("");
				spinner.setValue(0);
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
