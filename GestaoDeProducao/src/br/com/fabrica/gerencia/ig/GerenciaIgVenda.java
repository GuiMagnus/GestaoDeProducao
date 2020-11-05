package br.com.fabrica.gerencia.ig;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.arquivos.ArquivoVendaProduto;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;

public class GerenciaIgVenda {
	private static ArquivoVenda arquivoVenda = new ArquivoVenda();
	private static ArquivoVendaProduto arquivoVendaProduto = new ArquivoVendaProduto();
	/**
	 *
	 * 
	 */
	public static void registraVenda(DefaultTableModel dtm, JTextField data, JTextField hora, float valorTotalItens) {
		Venda venda = new Venda();
		venda.setCodigo(arquivoVenda.obtemCodigoVenda());
		venda.setData(data.getText());
		venda.setHora(hora.getText());
		venda.setValorTotalVenda(valorTotalItens);
		List<Produto> produtos = new ArrayList<Produto>();
		for (int i = 0; i < dtm.getRowCount(); i++) {
			Produto produto = new Produto();
			produto.setNome(String.format("%s",dtm.getValueAt(i, 0)));
			produto.setQuantidadeProduto(Integer.parseInt(String.format("%s",dtm.getValueAt(i, 1))));
			produto.setPrecoFabricacao(Float.parseFloat(String.format("%s",dtm.getValueAt(i, 2))));
			produto.setPrecoVenda(Float.parseFloat(String.format("%s",dtm.getValueAt(i, 3))));
			produtos.add(produto);
			
		}
	}
}
