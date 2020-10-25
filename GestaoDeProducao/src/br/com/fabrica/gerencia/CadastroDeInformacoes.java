package br.com.fabrica.gerencia;

import static br.com.fabrica.constantes.Constantes.CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.CAD_PRODUCAO;
import static br.com.fabrica.constantes.Constantes.CAD_PRODUTO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_PRODUCAO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_PRODUTO;
import static br.com.fabrica.constantes.Constantes.ERR_NOME_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_QTD_INSUMO;
import static br.com.fabrica.constantes.Constantes.INSUMO;
import static br.com.fabrica.constantes.Constantes.PRODUCAO;
import static br.com.fabrica.constantes.Constantes.PRODUTO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gui.IgInsumos;
import br.com.fabrica.gui.IgProducao;
import br.com.fabrica.gui.IgProdutos;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável em obter os dados informados pelo usuário.
 * Atribuir aos objetos ao qual os dados pertecem e escrever em seus respectivos
 * arquivos 
 * @author Rafaela
 *
 */
public class CadastroDeInformacoes {
	private static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	private static ArquivoProduto arquivoProduto = new ArquivoProduto();
	private static ArquivoProducao arquivoProducao = new ArquivoProducao();
	public static ArquivoProduto arqProduto = new ArquivoProduto();

	
	
	

		

	/**
	 * Obtém os dados informados nos componentes presentes na tela {@link IgInsumos},
	 * atribui o objeto à classe {@link Insumo} e salva o insumo cadastrado no arquivo
	 * correspondente.
	 * @param comboBox - <code>JCombobox</code> : informa os produtos cadastrados. 
	 * A partir do produto escolhido, é possível cadastrar os insumos referente ao produto.
	 * @param tfUnidade - <code>JTextField</code> : obtém a unidade usada por cada insumo 
	 * para produzir uma unidade.
	 * @param jf - <code>JFrame</code> : janela responsável pela tela de cadastrar insummos.
	 * @param table - <code>JTable</code> : tabela onde serão cadastrados os dados dos insumos.
	 */
	public static void cadastraInsumo(JComboBox<String> comboBox, JTextField tfUnidade, JFrame jf, JTable table) {
		Produto produto = new Produto();
		produto.setCodigo(Validacoes.obtemCodigo(comboBox.getSelectedItem().toString()));
		produto.setNome(Validacoes.obtemNome(comboBox.getSelectedItem().toString()));
		List<Insumo> insumos = new ArrayList<>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if(table.getValueAt(i, 0) != null) {
				Insumo insumo = new Insumo();
				String validaNome = Validacoes.verificaNome(table.getValueAt(i, 0).toString());
				if(validaNome == null) {
					msgErro(jf, ERR_NOME_INSUMO, INSUMO);
					break;
				}	
				else
					insumo.setNome(validaNome);
				
				float validaQuantidade = Validacoes.verificaQuantidade(table.getValueAt(i, 1).toString());
				if(validaQuantidade == 0) {
					msgErro(jf, ERR_QTD_INSUMO, INSUMO);
					break;
				}	
				else
					insumo.setQuantidade(validaQuantidade);
				
				
				float validaPreco = Validacoes.verificaPreco(table.getValueAt(i, 2).toString());
				if(validaPreco == 0) {
					msgErro(jf, ERR_QTD_INSUMO, INSUMO);
					break;
				}	
				else
					insumo.setQuantidade(validaQuantidade);
				insumo.setCodigoProduto(produto.getCodigo());
				insumos.add(insumo);
			}else
				break;
			
		}//for
		produto.setInsumos(insumos);
		boolean cadastrado = arquivoInsumo.escreveInsumosNoArquivo(insumos);
		if(cadastrado)
			msgInfo(jf, CAD_INSUMO, INSUMO);
		else
			msgErro(jf, ERR_CAD_INSUMO, INSUMO);
	}
	
	
	/**
	 * Obtém os dados informados nos componentes presentes na tela {@link IgProdutos},
	 * atribui o objeto à classe {@link Produto} e salva o produto cadastrado no arquivo
	 * correspondente.
	 * @param tfNome - <code>JTextField</code> : obtém o nome do produto.
	 * @param comboBox - <code>JComboBox</code> : obtém a unidade de medida que o produto
	 *  pode ter.
	 * @param spinner - <code>JSpinner</code> : obtém a margem de lucro desejada para o produto.
	 * @param jf - <code>JTable</code> : janela responsável pela tela de cadastrar produtos.
	 */
	public static void cadastrarProdutos(JTextField tfNome, JComboBox<String> comboBox, 
			JSpinner spinner, JFrame jf) {
		Produto produto = new Produto();
		produto.setNome(tfNome.getText());
		produto.setUnidadeMedida(Validacoes.obtemUnidade(comboBox));
		produto.setMargemLucro(Float.parseFloat(spinner.getValue().toString()));
		boolean cadastrado = arquivoProduto.escreveProdutoNoArquivo(produto);
		
		if(cadastrado)
			msgInfo(jf, CAD_PRODUTO, PRODUTO);
		else
			msgErro(jf, ERR_CAD_PRODUTO, PRODUTO);
		
	}
	
	
	/**
	 * Obtém os dados informados nos componentes presentes na tela {@link IgProducao},
	 * atribui o objeto à classe {@link Producao} e salva o produto cadastrado no arquivo
	 * correspondente.
	 * @param comboBox- <code>JCombobox</code> : informa os produtos cadastrados.
	 *  A partir do produto escolhido, é possível cadastrar a produção do produto.
	 * @param tfData - <code>JTextField</code> : data em que o produto foi produzido
	 * @param tfQtdProduziada - <code>JTextField</code> : quantidade do produto produzido.
	 * @param jf - <code>JTable</code> : janela responsável pela tela de cadastrar produção.
	 */
	public static void cadastrarProducao(JComboBox<String> comboBox, JTextField tfData,
			JTextField tfQtdProduziada, JFrame jf) {
		Producao producao = new Producao();
		Produto produto = new Produto();
		produto.setNome(comboBox.getSelectedItem().toString());
		producao.setData(tfData.getText());
		producao.setQuantidade(Integer.parseInt(tfQtdProduziada.getText()));
		
		
		boolean cadastrado = arquivoProducao.escreveProducaoNoArquivo(producao);
		if(cadastrado)
			msgInfo(jf, CAD_PRODUCAO, PRODUCAO);
		else
			msgErro(jf, ERR_CAD_PRODUCAO, PRODUCAO);
		
	}
	
	

}
