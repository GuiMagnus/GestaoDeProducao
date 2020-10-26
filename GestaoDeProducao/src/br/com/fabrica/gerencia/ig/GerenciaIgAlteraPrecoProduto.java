package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.ALTERACAO;
import static br.com.fabrica.constantes.Constantes.ERR_ALTERA_PRECO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.modelo.GerenciaProduto;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

public class GerenciaIgAlteraPrecoProduto {
	public static ArquivoProduto arquivoProduto = new ArquivoProduto();
	
	public static void alteraPreco(JComboBox<String> comboProduto, JTextField tfPreco,
			JSpinner spinner, JFrame jf) {
		Produto produto = new Produto();
		GerenciaProduto gp = new GerenciaProduto();
		int codigo = Validacoes.obtemCodigo(comboProduto.getSelectedItem().toString());
		float preco = Validacoes.transformaEmFloat(tfPreco.getText());
		System.out.println(codigo);
		produto = arquivoProduto.obtemProduto(codigo);
		
		if(!tfPreco.getText().equals("")) {
			produto.setPrecoVenda(preco);
			produto.setMargemLucro(gp.calculaAumentoPercentual(produto));
		}
			
		float margem = Validacoes.transformaEmFloat(spinner.getValue().toString());
		if(margem != 0) {
			produto.setPrecoVenda(gp.calculaPrecoFabricacao(produto));
			produto.setMargemLucro(margem);
		}
			
		
		Produto alteracao = arquivoProduto.alteraPrecoProduto(produto);
		if(alteracao != null)
			msgInfo(jf, String.format("O novo preço de venda é: %.2f\n"
					+ "A nova margem de lucro é: %.2f", produto.getPrecoVenda(),
					produto.getMargemLucro()), ALTERACAO);
		else
			msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		
	}
}
