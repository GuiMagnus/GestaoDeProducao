package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.*;
import static br.com.fabrica.constantes.Constantes.ERR_ALTERA_PRECO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.modelo.GerenciaHistoricoPreco;
import br.com.fabrica.gerencia.modelo.GerenciaProduto;
import br.com.fabrica.gui.IgAlteraPrecoVendaProduto;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgAlteraPrecoProduto</code>
 * @see IgAlteraPrecoVendaProduto
 * @author Rafaela e Guilherme
 *
 */
public class GerenciaIgAlteraPrecoProduto {
	public static ArquivoProduto arquivoProduto = new ArquivoProduto();
	
	/**
	 * Altera o preço referente ao produto
	 * @param comboProduto Lista de produtos cadastrados
	 * @param spinner nova margem de lucro
	 * @param tfPreco novo preço do insumo
	 * @param jf Janela principal
	 */

	public static void alteraPreco(JComboBox<String> comboProduto, JTextField tfPreco,
			JSpinner spinner, JFrame jf) {
		Produto produto = new Produto();
		GerenciaProduto gp = new GerenciaProduto();
		int codigo = Validacoes.obtemCodigo(comboProduto.getSelectedItem().toString());
		produto = arquivoProduto.obtemProduto(codigo);
		
		if(!tfPreco.getText().equals("")) {
			float preco = Validacoes.transformaEmFloat(tfPreco.getText());
			produto.setPrecoVenda(preco);
			produto.setMargemLucro(gp.calculaAumentoPercentual(produto));
			GerenciaHistoricoPreco ghp = new GerenciaHistoricoPreco();
			ghp.insereHistoricoPreco(preco, produto.getCodigo(), ARQ_HISTORICO_PRODUTO);
		}
			
		float margem = Validacoes.transformaEmFloat(spinner.getValue().toString());
		if(margem != 0) {
			float preco = gp.calculaPrecoFabricacao(produto);
			produto.setPrecoVenda(preco * (margem / 100));
			produto.setMargemLucro(margem);
		}
		
		Produto alteracao = arquivoProduto.alteraProduto(produto);
		if(alteracao != null)
			msgInfo(jf, String.format("O novo preço de venda é: %.2f\n"
					+ "A nova margem de lucro é: %.2f", produto.getPrecoVenda(),
					produto.getMargemLucro()), ALTERACAO);
		else
			msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		
	}
}
