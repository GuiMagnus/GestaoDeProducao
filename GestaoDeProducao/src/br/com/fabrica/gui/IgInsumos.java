package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fabrica.gerencia.CadastroDeInformacoes;
//import net.miginfocom.swing.MigLayout;
//import net.miginfocom.swing.MigLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class IgInsumos extends JFrame{
	private JLabel lblNewLabel;
	private JTextField tfNome;
	private JLabel lblNome;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JTextField tfTamanhoUnidade;
	private JPanel contentPanel;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public IgInsumos() {
		setTitle("Cadastrar Insumos");
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		jf.setSize(525, 675);
		jf.setVisible(true);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Insumo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(204, 27, 59, 19);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(108, 72, 40, 16);
		jf.getContentPane().add(lblNome);
		
		lblNewLabel_1_1 = new JLabel("Tamanho da unidade:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(21, 112, 138, 16);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(158, 71, 298, 20);
		jf.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Insumos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(204, 153, 83, 19);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(297, 587, 83, 25);
		jf.getContentPane().add(btnGravar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(390, 587, 83, 25);
		jf.getContentPane().add(btnCancelar);
		
		tfTamanhoUnidade = new JTextField();
		tfTamanhoUnidade.setColumns(10);
		tfTamanhoUnidade.setBounds(158, 111, 151, 20);
		jf.getContentPane().add(tfTamanhoUnidade);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBounds(21, 183, 435, 357);
		jf.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 28, 425, 314);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPanel.setBorder(new TitledBorder(null, "Tabela de Insumos", TitledBorder.LEADING, 
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), null));
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		btnGravar.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDeInformacoes.cadastraInsumo(tfNome, tfTamanhoUnidade, jf);
				tfNome.setText("");
				tfTamanhoUnidade.setText("");
				//CadastroInformacoes.povoaTabela(table);
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

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}	
}
