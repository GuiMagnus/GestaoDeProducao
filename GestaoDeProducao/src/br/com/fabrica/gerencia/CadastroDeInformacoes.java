package br.com.fabrica.gerencia;

import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.strings.Constantes.*;

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
	
	public static void cadastraInsumo(JTextField tfNome, JTextField tfTamanhoUnidade, JFrame jf) {
		Insumo insumo = new Insumo();
		insumo.setNome(tfNome.getText());
		ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
		insumo.setQuantidade(Validacoes.validaFloat(tfTamanhoUnidade.getText()));
		boolean cadastrado = arquivoInsumo.escreveInsumoNoArquivo(insumo);
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
		ArquivoProduto arquivoProduto = new ArquivoProduto();
		boolean cadastrado = arquivoProduto.escreveProdutoNoArquivo(produto);
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
