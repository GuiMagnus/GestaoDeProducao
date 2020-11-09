package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.*;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_INSUMO;
import static br.com.fabrica.constantes.Constantes.INSUMO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoInsumo;
import br.com.fabrica.gerencia.modelo.GerenciaHistoricoPreco;
import br.com.fabrica.gui.IgInsumos;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgInsumo</code>
 * @see IgInsumos
 * @author Rafaela
 *
 */
public class GerenciaIgInsumo {
	private static ArquivoInsumo arquivoInsumo = new ArquivoInsumo();

	/**
	 * Obtém os dados informados nos componentes presentes na tela {@link IgInsumos},
	 * atribui o objeto à classe {@link Insumo} e salva o insumo cadastrado no arquivo
	 * correspondente.
	 * @param tfNome <code>JTextField</code> nome do insumo
	 * @param spinner <code>JSpinner</code> quantidade do insumo
	 * @param tfPreco <code>JTextField</code> preço do insumo.
	 * @param jf <code>JFrame</code> tela principal.
	 */
	public static void cadastraInsumo(JTextField tfNome,JSpinner spinner, JTextField tfPreco, 
			JFrame jf) {
		Insumo insumo = new Insumo();
		insumo.setCodigo(arquivoInsumo.obtemCodigoInsumo());
		insumo.setNome(tfNome.getText());
		insumo.setQuantidade((int) spinner.getValue());
		insumo.setPrecoUnitario(Validacoes.transformaEmFloat(tfPreco.getText()));
		GerenciaHistoricoPreco ghp = new GerenciaHistoricoPreco();
		
		ghp.insereHistoricoPreco(insumo.getPrecoUnitario(), insumo.getCodigo(), ARQ_HISTORICO_INSUMO);
		
		boolean cadastrado = arquivoInsumo.escreveInsumoNoArquivo(insumo);
		if(cadastrado)
			msgInfo(jf, CAD_INSUMO, INSUMO);
		else
			msgErro(jf, ERR_CAD_INSUMO, INSUMO);
	}

}
