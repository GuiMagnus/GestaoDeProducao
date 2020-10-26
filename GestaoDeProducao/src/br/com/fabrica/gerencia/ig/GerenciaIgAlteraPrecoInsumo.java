package br.com.fabrica.gerencia.ig;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.validacoes.Validacoes;
import static br.com.fabrica.constantes.Constantes.*;

import static br.com.fabrica.gui.EntradaESaida.*;

public class GerenciaIgAlteraPrecoInsumo {
	public static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	
	public static void alteraPreco(JComboBox<String> comboProduto, JComboBox<String> comboInsumo,
			JTextField tfPreco, JFrame jf) {
		Insumo insumo = new Insumo();
		insumo.setCodigo(Validacoes.obtemCodigo(comboProduto.getSelectedItem().toString()));
		insumo.setCodigoProduto(Validacoes.obtemCodigo(comboInsumo.getSelectedItem().toString()));
		boolean alteracao = arquivoInsumo.alteraInsumosNoArquivo(insumo.getCodigoProduto(), insumo.getCodigo(),
				Validacoes.transformaEmFloat(tfPreco.getText()));
		if(alteracao)
			msgInfo(jf, ALTERA_PRECO, ALTERACAO);
		else
			msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		
	}
}
