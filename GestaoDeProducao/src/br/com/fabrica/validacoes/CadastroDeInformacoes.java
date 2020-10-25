package br.com.fabrica.validacoes;


import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;

public class CadastroDeInformacoes {
	
	//public static void cadastraInsumo(JTextField tfNome, JComboBox<String> comboBox) {
		//Insumo insumo = new Insumo();
		
	//}
	
	public static void cadastrarProdutos(JTextField tfNome, JComboBox<String> comboBox, JSpinner spinner) {
		Produto produto = new Produto();
		produto.setNome(tfNome.getText());
		produto.setUnidadeMedida(obtemUnidade(comboBox));
		produto.setMargemLucro(Float.parseFloat(spinner.getValue().toString()));
		ArquivoProduto arqProduto = new ArquivoProduto();
		arqProduto.escreveProdutoNoArquivo(produto);
		
	}
	
	public static void cadastraProducao(JTextField tfNome, JTextField tfData, 
			JTextField tfQtdProduzida) {
		
		
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
