package br.com.fabrica.gui;

import static br.com.fabrica.constantes.Constantes.VALOR_DEFAULT_CB_ORCAMENTO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.fabrica.gerencia.ig.GerenciaIgOrcamento;
import br.com.fabrica.modelo.MesesAno;

/**
 * Classe responsavel por criar a tela de Orçamento.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgOrcamento extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfValor;
	private JTextField tfValorTotal;
	private JTextField tfNumero;
	private JTextField tfSaldo;
	private JLabel lblNome;
	private JComboBox<String> comboBox;
	private JLabel lblOramento;
	private JLabel lblNewLabel_1;
	private JLabel lblPreoUnitrio;
	private JLabel lblMargemDeLucro;
	private JLabel lblSaldo;
	private JLabel lblSaldo_1;
	private JButton btnCancelar;
	private JFrame jf;

	/**
	 * Create the panel.
	 */
	public IgOrcamento() {
		jf = new JFrame();
		
		jf.setTitle("Orçamento");
		
		lblNewLabel = new JLabel("Per\u00EDodo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(179, 23, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("M\u00EAs:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(30, 57, 47, 25);
		jf.getContentPane().add(lblNome);
		
		lblNewLabel_1 = new JLabel("Valor total dos insumos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 132, 161, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		tfValor = new JTextField();
		tfValor.setDisabledTextColor(java.awt.Color.BLACK);
		tfValor.setEnabled(false);
		tfValor.setBounds(201, 135, 161, 20);
		jf.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setDisabledTextColor(java.awt.Color.BLACK);
		tfValorTotal.setEnabled(false);
		tfValorTotal.setBounds(201, 211, 161, 20);
		jf.getContentPane().add(tfValorTotal);
		tfValorTotal.setColumns(10);
		
		btnCancelar = new JButton("OK");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(273, 369, 89, 23);
		jf.getContentPane().add(btnCancelar);
		
		
		lblPreoUnitrio = new JLabel("N\u00FAmero total de vendas");
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreoUnitrio.setBounds(30, 169, 161, 25);
		jf.getContentPane().add(lblPreoUnitrio);
		
		lblMargemDeLucro = new JLabel("Valor total das vendas");
		lblMargemDeLucro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMargemDeLucro.setBounds(30, 208, 161, 25);
		jf.getContentPane().add(lblMargemDeLucro);
		
		tfNumero = new JTextField();
		tfNumero.setDisabledTextColor(java.awt.Color.BLACK);
		tfNumero.setEnabled(false);
		tfNumero.setColumns(10);
		tfNumero.setBounds(201, 172, 161, 20);
		jf.getContentPane().add(tfNumero);
		
		//.setDisabledTextColor(Color.RED);
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				GerenciaIgOrcamento.obtemOrcamento(comboBox, tfValor, tfNumero,
						tfValorTotal, tfSaldo);
			}
		});
		comboBox.setBounds(74, 59, 161, 22);
		jf.getContentPane().add(comboBox);
		comboBox.addItem(VALOR_DEFAULT_CB_ORCAMENTO);
		for(MesesAno mesesAno : MesesAno.values()) {
			comboBox.addItem(String.format("%s", mesesAno.getMes()));
		}
		
		
		lblOramento = new JLabel("Or\u00E7amento");
		lblOramento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOramento.setBounds(165, 96, 89, 25);
		jf.getContentPane().add(lblOramento);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSaldo.setBounds(177, 257, 89, 25);
		jf.getContentPane().add(lblSaldo);
		
		lblSaldo_1 = new JLabel("Saldo");
		lblSaldo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSaldo_1.setBounds(30, 299, 47, 25);
		jf.getContentPane().add(lblSaldo_1);
		
		tfSaldo = new JTextField();
		tfSaldo.setDisabledTextColor(java.awt.Color.BLACK);
		tfSaldo.setEnabled(false);
		tfSaldo.setColumns(10);
		tfSaldo.setBounds(74, 302, 161, 20);
		jf.getContentPane().add(tfSaldo);
		
		
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		jf.setResizable(false);
		
		jf.setSize(415, 473);
		jf.setLocationRelativeTo(null);
		
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
