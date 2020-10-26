package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Produto;

/**
 * Classe responsavel por criar a tela de cadastro de Insumos.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgAlteraPrecoInsumo extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JComboBox<String> comboBox;
	private List<Produto> listaProdutos;
	public static ArquivoProduto arqProduto = new ArquivoProduto();
	private JButton btnPesquisar;
	private JComboBox<String> comboInsumo;
	private JTextField tfPreco;
	/**
	 * Create the panel.
	 */
	public IgAlteraPrecoInsumo() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);

		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);

		jf.setSize(501, 373);

		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(260, 291, 96, 25);

		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(378, 291, 83, 25);

		lblNome = new JLabel("Nome do Produto:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(49, 66, 122, 19);


		lblNewLabel = new JLabel("Insumo");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(202, 11, 83, 19);
		//DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		comboBox = new JComboBox<String>();
		comboBox.setBounds(177, 61, 284, 30);
		jf.getContentPane().add(comboBox);

		listaProdutos = new ArquivoProduto().leProdutosNoArquivo();

		for (Produto prod : listaProdutos)
			comboBox.addItem(String.format("%d - %s", prod.getCodigo(),prod.getNome()));
		
		btnPesquisar = new JButton("Pesquisar Produto");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(326, 102, 135, 30);
		jf.getContentPane().add(btnPesquisar);
		
		JLabel lblNomeDoInsumo = new JLabel("Nome do Insumo:");
		lblNomeDoInsumo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeDoInsumo.setBounds(49, 156, 111, 16);
		jf.getContentPane().add(lblNomeDoInsumo);
		
		comboInsumo = new JComboBox<String>();
		comboInsumo.setBounds(177, 150, 284, 30);
		jf.getContentPane().add(comboInsumo);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar Produto");
		btnPesquisar_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar_1.setBounds(326, 191, 135, 30);
		jf.getContentPane().add(btnPesquisar_1);
		
		JLabel lblNovoPreo = new JLabel("Novo Pre\u00E7o:");
		lblNovoPreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovoPreo.setBounds(77, 240, 83, 16);
		jf.getContentPane().add(lblNovoPreo);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(177, 237, 151, 30);
		jf.getContentPane().add(tfPreco);
		tfPreco.setColumns(10);

		jf.setVisible(true);
		
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
