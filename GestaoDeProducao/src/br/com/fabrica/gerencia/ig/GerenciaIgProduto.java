package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.CAD_PRODUTO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_PRODUTO;
import static br.com.fabrica.constantes.Constantes.PRODUTO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.validacoes.Validacoes.obtemUnidade;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gui.IgProdutos;
import br.com.fabrica.modelo.Produto;


/**
 * Classe respons�vel por gerenciar as fun��es da classe <code>IgProduto</code>
 * @see IgProduto
 * @author Rafaela
 *
 */
public class GerenciaIgProduto {
	private static ArquivoProduto arquivoProduto = new ArquivoProduto();
	
	/**
	 * Obt�m os dados informados nos componentes presentes na tela {@link IgProdutos},
	 * atribui o objeto � classe {@link Produto} e salva o produto cadastrado no arquivo
	 * correspondente.
	 * @param tfNome - <code>JTextField</code> : obt�m o nome do produto.
	 * @param comboBox - <code>JComboBox</code> : obt�m a unidade de medida que o produto
	 *  pode ter.
	 * @param spinner - <code>JSpinner</code> : obt�m a margem de lucro desejada para o produto.
	 * @param jf - <code>JTable</code> : janela respons�vel pela tela de cadastrar produtos.
	 */
	public static void cadastrarProdutos(JTextField tfNome, JComboBox<String> comboBox, 
			JSpinner spinner, JFrame jf) {
		Produto produto = new Produto();
		produto.setCodigo(arquivoProduto.obtemCodigoProduto());
		produto.setNome(tfNome.getText());
		produto.setUnidadeMedida(obtemUnidade(comboBox));
		produto.setMargemLucro(Float.parseFloat(spinner.getValue().toString()));
		boolean cadastrado = arquivoProduto.escreveProdutoNoArquivo(produto);
		
		if(cadastrado)
			msgInfo(jf, CAD_PRODUTO, PRODUTO);
		else
			msgErro(jf, ERR_CAD_PRODUTO, PRODUTO);
		
	}
	
}
