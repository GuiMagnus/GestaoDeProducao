package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.*;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.validacoes.Validacoes.obtemCodigo;
import static br.com.fabrica.validacoes.Validacoes.verificaNome;
import static br.com.fabrica.validacoes.Validacoes.verificaQuantidade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoInsumoProduto;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.modelo.GerenciaInsumoProduto;
import br.com.fabrica.gui.IgInsumos;
import br.com.fabrica.gui.IgInsumosProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgInsumoProduto</code>
 * @see IgInsumosProduto
 * @author Rafaela e Guilherme
 *
 */
public class GerenciaIgInsumoProduto {
	private static ArquivoInsumoProduto arquivoInsumo = new ArquivoInsumoProduto();

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
	public static void cadastraInsumo(JComboBox<String> comboBox, JTextField tfUnidade, 
			JFrame jf, DefaultTableModel table) {
		int codigo = obtemCodigo(comboBox.getSelectedItem().toString());
		if(codigo != 0) {
			List<Insumo> ins = cadastraInsumosProduto(codigo, table, jf);
			Produto produto = new Produto();
			produto.setCodigo(codigo);
			float tamanhoUnidade = Validacoes.transformaEmFloat(tfUnidade.getText());
			if(tamanhoUnidade <= 0)
				msgErro(jf, ERR_UNIDADE_MEDIDA, INSUMO);
			else {
				produto.setTamanhoUnidade(tamanhoUnidade);
				//Necessário para setar o tamanho da unidade no produto
				Produto prod = new ArquivoProduto().alteraProduto(produto);
				if(prod == null)
					msgErro(jf, ERR_CAD_UNIDADE_MEDIDA, INSUMO);
				else {
					
					boolean cadastrado = arquivoInsumo.escreveInsumosNoArquivo(ins);

					if(cadastrado)
						msgInfo(jf, CAD_INSUMO, INSUMO);
					else
						msgErro(jf, ERR_CAD_INSUMO, INSUMO);
				}

			}
		}
		else
			msgErro(jf, ERR_CAD_INSUMO_PRODUTO, INSUMO);
	}

	/**
	 * Obtém os insumos do produto ja cadastrados e joga as informações em uma tabela
	 * @param codigo código do produto
	 * @param defaultTableModel tabela que receberá os dados
	 * @param jf Janela principal
	 * @param tamanhoUnidade tamanho da unidade de determinado produto.
	 */
	public static void obtemInsumosProduto(int codigo, DefaultTableModel defaultTableModel,
			JFrame jf, JTextField tamanhoUnidade){
		GerenciaInsumoProduto gi = new GerenciaInsumoProduto();
		if(codigo != 0) {
			List<Insumo> insumos = gi.obtemInsumosProduto(codigo); 
			if(insumos.size() > 0) {
				defaultTableModel.setNumRows(0);
				Produto produto = new ArquivoProduto().obtemProduto(codigo);
				tamanhoUnidade.setText(String.format("%.2f",produto.getTamanhoUnidade()));
				for(int i = 0; i < insumos.size(); i++) {
					defaultTableModel.insertRow(defaultTableModel.getRowCount(),
							new Object[] {insumos.get(i).getNome(),insumos.get(i).getQuantidade()});
				}
				defaultTableModel.insertRow(defaultTableModel.getRowCount(), new String[2]);
			}else
				msgInfo(jf, ERR_NAO_CAD_INSUMO, INSUMO);
		}
	}

	/**
	 * Cadastra os insumos referentes ao produto
	 * @param codigo código do produto
	 * @param table tabela que receberá os dados
	 * @param jf Janela principal
	 * @return <code>List</code> lista com os insumos cadastrados
	 */
	public static List<Insumo> cadastraInsumosProduto(int codigo, DefaultTableModel table, JFrame jf){
		List<Insumo> insumos = new ArrayList<Insumo>();
		if(table.getValueAt(0, 0).toString() == null) {
			msgErro(jf, ERR_NOME_INSUMO, INSUMO);
		}else {
			for (int i = 0; i < table.getRowCount(); i++) {
				Insumo insumo = new Insumo();
				insumo.setCodigo(codigo);
				String validaNome = verificaNome(String.format("%s",table.getValueAt(i, 0)));

				if(validaNome.equalsIgnoreCase("null")) {
					if(table.getRowCount() > 1)
						break;
					else {
						msgErro(jf, ERR_NOME_INSUMO, INSUMO);
						break;
					}
				}
				else
					insumo.setNome(validaNome);
				float validaQuantidade = verificaQuantidade(String.format("%s",table.getValueAt(i, 1)));
				if(validaQuantidade == 0) {
					msgErro(jf, ERR_QTD_INSUMO, INSUMO);
					break;
				}
				else
					insumo.setQuantidade(validaQuantidade);
				insumo.setCodigoProduto(codigo);
				if(verificaInsumosRepetidos(insumo,codigo) == true)
					continue;
				else
					insumos.add(insumo);
			}
		}
		return insumos;
	}
	/**
	 * Verifica se o insumo a ser cadastrado já está no arquivo de insumos.
	 * @param insumo Insumo a ser verificado.
	 * @param codigo codigo do produto para verificação do insumo.
	 * @return true ou false indicando se o produto já está cadastrado ou não
	 */
	public static boolean verificaInsumosRepetidos(Insumo insumo, int codigo) {
		List<Insumo> insumosProdutoNoArquivo = new ArquivoInsumoProduto().obtemInsumosDeUmProduto(codigo); 
		for (Insumo insumoProduto : insumosProdutoNoArquivo) {
			if(insumoProduto.getNome().equalsIgnoreCase(insumo.getNome()))
				return true;
		}
		return false;
	}
}
