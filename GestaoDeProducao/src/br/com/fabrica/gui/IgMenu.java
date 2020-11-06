package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Classe responsavel por criar a tela de cadastro de Insumos.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgMenu extends JFrame {
	private JLabel lblNewLabel;
	private JFrame jf;
	private JButton btnInsumos;
	private JButton btnProdutos;
	private JButton btnProducao;
	private JButton btnVenda;
	private JButton btnRelatorioProd;
	private JButton btnRelatorioDeVendas;
	private JButton btnOrcamento;
	private JButton btnCancelar;
	
	/**
	 * Create the panel.
	 */
	public IgMenu() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);

		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		jf.setResizable(false);

		jf.setSize(433, 318);

		jf.setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("F\u00E1brica - Gest\u00E3o de Produ\u00E7\u00E3o");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(101, 23, 227, 19);
		
		btnInsumos = new JButton("Cadastro de Insumos");
		btnInsumos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsumos.setBounds(29, 56, 160, 25);
		jf.getContentPane().add(btnInsumos);
		
		btnProdutos = new JButton("Cadastro de Produtos");
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnProdutos.setBounds(223, 56, 160, 25);
		jf.getContentPane().add(btnProdutos);
		
		btnProducao = new JButton("Cadastro de Produ\u00E7\u00E3o");
		btnProducao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnProducao.setBounds(29, 150, 160, 25);
		jf.getContentPane().add(btnProducao);
		
		btnVenda = new JButton("Cadastro de Vendas");
		btnVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVenda.setBounds(223, 150, 160, 25);
		jf.getContentPane().add(btnVenda);
		
		btnRelatorioProd = new JButton("Relat\u00F3rio de Produ\u00E7\u00E3o");
		btnRelatorioProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRelatorioProd.setBounds(29, 197, 160, 25);
		jf.getContentPane().add(btnRelatorioProd);
		
		btnRelatorioDeVendas = new JButton("Relat\u00F3rio de Vendas");
		btnRelatorioDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRelatorioDeVendas.setBounds(223, 197, 160, 25);
		jf.getContentPane().add(btnRelatorioDeVendas);
		
		btnOrcamento = new JButton("Or\u00E7amento");
		btnOrcamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrcamento.setBounds(29, 233, 160, 25);
		jf.getContentPane().add(btnOrcamento);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(223, 233, 160, 25);
		jf.getContentPane().add(btnCancelar);
		
		JButton btnPrecoInsumo = new JButton("Alterar pre\u00E7o insumo");
		btnPrecoInsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPrecoInsumo.setBounds(29, 103, 160, 25);
		jf.getContentPane().add(btnPrecoInsumo);
		
		JButton btnAlterarPrecoProduto = new JButton("Alterar pre\u00E7o produto");
		btnAlterarPrecoProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterarPrecoProduto.setBounds(223, 105, 160, 25);
		jf.getContentPane().add(btnAlterarPrecoProduto);

		jf.setVisible(true);
		
		btnInsumos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgInsumos igInsumos = new IgInsumos();
				igInsumos.getJf().setVisible(true);
			}
		});
		
		btnProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgProdutos igProdutos = new IgProdutos();
				igProdutos.getJf().setVisible(true);
			}
		});
		
		btnPrecoInsumo.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgAlteraPrecoInsumo igAlteraPreco = new IgAlteraPrecoInsumo();
				igAlteraPreco.getJf().setVisible(true);
			}
		});
		
		btnAlterarPrecoProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgAlteraPrecoVendaProduto igAlteraPreco = new IgAlteraPrecoVendaProduto();
				igAlteraPreco.getJf().setVisible(true);
				
			}
		});
		
		btnProducao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgProducao igProducao = new IgProducao();
				igProducao.getJf().setVisible(true);
			}
		});
		
		btnVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgVendas igVendas = new IgVendas();
				igVendas.getJf().setVisible(true);
			}
		});
		
		btnRelatorioProd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgRelatorioProducao igRelatorioProd = new IgRelatorioProducao();
				igRelatorioProd.getJf().setVisible(true);
			}
		});
		
		btnRelatorioDeVendas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgRelatorioVendas igRelatorioVendas = new IgRelatorioVendas();
				igRelatorioVendas.getJf().setVisible(true);
			}
		});
		
		btnOrcamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgOrcamento igOrcamento = new IgOrcamento();
				igOrcamento.getJf().setVisible(true);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
