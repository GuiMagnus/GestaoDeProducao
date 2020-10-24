package gestao.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IgVendas extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfCodigo;
	private JTable table;
	private JTextField textField_2;
	private JTextField tfData;
	private JTextField tfHora;
	private JLabel lblNome;
	private JLabel lblData;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JComboBox<?> comboProduto;
	private JSpinner spinner;
	private JLabel lblQuantidade;
	private JButton btnAddItens;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JLabel lblValorTotalDa;
	private JButton btnConcluir;
	private JButton btnCancelar;
	private JComboBox<String> comboUnidade;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public IgVendas() {
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(219, 23, 75, 25);
		getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("C\u00F3digo:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(69, 56, 54, 25);
		getContentPane().add(lblNome);
		
		lblNewLabel_1_1 = new JLabel("Tamanho da unidade:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(39, 92, 155, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(133, 59, 54, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Itens da Venda");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(199, 249, 124, 25);
		getContentPane().add(lblNewLabel_1);
		
		btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConcluir.setBounds(259, 538, 89, 23);
		getContentPane().add(btnConcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(362, 538, 89, 23);
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 276, 423, 217);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(40, 158, 411, 256);
		scrollPane.setViewportView(table);
		
		lblValorTotalDa = new JLabel("Valor total da venda:");
		lblValorTotalDa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorTotalDa.setBounds(40, 504, 154, 25);
		getContentPane().add(lblValorTotalDa);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(187, 507, 264, 20);
		getContentPane().add(textField_2);
		
		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(197, 56, 44, 25);
		getContentPane().add(lblData);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(248, 59, 75, 20);
		getContentPane().add(tfData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(334, 56, 44, 25);
		getContentPane().add(lblHora);
		
		tfHora = new JTextField();
		tfHora.setColumns(10);
		tfHora.setBounds(388, 59, 75, 20);
		getContentPane().add(tfHora);
		
		lblNewLabel_1_2 = new JLabel("Produto");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(212, 122, 124, 25);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblPro = new JLabel("Produto:");
		lblPro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPro.setBounds(40, 148, 62, 25);
		getContentPane().add(lblPro);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(281, 183, 97, 25);
		getContentPane().add(lblQuantidade);
		
		spinner = new JSpinner();
		spinner.setBounds(391, 184, 72, 20);
		getContentPane().add(spinner);
		
		btnAddItens = new JButton("Adicionar Itens da Venda");
		btnAddItens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddItens.setBounds(281, 215, 182, 23);
		getContentPane().add(btnAddItens);
		
		comboProduto = new JComboBox();
		comboProduto.setBounds(106, 149, 356, 22);
		getContentPane().add(comboProduto);
		
		comboUnidade = new JComboBox<String>();
		comboUnidade.setBounds(187, 94, 136, 22);
		getContentPane().add(comboUnidade);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
