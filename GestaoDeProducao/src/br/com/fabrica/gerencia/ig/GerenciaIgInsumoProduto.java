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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoInsumoProduto;
import br.com.fabrica.gerencia.modelo.GerenciaInsumoProduto;
import br.com.fabrica.gui.IgInsumos;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.UnidadeMedida;
import br.com.fabrica.validacoes.Validacoes;

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

			boolean cadastrado = arquivoInsumo.escreveInsumosNoArquivo(ins);
			if(cadastrado)
				msgInfo(jf, CAD_INSUMO, INSUMO);
			else
				msgErro(jf, ERR_CAD_INSUMO, INSUMO);
		}

	}

	//TODO
	public static void obtemInsumosProduto(int codigo, DefaultTableModel defaultTableModel, JFrame jf){
		GerenciaInsumoProduto gi = new GerenciaInsumoProduto();
		if(codigo != 0) {
			List<Insumo> insumos = gi.obtemInsumosProduto(codigo); 
			if(insumos.size() > 0) {
				defaultTableModel.setNumRows(0);
				for(int i = 0; i < insumos.size(); i++) {
					defaultTableModel.insertRow(defaultTableModel.getRowCount(),
							new Object[] {insumos.get(i).getNome(),insumos.get(i).getQuantidade(),
									insumos.get(i).getMedida().getUnidade()});
				}
				defaultTableModel.insertRow(defaultTableModel.getRowCount(), new String[3]);
			}else
				msgInfo(jf, ERR_NAO_CAD_INSUMO, INSUMO);
		}
	}


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
				UnidadeMedida um = Validacoes.verificaMedida(String.format("%s",table.getValueAt(i, 2))); 
				if(um == null) {
					msgErro(jf, ERR_UNIDADE_MEDIDA, INSUMO);
					break;
				}
				else
					insumo.setMedida(um);
				insumo.setCodigoProduto(codigo);
				insumos.add(insumo);
			}
		}
		return insumos;
	}
}
