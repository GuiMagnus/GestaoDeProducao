package br.com.fabrica.gerencia;

import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.strings.Constantes.CAD_INSUMO;
import static br.com.fabrica.strings.Constantes.CAD_PRODUTO;
import static br.com.fabrica.strings.Constantes.ERR_CAD_INSUMO;
import static br.com.fabrica.strings.Constantes.ERR_CAD_PRODUTO;
import static br.com.fabrica.strings.Constantes.ERR_NOME_INSUMO;
import static br.com.fabrica.strings.Constantes.ERR_QTD_INSUMO;
import static br.com.fabrica.strings.Constantes.INSUMO;
import static br.com.fabrica.strings.Constantes.PRODUTO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;
import br.com.fabrica.validacoes.Validacoes;

public class CadastroDeInformacoes {
	public static ArquivoProduto arqProduto = new ArquivoProduto();
	public static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	
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
	
	
	
	public static void cadastrarProdutos(JTextField tfNome, JComboBox<String> comboBox, 
			JSpinner spinner, JFrame jf) {
		Produto produto = new Produto();
		produto.setNome(tfNome.getText());
		produto.setUnidadeMedida(obtemUnidade(comboBox));
		produto.setMargemLucro(Float.parseFloat(spinner.getValue().toString()));
		
		boolean cadastrado = arqProduto.escreveProdutoNoArquivo(produto);
		if(cadastrado)
			msgInfo(jf, CAD_PRODUTO, PRODUTO);
		else
			msgErro(jf, ERR_CAD_PRODUTO, PRODUTO);
		
	}
	
	public static void cadastraProducao(JTextField tfNome, JTextField tfData, 
			JTextField tfQtdProduzida) {
		
		
	}
	
	public static void povoaTabela(JTable table, JScrollPane js) {
		String colunas[] = {"Nome", "Quantidade", "Porcentagem"};
		Object linhas[][] = new Object[10][colunas.length];
		linhas[0][0] = "asdasdas";
		
		table = new JTable(linhas, colunas);
		js.add(table);
	}
	
	public static UnidadeMedida obtemUnidade(JComboBox<String> comboBox) {
		UnidadeMedida unidade = null;
		for(UnidadeMedida um : UnidadeMedida.values()) {
			if(comboBox.getSelectedItem().toString().contains(um.getNome()))
				unidade = um;
		}
		
		return unidade;
	}

}
