package gestao.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.modelo.UnidadeMedida;
import br.com.fabrica.validacoes.CadastroDeInformacoes;

@SuppressWarnings("serial")
public class IgProdutos extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfNome;
	private JTextField tfpreco;
	private JSpinner spinner;
	private JLabel lblMargemDeLucro;
	private JLabel lblPreoUnitrio;
	private JLabel lblNewLabel_1;
	private JLabel lblNome;
	private JButton btnNewButton_2;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public IgProdutos() {
		getContentPane().setLayout(null);
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		
		jf.setSize(525, 473);
		
		btnGravar = new JButton("Gravar");
		jf.getContentPane().add(btnGravar);
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(273, 307, 96, 25);
		
		btnNewButton_2 = new JButton("Cadastrar Insumo...");
		jf.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(298, 255, 164, 25);
		
		btnCancelar = new JButton("Cancelar");
		jf.getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(379, 307, 83, 25);
		
		lblNome = new JLabel("Nome:");
		jf.getContentPane().add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(120, 67, 40, 16);
		
		lblNewLabel_1 = new JLabel("Unidade:");
		jf.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(104, 113, 56, 16);
		
		tfNome = new JTextField();
		jf.getContentPane().add(tfNome);
		tfNome.setBounds(177, 61, 285, 30);
		tfNome.setColumns(10);
		
		
		lblNewLabel = new JLabel("Produto");
		jf.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(234, 25, 59, 19);
		
		lblMargemDeLucro = new JLabel("Margem de lucro:");
		jf.getContentPane().add(lblMargemDeLucro);
		lblMargemDeLucro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMargemDeLucro.setBounds(47, 161, 113, 16);
		
		
		lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		jf.getContentPane().add(lblPreoUnitrio);
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreoUnitrio.setBounds(64, 217, 96, 16);
		
		spinner = new JSpinner();
		jf.getContentPane().add(spinner);
		spinner.setBounds(174, 155, 101, 30);
		
		tfpreco = new JTextField();
		tfpreco.setEditable(false);
		jf.getContentPane().add(tfpreco);
		tfpreco.setColumns(10);
		tfpreco.setBounds(177, 211, 96, 30);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(176, 107, 145, 30);
		jf.getContentPane().add(comboBox);
		
		for(UnidadeMedida um : UnidadeMedida.values()) {
			comboBox.addItem(String.format("%s (%s)", um.getNome(),
					um.getUnidade() ));
		}
		
		jf.setVisible(true);
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDeInformacoes.cadastrarProdutos(tfNome, comboBox, spinner);
				tfNome.setText("");
				comboBox.setSelectedIndex(0);
				spinner.setValue(Integer.valueOf(0));
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
