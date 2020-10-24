package br.com.fabrica.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IgProducao extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfNome;
	private JLabel lblMargemDeLucro;
	private JLabel lblPreoUnitrio;
	private JLabel lblNewLabel_1;
	private JLabel lblNome;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JTextField tfData;
	private JTextField tfQtdProduzida;
	private JTextField tfCusto;
	private JTextField tfValorVenda;

	/**
	 * Create the panel.
	 */
	public IgProducao() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		
		jf.setSize(501, 377);
		
		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(270, 288, 96, 25);
		
		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(379, 288, 83, 25);
		
		lblNome = new JLabel("Nome do Produto:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(38, 67, 122, 16);
		
		lblNewLabel_1 = new JLabel("Data da Produ\u00E7\u00E3o:");
		jf.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(38, 108, 122, 16);
		
		tfNome = new JTextField();
		jf.getContentPane().add(tfNome);
		tfNome.setBounds(177, 61, 285, 30);
		tfNome.setColumns(10);
		
		
		lblNewLabel = new JLabel("Produ\u00E7\u00E3o");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(234, 25, 83, 19);
		
		lblMargemDeLucro = new JLabel("Quantidade produzida:");
		jf.getContentPane().add(lblMargemDeLucro);
		lblMargemDeLucro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMargemDeLucro.setBounds(13, 149, 147, 16);
		
		
		lblPreoUnitrio = new JLabel("Custo da Produ\u00E7\u00E3o:");
		jf.getContentPane().add(lblPreoUnitrio);
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreoUnitrio.setBounds(26, 190, 134, 16);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(177, 102, 141, 30);
		jf.getContentPane().add(tfData);
		
		tfQtdProduzida = new JTextField();
		tfQtdProduzida.setColumns(10);
		tfQtdProduzida.setBounds(177, 143, 140, 30);
		jf.getContentPane().add(tfQtdProduzida);
		
		tfCusto = new JTextField();
		tfCusto.setEditable(false);
		tfCusto.setColumns(10);
		tfCusto.setBounds(177, 184, 140, 30);
		jf.getContentPane().add(tfCusto);
		
		tfValorVenda = new JTextField();
		tfValorVenda.setEditable(false);
		tfValorVenda.setColumns(10);
		tfValorVenda.setBounds(177, 225, 140, 30);
		jf.getContentPane().add(tfValorVenda);
		
		JLabel lblValorTotalDa = new JLabel("Valor total da venda:");
		lblValorTotalDa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorTotalDa.setBounds(26, 232, 141, 16);
		jf.getContentPane().add(lblValorTotalDa);
		
		jf.setVisible(true);
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNome.setText("");
				tfData.setText("");
				tfQtdProduzida.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}
