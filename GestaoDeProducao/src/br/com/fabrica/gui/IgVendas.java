package br.com.fabrica.gui;

import static br.com.fabrica.constantes.Constantes.ERR_QTDE_MAXIMA;
import static br.com.fabrica.constantes.Constantes.VENDA;
import static br.com.fabrica.gui.EntradaESaida.msgErro;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.gerencia.ig.GerenciaIgVenda;
import br.com.fabrica.gerencia.modelo.GerenciaProducao;
import br.com.fabrica.modelo.Producao;
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
	private JTextField tfVenda;
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
	private int qtdeMaximaProduzida = 0;
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

		tfVenda = new JTextField();
		tfVenda.setEditable(false);
		tfVenda.setColumns(10);
		tfVenda.setBounds(187, 507, 264, 20);
		jf.getContentPane().add(tfVenda);

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
		spinner.setBounds(391, 184, 72, 20);

		jf.getContentPane().add(spinner);
		btnAddItens = new JButton("Adicionar Itens da Venda");


		btnAddItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Produto prod = new Produto();
				prod.setNome(Validacoes.obtemNome(String.format("%s",comboProduto.getSelectedItem())));
				Producao producao = new Producao();
				
				prod = new ArquivoProduto().obtemProduto(Validacoes.obtemCodigo(String.format("%s",comboProduto.getSelectedItem())));
			
				producao.setProduto(prod);
				
				float precoUnitario = new GerenciaProducao().calculaVendaProduto(prod, (int) spinner.getValue());
				int verificacaoVendaRepetida = verificaItensTabela(prod);
				if(verificacaoVendaRepetida == -1)
					defaultTableModel.insertRow(defaultTableModel.getRowCount(), new Object[] {
							prod.getNome(),(int)spinner.getValue(),precoUnitario,precoUnitario * (int)spinner.getValue() });
				else {
					if((int)spinner.getValue() + (int)defaultTableModel.getValueAt(verificacaoVendaRepetida, 1) > qtdeMaximaProduzida){
						msgErro(null, ERR_QTDE_MAXIMA, VENDA);
					}
					else {
						float novoPrecoUnitario = new GerenciaProducao().calculaVendaProduto(prod, (int) spinner.getValue()+(int)defaultTableModel.getValueAt(verificacaoVendaRepetida, 1));
						defaultTableModel.insertRow(verificacaoVendaRepetida, new Object[] {
								prod.getNome(),producao.getProduto().getQuantidade()+ (int) spinner.getValue(),novoPrecoUnitario,novoPrecoUnitario * (int)spinner.getValue() });
					}
				}
				float valorVenda = valorTotalVenda(prod);
				tfVenda.setText(valorVenda + "");
				
			}

			public int verificaItensTabela(Produto prod) {
				for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
					if(defaultTableModel.getValueAt(i, 0).toString().equalsIgnoreCase(prod.getNome())) {
						return i;
					}
				}
				return -1;
			}

		});
		btnAddItens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddItens.setBounds(281, 215, 182, 23);
		jf.getContentPane().add(btnAddItens);

		comboProduto = new JComboBox<String>();
		comboProduto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Producao producao = new ArquivoProducao().obterProducao(Validacoes.obtemCodigo(String.format("%s",comboProduto.getSelectedItem())));
				
				SpinnerNumberModel model = new SpinnerNumberModel(0, 0, producao.getProduto().getQuantidade(), 1);
				spinner.setModel(model);
				qtdeMaximaProduzida = producao.getProduto().getQuantidade();
			}
		});

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
		defaultTableModel = new DefaultTableModel(colunas, 0);
		table.setModel(defaultTableModel);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);

		// Define a posição, o tamanho e exibe a janela.
		setBounds(100, 100, 428, 314);
		setVisible(true);
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
		
		btnConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GerenciaIgVenda.registraVenda(jf, defaultTableModel, tfData, tfHora, tfVenda);
				defaultTableModel.setNumRows(1);
				defaultTableModel.setValueAt("", 0, 0);
				defaultTableModel.setValueAt("", 0, 1);
				defaultTableModel.setValueAt("", 0, 2);
				defaultTableModel.setValueAt("", 0, 3);
				comboProduto.setSelectedIndex(0);
				tfVenda.setText("");
				tfData.setText(Data.obtemDataAtual());
				tfHora.setText(Validacoes.obtemHoraAtual());
				spinner.setValue(0);
				
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
	
	public float valorTotalVenda(Produto prod) {
		float valor = 0;
		for (int i = 0; i < defaultTableModel.getRowCount(); i++) 
			valor += Validacoes.transformaEmFloat(defaultTableModel.getValueAt(i, 3).toString());
		return valor;
	}


}
