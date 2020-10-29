package br.com.fabrica.gerencia.ig;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.gerencia.modelo.GerenciaOrcamento;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;

public class GerenciaIgOrcamento {
	private static ArquivoProduto arquivoProduto = new ArquivoProduto();
	private static ArquivoVenda arquivoVenda = new ArquivoVenda();
	
	public static void obtemOrcamento(JComboBox<String> comboBox, JTextField tfValor, JTextField
					tfNumero, JTextField tfValorTotal, JTextField tfSaldo) {
		GerenciaOrcamento go = new GerenciaOrcamento();
		List<Produto> produtos = arquivoProduto.leProdutosNoArquivo();
		List<Venda> vendas = arquivoVenda.leProdutosNoArquivo();
		float valor = go.somaDespedasMes((String) comboBox.getSelectedItem(), produtos);
		tfValor.setText(valor + "");
		System.out.println("okkk");
		float numero = go.obtemNumeroTotalDeVendas((String) comboBox.getSelectedItem(), vendas);
		
		tfNumero.setText(String.format("%.2f", numero));
		float valorTotal = go.obtemValorTotalDeVendas((String) comboBox.getSelectedItem(), vendas);
		tfValorTotal.setText(valorTotal + "");
		float saldo = go.saldo(valorTotal, valor);
		
		//tfSaldo.setText(saldo + "");
		
		
	}
}
