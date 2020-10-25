package br.com.fabrica.gerencia;

import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;
import static br.com.fabrica.strings.Constantes.*;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;
import br.com.fabrica.validacoes.Validacoes;

public class CadastroDeInformacoes {
	private static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	private static ArquivoProduto arquivoProduto = new ArquivoProduto();
	private static ArquivoProducao arquivoProducao = new ArquivoProducao();
	
	public static void cadastraInsumo(JTextField tfNome, JTextField tfTamanhoUnidade, JFrame jf) {
		Insumo insumo = new Insumo();
		insumo.setNome(tfNome.getText());
		insumo.setQuantidade(Validacoes.transformaEmFloat(tfTamanhoUnidade.getText()));
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
		boolean cadastrado = arquivoProduto.escreveProdutoNoArquivo(produto);
		if(cadastrado)
			msgInfo(jf, CAD_PRODUTO, PRODUTO);
		else
			msgErro(jf, ERR_CAD_PRODUTO, PRODUTO);
		
	}
	
	public static void cadastraProducao(JTextField tfNome, JTextField tfData, 
			JTextField tfQtdProduzida) {
		
		
	}
	
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
	
	public static UnidadeMedida obtemUnidade(JComboBox<String> comboBox) {
		UnidadeMedida unidade = null;
		for(UnidadeMedida um : UnidadeMedida.values()) {
			if(comboBox.getSelectedItem().toString().contains(um.getNome()))
				unidade = um;
		}
		
		return unidade;
	}
}
