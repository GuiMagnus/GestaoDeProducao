package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.ALTERACAO;
import static br.com.fabrica.constantes.Constantes.ALTERA_PRECO;
import static br.com.fabrica.constantes.Constantes.ARQ_HISTORICO_INSUMO;
import static br.com.fabrica.constantes.Constantes.ERR_ALTERA_PRECO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoHistoricoPreco;
import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.gerencia.modelo.GerenciaHistoricoPreco;
import br.com.fabrica.gui.IgAlteraPrecoInsumo;
import br.com.fabrica.modelo.HistoricoPreco;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgAlteraPrecoInsumo</code>
 * @see IgAlteraPrecoInsumo
 * @author Rafaela e Guilherme
 *
 */
public class GerenciaIgAlteraPrecoInsumo {
	public static ArquivoHistoricoPreco arquivoHistorico = new ArquivoHistoricoPreco();
	
	/**
	 * Altera o preço referente ao insumo
	 * @param comboInsumo Lista de insumos cadastrados
	 * @param tfPreco novo preço do insumo
	 * @param jf Janela principal
	 */
	public static void alteraPreco(JComboBox<String> comboInsumo, JTextField tfPreco, JFrame jf) {
		int codigo = Validacoes.obtemCodigo(comboInsumo.getSelectedItem().toString());
		float preco = Validacoes.transformaEmFloat(tfPreco.getText());
		HistoricoPreco hp = new HistoricoPreco();
		hp.setCodigo(codigo);
		boolean altera = new ArquivoInsumo().alteraPreco(codigo, preco);
		if(altera){
			boolean alteracao = new GerenciaHistoricoPreco().insereHistoricoPreco(preco, codigo, ARQ_HISTORICO_INSUMO);
			if(alteracao)
				msgInfo(jf, ALTERA_PRECO, ALTERACAO);
			else
				msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		}else
			msgErro(jf, ERR_ALTERA_PRECO, ALTERACAO);
		
		
		
	}
}
