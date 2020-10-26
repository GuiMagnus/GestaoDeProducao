package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_NAO_CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_NOME_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_QTD_INSUMO;
import static br.com.fabrica.constantes.Constantes.INSUMO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.validacoes.Validacoes.obtemCodigo;
import static br.com.fabrica.validacoes.Validacoes.verificaNome;
import static br.com.fabrica.validacoes.Validacoes.verificaPreco;
import static br.com.fabrica.validacoes.Validacoes.verificaQuantidade;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.gerencia.modelo.GerenciaInsumo;
import br.com.fabrica.gui.IgInsumos;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;

public class GerenciaIgInsumo {
	private static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	
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
			JFrame jf, JTable table) {
		Produto produto = new Produto();
		produto.setCodigo(obtemCodigo(comboBox.getSelectedItem().toString()));
		
		List<Insumo> insumos = cadastraInsumosProduto(produto.getCodigo(), table, jf);
		
		boolean cadastrado = arquivoInsumo.escreveInsumosNoArquivo(insumos);
		if(cadastrado)
			msgInfo(jf, CAD_INSUMO, INSUMO);
		else
			msgErro(jf, ERR_CAD_INSUMO, INSUMO);
	}
	
	public static void obtemInsumosProduto(int codigo, JTable table, JFrame jf){
		GerenciaInsumo gi = new GerenciaInsumo();
		List<Insumo> insumos = gi.obtemInsumosProduto(codigo); 
		if(insumos.size() > 0) {
			for(int i = 0; i < insumos.size(); i++) {
				table.setValueAt(insumos.get(i).getNome(), i, 0);
				table.setValueAt(insumos.get(i).getQuantidade(), i, 1);
				table.setValueAt(insumos.get(i).getPrecoUnitario(), i, 2);
			}
		}else
			msgInfo(jf, ERR_NAO_CAD_INSUMO, INSUMO);
	}

	//TODO
	//descobrir como criar linhas dinamicamente
	public static List<Insumo> cadastraInsumosProduto(int codigo, JTable table, JFrame jf){
			GerenciaInsumo gi = new GerenciaInsumo();
		List<Insumo> insumos = gi.obtemInsumosProduto(codigo); 
		if(table.getValueAt(0, 0).toString() == null) {
			msgErro(jf, ERR_NOME_INSUMO, INSUMO);
		}else {
			for (int i = 0; i < table.getRowCount(); i++) {
				//while(table.getValueAt(i, 0).toString() != null) {
					if(gi.verificaInsumoCadastrado(verificaNome(table.getValueAt(i, 0).toString()), insumos)) {
						//msgErro(jf, String.format("O insumo %s já está cadastrado", validaNome), INSUMO);
						continue;
					}
					if(table.getValueAt(i, 0) != null) {
						Insumo insumo = new Insumo();
						insumo.setCodigo(codigo);
						String validaNome = verificaNome(table.getValueAt(i, 0).toString());
						if(validaNome == null) {
							msgErro(jf, ERR_NOME_INSUMO, INSUMO);
							break;
						}
						else
							insumo.setNome(validaNome);
						
						float validaQuantidade = verificaQuantidade(table.getValueAt(i, 1).toString());
						if(validaQuantidade == 0) {
							msgErro(jf, ERR_QTD_INSUMO, INSUMO);
						}	
						else
							insumo.setQuantidade(validaQuantidade);
						float validaPreco = verificaPreco(table.getValueAt(i, 2).toString());
						if(validaPreco == 0) {
							msgErro(jf, ERR_QTD_INSUMO, INSUMO);
							break;
						}	
						else
							insumo.setQuantidade(validaQuantidade);
						insumo.setCodigoProduto(codigo);
						insumos.add(insumo);
					}//if
					else {
						msgErro(jf, ERR_NAO_CAD_INSUMO, INSUMO);
						break;
					}
				}//for
				
		}
		
		return insumos;
		
	}
	
}
