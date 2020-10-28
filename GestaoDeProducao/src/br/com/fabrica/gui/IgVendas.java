package br.com.fabrica.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Data;
import br.com.fabrica.validacoes.Validacoes;


/**
 * Classe responsavel por criar a tela de cadastro de Venda.
 * @author Rafaela
 *
 */
@SuppressWarnings("serial")
public class IgVendas extends JFrame {
	private JLabel lblNewLabel;
	private JTextField tfCodigo;
	private JTextField textField_2;
	private JTextField tfData;
	private JTextField tfHora;
	private JLabel lblNome;
	private JLabel lblData;
	private JLabel lblNewLabel_1_2;
	private JComboBox<String> comboProduto;
	private JSpinner spinner;
	private JLabel lblQuantidade;
	private JButton btnAddItens;
	private JLabel lblNewLabel_1;
	private JLabel lblValorTotalDa;
	private JButton btnConcluir;
	private JButton btnCancelar;
	private JFrame jf;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private List<Produto> listaProdutos;
	/**
	 * Create the panel.
	 */
	public IgVendas() {
		getContentPane().setLayout(null);
		
		jf = new JFrame();
		jf.setAutoRequestFocus(false);
		jf.getContentPane().setLayout(null);
		
		// Define que o programa deve ser finalizado quando o usuário clicar no botão Fechar da janela.
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define a janela como não redimensionável.
		//jf.setResizable(false);
		jf.setSize(510, 632);
		
		
		lblNewLabel = new JLabel("Venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(219, 23, 75, 25);
		jf.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("C\u00F3digo:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(69, 56, 54, 25);
		jf.getContentPane().add(lblNome);
		
		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setBounds(133, 59, 54, 20);
		jf.getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		tfCodigo.setText(String.format("%d",new ArquivoVenda().obtemCodigoVenda()));
		lblNewLabel_1 = new JLabel("Itens da Venda");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(199, 249, 124, 25);
		jf.getContentPane().add(lblNewLabel_1);
		
		btnConcluir = new JButton("Concluir");
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConcluir.setBounds(259, 538, 89, 23);
		jf.getContentPane().add(btnConcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(362, 538, 89, 23);
		jf.getContentPane().add(btnCancelar);
		
		lblValorTotalDa = new JLabel("Valor total da venda:");
		lblValorTotalDa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorTotalDa.setBounds(40, 504, 154, 25);
		jf.getContentPane().add(lblValorTotalDa);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(187, 507, 264, 20);
		jf.getContentPane().add(textField_2);
		
		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(197, 56, 44, 25);
		jf.getContentPane().add(lblData);
		
		tfData = new JTextField();
		tfData.setEditable(false);
		tfData.setColumns(10);
		tfData.setBounds(248, 59, 75, 20);
		tfData.setText(Data.obtemDataAtual());
		jf.getContentPane().add(tfData);
		
		
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(334, 56, 44, 25);
		jf.getContentPane().add(lblHora);
		
		tfHora = new JTextField();
		tfHora.setEditable(false);
		tfHora.setColumns(10);
		tfHora.setBounds(388, 59, 75, 20);
		tfHora.setText(Validacoes.obtemHoraAtual());
		jf.getContentPane().add(tfHora);
		
		lblNewLabel_1_2 = new JLabel("Produto");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(199, 102, 124, 25);
		jf.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblPro = new JLabel("Produto:");
		lblPro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPro.setBounds(40, 148, 62, 25);
		jf.getContentPane().add(lblPro);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(281, 183, 97, 25);
		jf.getContentPane().add(lblQuantidade);
		
		spinner = new JSpinner();
		/**
		 * Evento para estabelecer um valor teto para o spinner referente a quantidade do produto. 
		 */
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
			}
		});
		spinner.setBounds(391, 184, 72, 20);
		
		jf.getContentPane().add(spinner);
		btnAddItens = new JButton("Adicionar Itens da Venda");
		
		
		btnAddItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto prod = new Produto();
				prod.setNome(Validacoes.obtemNome(String.format("%s",comboProduto.getSelectedItem())));
				prod = verificaProdutosArquivo(prod,listaProdutos);
				if(table.getRowCount() > 0) {
					int i = verificaTabela(table,prod);
					if(i != -1) {
						defaultTableModel.setValueAt((int)defaultTableModel.getValueAt(i, 1)+(int)spinner.getValue(), i, 1);
						
					}
					else
						defaultTableModel.insertRow(defaultTableModel.getRowCount(), new Object[] {prod.getNome(), prod.getQuantidadeProduto()+(int)spinner.getValue(),prod.getPrecoFabricacao()});
				}
				else
					defaultTableModel.insertRow(defaultTableModel.getRowCount(), new Object[] {prod.getNome(), prod.getQuantidadeProduto(),prod.getPrecoFabricacao()});
				
				
				spinner.setValue(0);
			}

			public Produto verificaProdutosArquivo(Produto produtoPesquisa, List<Produto> listaProdutos) {
				for (Produto produtoArquivo : listaProdutos) {
					if(produtoArquivo.getNome().equalsIgnoreCase(produtoPesquisa.getNome())) {
						return produtoArquivo;
					}
				}
				return null;
			}

			public int verificaTabela(JTable table, Produto prod) {
				for (int i = 0; i < table.getRowCount(); i++) 
					if(prod.getNome().equalsIgnoreCase((String) table.getValueAt(i, 0))) {
						System.out.println("Igual");
						return i;
					}
				return -1;
			}
		});
		btnAddItens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddItens.setBounds(281, 215, 182, 23);
		jf.getContentPane().add(btnAddItens);
		
		comboProduto = new JComboBox<String>();
		comboProduto.setBounds(106, 149, 356, 22);
		listaProdutos =  new ArquivoProduto().leProdutosNoArquivo();

		for (Produto produtos : listaProdutos)
			comboProduto.addItem(String.format("%d - %s", produtos.getCodigo(),produtos.getNome()));

		jf.getContentPane().add(comboProduto);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 273, 431, 220);
		jf.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		// Adiciona a tabela na área de visualização do painel rolável para que uma barra de rolagem vertical seja exibida automaticamente quando o número de linhas ultrapassar a área visível da tabela.  
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		
		String[] colunas = new String[] {"Nome", "Quantidade","Preço Unitário","Valor Total"};
		table = new JTable();
		//table.setBorder(new TitledBorder(null, "Vendas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//panel.add(table, BorderLayout.SOUTH);
		defaultTableModel = new DefaultTableModel(colunas, 0);
		table.setModel(defaultTableModel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);

		// Define a posição, o tamanho e exibe a janela.
		setBounds(100, 100, 428, 314);
		setVisible(true);
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Quantidade", "Pre\u00E7o Unit\u00E1rio", "Valor total"
			}
		));*/
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				IgMenu igMenu = new IgMenu();
				igMenu.getJf().setVisible(true);
			}
		});
		
		jf.setVisible(true);
	}
	
	
	public JFrame getJf() {
		return jf;
	}
	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	
	
}
