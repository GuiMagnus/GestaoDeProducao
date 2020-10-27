package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.CAD_PRODUCAO;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_PRODUCAO;
import static br.com.fabrica.constantes.Constantes.PRODUCAO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.gerencia.modelo.GerenciaProducao;
import br.com.fabrica.gui.IgProducao;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;

/**
 * Classe responsável em obter os dados informados pelo usuário.
 * Atribuir aos objetos ao qual os dados pertecem e escrever em seus respectivos
 * arquivos 
 * @author Rafaela
 *
 */
public class GerenciaIgProducao {
	
	
	private static ArquivoProducao arquivoProducao = new ArquivoProducao();

	/**
	 * Obtém os dados informados nos componentes presentes na tela {@link IgProducao},
	 * atribui o objeto à classe {@link Producao} e salva o produto cadastrado no arquivo
	 * correspondente.
	 * @param comboBox- <code>JCombobox</code> : informa os produtos cadastrados.
	 *  A partir do produto escolhido, é possível cadastrar a produção do produto.
	 * @param tfData - <code>JTextField</code> : data em que o produto foi produzido
	 * @param tfQtdProduziada - <code>JTextField</code> : quantidade do produto produzido.
	 * @param jf - <code>JTable</code> : janela responsável pela tela de cadastrar produção.
	 */
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
		
		GerenciaProducao gp = new GerenciaProducao();
		msgInfo(jf, String.format("O custo total da produção é: %.2f\n"
				+ "O valor de venda que será obtido: %.2f", gp.calculaCustoTotalProducao(produto,
						producao.getQuantidade()), gp.calculaValorTotalVenda(produto,
								producao.getQuantidade())), PRODUCAO);
		
	}
	
	

}
