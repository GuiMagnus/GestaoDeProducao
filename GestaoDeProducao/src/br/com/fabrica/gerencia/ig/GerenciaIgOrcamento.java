package br.com.fabrica.gerencia.ig;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.gerencia.modelo.GerenciaOrcamento;
import br.com.fabrica.gui.IgOrcamento;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;
import static br.com.fabrica.constantes.Constantes.*;
/**
 * Classe responsável por gerenciar as funções da classe <code>IgOrcamento</code>
 * @see IgOrcamento
 * @author Rafaela
 *
 */
public class GerenciaIgOrcamento {
	private static ArquivoProduto arquivoProduto = new ArquivoProduto();
	private static ArquivoVenda arquivoVenda = new ArquivoVenda();
	
	/**
	 * Obtém as informações referentes ao orçamento.
	 * @param comboBox lista de produtos cadastrados
	 * @param tfValor valor total dos insumos
	 * @param tfNumero número total de vendas
	 * @param tfValorTotal valor total das vendas
	 * @param tfSaldo saldo obtido no mes
	 */
	public static void obtemOrcamento(JComboBox<String> comboBox, JTextField tfValor, JTextField
					tfNumero, JTextField tfValorTotal, JTextField tfSaldo) {
		if(comboBox.getSelectedItem()== VALOR_DEFAULT_CB_ORCAMENTO)
			return;
		GerenciaOrcamento go = new GerenciaOrcamento();
		List<Produto> produtos = arquivoProduto.leProdutosNoArquivo();
		List<Venda> vendas = arquivoVenda.leProdutosNoArquivo();
		float valor = go.somaDespedasMes((String) comboBox.getSelectedItem(), produtos);
		tfValor.setText(valor + "");
		float numero = go.obtemNumeroTotalDeVendas((String) comboBox.getSelectedItem(), vendas);
		
		tfNumero.setText(String.format("%.2f", numero));
		float valorTotal = go.obtemValorTotalDeVendas((String) comboBox.getSelectedItem(), vendas);
		tfValorTotal.setText(valorTotal + "");
		float saldo = go.saldo(valorTotal, valor);
		
		tfSaldo.setText(saldo + "");
		
		
	}
}
