package gestao.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fabrica.modelo.UnidadeMedida;

@SuppressWarnings("serial")
public class IgInsumos extends JFrame{
	private JLabel lblNewLabel;
	private JTextField tfNome;
	private JTable table;
	private JLabel lblNome;
	private JLabel lblNewLabel_1_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JFrame jf;
	private JComboBox<String> comboBox;

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
		lblNewLabel_1_1.setBounds(21, 121, 138, 16);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(158, 71, 298, 20);
		jf.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Insumos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(204, 168, 83, 19);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGravar.setBounds(297, 587, 83, 25);
		jf.getContentPane().add(btnGravar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(390, 587, 83, 25);
		jf.getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 198, 452, 365);
		jf.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(40, 158, 411, 256);
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(165, 119, 138, 22);
		jf.getContentPane().add(comboBox);
		
		
		for(UnidadeMedida um : UnidadeMedida.values()) {
			comboBox.addItem(String.format("%s (%s)", um.getNome(),
					um.getUnidade() ));
		}
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
