package br.com.fabrica.gerencia.ig;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.gui.IgAlteraPrecoInsumo;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.validacoes.Validacoes;
import static br.com.fabrica.constantes.Constantes.*;

import static br.com.fabrica.gui.EntradaESaida.*;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgAlteraPrecoInsumo</code>
 * @see IgAlteraPrecoInsumo
 * @author Rafaela
 *
 */
public class GerenciaIgAlteraPrecoInsumo {
	public static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();
	
	/**
	 * Altera o preço referente ao insumo
	 * @param comboProduto Lista de produtos cadastrados
	 * @param comboInsumo Lista de insumos cadastrados
	 * @param tfPreco novo preço do insumo
	 * @param jf Janela principal
	 */
	public static void alteraPreco(JComboBox<String> comboInsumo, JTextField tfPreco, JFrame jf) {
		Insumo insumo = new Insumo();
		insumo.setCodigo(Validacoes.obtemCodigo(comboInsumo.getSelectedItem().toString()));
		
		System.out.println(Validacoes.transformaEmFloat(tfPreco.getText()));
		boolean alteracao = arquivoInsumo.alteraPreco(insumo.getCodigo(), 
				Validacoes.transformaEmFloat(tfPreco.getText()));
		if(alteracao)
			msgInfo(jf, ALTERA_PRECO, ALTERACAO);
		else
			msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		
	}
}
