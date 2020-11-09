package br.com.fabrica.gerencia.ig;


import static br.com.fabrica.constantes.Constantes.ERR_DATA_HORA_INVALIDA;
import static br.com.fabrica.constantes.Constantes.EXP_DATA;
import static br.com.fabrica.constantes.Constantes.EXP_HORA;
import static br.com.fabrica.constantes.Constantes.RELATORIO_VENDA;
import static br.com.fabrica.gui.EntradaESaida.msgErro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.arquivos.ArquivoVendaProduto;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;
import br.com.fabrica.validacoes.Validacoes;

/**
 * 
 * @author Guilherme Magnus e Rafaela.
 *
 */
public class GerenciaIgRelatorioVenda {
	
	/**
	 * Obtém os dados das vendas realizadas de um determinado período,
	 *  as ordena tanto em hora quanto em data e exibe em uma tabela.
	 * @param tfDataHoraInicial período Inicial.
	 * @param tfDataHoraFinal período Final.
	 * @param tfValorTotalVenda Valor total de todas as vendas.
	 * @param defaultTableModel tabela onde serão exibidos os dados.
	 * @param colunas número de colunas da tabela.
	 */
	public static void relatorioVendas(JTextField tfDataHoraInicial, JTextField tfDataHoraFinal, JTextField tfValorTotalVenda,
			DefaultTableModel defaultTableModel,String[] colunas) {

		if(Validacoes.obtemExpressoes(tfDataHoraInicial.getText(),EXP_DATA) != "" || 
				Validacoes.obtemExpressoes(tfDataHoraFinal.getText(), EXP_DATA) != "") {
			
			List<Venda> vendasRealizadas = new ArquivoVenda().obtemVendas(tfDataHoraInicial.getText(), tfDataHoraFinal.getText());
			if(vendasRealizadas.size() != 0) {
				
				List<Produto> produtosVendidos = new ArquivoVendaProduto().produtosVendidos(vendasRealizadas);
				insereDadosTabela(produtosVendidos, defaultTableModel);
				
				insereValorTotalVenda(vendasRealizadas, tfValorTotalVenda);
				
			}
			
		}
		else
			if(Validacoes.obtemExpressoes(tfDataHoraInicial.getText(),EXP_HORA) != "" ||
			Validacoes.obtemExpressoes(tfDataHoraFinal.getText(), EXP_HORA) != "") {
				List<Venda> vendasRealizadasHora = new ArquivoVenda().obtemVendasHora(tfDataHoraInicial.getText(), tfDataHoraFinal.getText());
				if(vendasRealizadasHora.size() != 0) {
					
					List<Produto> produtosVendidos = new ArquivoVendaProduto().produtosVendidos(vendasRealizadasHora);
					insereDadosTabela(produtosVendidos, defaultTableModel);
					
					insereValorTotalVenda(vendasRealizadasHora, tfValorTotalVenda);
					
				}
			}
			else
				msgErro(null, ERR_DATA_HORA_INVALIDA, RELATORIO_VENDA);
	}

	/**
	 * Obtém os dados das vendas armazenados em uma tabela, organiza-os pelo período de data 
	 * informado no parâmetro
	 * @param defaultTableModel tabela de onde os dados serão obtidos
	 * @param dataVendaInicial período inicial.
	 * @param dataVendaFinal período final.
	 */
	public static void ordenacaoData(DefaultTableModel defaultTableModel,String dataVendaInicial,String dataVendaFinal) {
		List<Produto> produtosVendidos = obtemDadosTabela(defaultTableModel);
		List<Venda> vendas = new ArrayList<Venda>();
		
		if(Validacoes.obtemExpressoes(dataVendaInicial, EXP_DATA) != "")
			vendas = new ArquivoVenda().obtemVendas(dataVendaInicial, dataVendaFinal);
		else
			vendas = new ArquivoVenda().obtemVendasHora(dataVendaInicial, dataVendaFinal);

		vendas.sort(new Comparator<Venda>() {
			@Override
			public int compare(Venda venda1, Venda venda2) {
				return venda1.getData().compareTo(venda2.getData());
			}
		});

		
		List<Produto> produtosOrdenados = organizaProdutosVendidos(vendas, produtosVendidos);
		insereDadosTabela(produtosOrdenados, defaultTableModel);
	}
	/**
	 * Obtém os dados das vendas armazenados em uma tabela, organiza-os pelo período de hora 
	 * informado no parâmetro
	 * @param defaultTableModel tabela de onde os dados serão obtidos
	 * @param dataHoraInicial período inicial.
	 * @param dataHoraFinal período final.
	 */
	public static void ordenacaoHora(DefaultTableModel defaultTableModel, String dataHoraInicial,
			String dataHoraFinal) {
		List<Produto> produtosVendidos = obtemDadosTabela(defaultTableModel);
		List<Venda> vendas = new ArrayList<Venda>();
		
		if(Validacoes.obtemExpressoes(dataHoraInicial, EXP_DATA) == "")
			 vendas = new ArquivoVenda().obtemVendasHora(dataHoraInicial, dataHoraFinal);
		else
			vendas = new ArquivoVenda().obtemVendas(dataHoraInicial, dataHoraFinal);
		
		Collections.sort(vendas,new Comparator<Venda>() {
			@Override
			public int compare(Venda venda1, Venda venda2) {
				return venda1.getHora().compareTo(venda2.getHora());
			}
		});
		
		List<Produto> produtosOrdenados = organizaProdutosVendidos(vendas, produtosVendidos);
		
		insereDadosTabela(produtosOrdenados, defaultTableModel);
	}
	
	/**
	 * Obtém os dados de uma tabela e os armazenad em uma lista do tipo Produto.
	 * @param defaultTableModel tabela de onde os dados serão obtidos.
	 * @return uma lista contendo os dados da tabela dos produtos vendidos.
	 */
	public static List<Produto> obtemDadosTabela(DefaultTableModel defaultTableModel) {
		List<Produto> produtosVendidos = new ArrayList<Produto>();
		for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
			Produto produto = new Produto();
			produto.setCodigo((int)defaultTableModel.getValueAt(i, 0));
			produto.setNome(String.format("%s",defaultTableModel.getValueAt(i, 1)));
			produto.setQuantidade((int)defaultTableModel.getValueAt(i, 2));
			produto.setPrecoFabricacao(Validacoes.transformaEmFloat(String.format("%s",defaultTableModel.getValueAt(i, 3))));
			produto.setPrecoVenda(Validacoes.transformaEmFloat(String.format("%s",defaultTableModel.getValueAt(i, 4))));
			produtosVendidos.add(produto);
		}
		return produtosVendidos;
	}
	
	/**
	 * Obtém os dados de uma lista referente aos produtos vendidos e os joga na tabela.
	 * @param produtosList lista de produtos vendidos.
	 * @param defaultTableModel tabela onde os dados serão armazenados e exibidos
	 */
	public static void insereDadosTabela(List<Produto> produtosList, DefaultTableModel defaultTableModel) {
		defaultTableModel.setNumRows(0);
		for (int i = 0; i < produtosList.size(); i++) {
			Produto produtos = produtosList.get(i);
			defaultTableModel.insertRow(defaultTableModel.getRowCount(),
					new Object[] {produtos.getCodigo(),produtos.getNome(),
							produtos.getQuantidade(),produtos.getPrecoFabricacao(),
							produtos.getPrecoVenda()});

		}
	}
	
	/**
	 * Organiza os produtos obtidos e o coloca em ordem de data ou hora, a ser definida pelos botões da 
	 * interface
	 * @param vendas lista de vendas realizadas
	 * @param produtosVendidos produtos vendidos.
	 * @return uma lista com os produtos das vendas ordenados
	 */
	public static List<Produto> organizaProdutosVendidos(List<Venda>vendas,List<Produto> produtosVendidos){
		List<Produto> produtosOrdenados = new ArrayList<Produto>();
		for (int i = 0; i < vendas.size(); i++) {
			for (int j = 0; j < produtosVendidos.size(); j++) {
				if(vendas.get(i).getCodigo()==produtosVendidos.get(j).getCodigo())
					produtosOrdenados.add(produtosVendidos.get(j));
			}
		}
		return produtosOrdenados;
	}
	
	/**
	 * Insere no textField o valor total das vendas.
	 * @param vendasRealizadas lista de vendas realizadas.
	 * @param tfValorTotalVenda campo onde será exibido o valor total das vendas
	 */
	public static void insereValorTotalVenda(List<Venda> vendasRealizadas,JTextField tfValorTotalVenda) {

		float valorTotal = 0;
		for (int i = 0; i < vendasRealizadas.size(); i++) {
			valorTotal += vendasRealizadas.get(i).getValorTotalVenda();
		}
		tfValorTotalVenda.setText(String.format("%.2f",valorTotal));
		
	}
}
