package br.com.fabrica.gui;

import static br.com.fabrica.constantes.Constantes.VALOR_DEFAULT_COMBOBOX;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.ig.GerenciaIgAlteraPrecoInsumo;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsavel por criar a tela de cadastro de Insumos.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgAlteraPrecoInsumo extends JFrame {
	private JLabel lblNewLabel;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private List<Insumo> listaInsumos;
	public static ArquivoProduto arqProduto = new ArquivoProduto();
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
		jf.setResizable(false);

		jf.setSize(501, 279);
		jf.setLocationRelativeTo(null);
		
		jf.setTitle("Alteração de preços de insumos");

		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(252, 190, 96, 25);

		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(358, 190, 103, 25);


		lblNewLabel = new JLabel("Insumo");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(212, 11, 83, 19);

		listaInsumos = new ArquivoInsumo().leInsumosNoArquivo();
		comboInsumo = new JComboBox<String>();
		comboInsumo.addItem(VALOR_DEFAULT_COMBOBOX);
		
		for(Insumo insumo : listaInsumos) {
			comboInsumo.addItem(String.format("%d - %s", insumo.getCodigo(),insumo.getNome()));
		}
		comboInsumo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Insumo insumo = new ArquivoInsumo().obtemInsumo(Validacoes.obtemCodigo(String.format("%s",comboInsumo.getSelectedItem())));
				if(insumo != null)
					tfPreco.setText("" + insumo.getPrecoUnitario());
			}
		});

		comboInsumo.setBounds(177, 54, 284, 30);
		jf.getContentPane().add(comboInsumo);
		
		JLabel lblNomeDoInsumo = new JLabel("Nome do Insumo:");
		lblNomeDoInsumo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeDoInsumo.setBounds(49, 60, 111, 16);
		jf.getContentPane().add(lblNomeDoInsumo);
		
		
		
		JLabel lblNovoPreo = new JLabel("Novo Pre\u00E7o:");
		lblNovoPreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovoPreo.setBounds(81, 130, 83, 16);
		jf.getContentPane().add(lblNovoPreo);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(179, 124, 151, 30);
		jf.getContentPane().add(tfPreco);
		tfPreco.setColumns(10);

		jf.setVisible(true);
		
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgAlteraPrecoInsumo.alteraPreco(comboInsumo, tfPreco, jf);
				comboInsumo.setSelectedIndex(0);
				tfPreco.setText("");
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
