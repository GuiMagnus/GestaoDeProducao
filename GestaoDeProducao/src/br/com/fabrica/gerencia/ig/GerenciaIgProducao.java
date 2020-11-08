package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.*;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_PRODUCAO;
import static br.com.fabrica.constantes.Constantes.PRODUCAO;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoProduto;
import br.com.fabrica.gerencia.modelo.GerenciaInsumo;
import br.com.fabrica.gerencia.modelo.GerenciaProducao;
import br.com.fabrica.gerencia.modelo.GerenciaProduto;
import br.com.fabrica.gui.IgProducao;
import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Data;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável em obter os dados informados pelo usuário.
 * Atribuir aos objetos ao qual os dados pertecem e escrever em seus respectivos
 * arquivos 
 * @see IgProducao
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
	 * @param tfQtdProduzida - <code>JTextField</code> : quantidade do produto produzido.
	 * @param jf - <code>JTable</code> : janela responsável pela tela de cadastrar produção.
	 */
	public static void cadastrarProducao(JComboBox<String> comboBox, JTextField tfData,
			JTextField tfQtdProduzida, JFrame jf) {
		
		Producao producao = new Producao();
		int codigoProduto = Validacoes.obtemCodigo(comboBox.getSelectedItem().toString());
		Produto produto = new ArquivoProduto().obtemProduto(codigoProduto);
		GerenciaProducao gp = new GerenciaProducao();

		if(gp.verificaInsumosECalculaPreco(produto, Integer.parseInt(tfQtdProduzida.getText())) <= 0) {
			msgErro(jf, ERR_QTD_INSUMO_PROD, PRODUCAO);
			
		}
		else {
			List<Insumo> insumosProduto = new GerenciaProduto().obtemListaInsumosProduto(produto); 
			List<Insumo> insumosDoEstoque = new GerenciaInsumo().obtemPrecoInsumosEstoque(insumosProduto);
			produto.setInsumos(insumosDoEstoque);
			producao.setProduto(produto);
			producao.setData(new Data(tfData.getText()));
			producao.getProduto().setQuantidade(Integer.parseInt(tfQtdProduzida.getText()));
			float valorProducao =  gp.verificaInsumosECalculaPreco(produto, producao.getProduto().getQuantidade());
			producao.setCustoProducao(valorProducao);
			
			boolean cadastrado = arquivoProducao.escreveProducaoNoArquivo(producao);
			if(cadastrado) {
				msgInfo(jf, CAD_PRODUCAO, PRODUCAO);
				
				float valorVenda =  gp.calculaVendaProduto(produto,producao.getProduto().getQuantidade());
				msgInfo(jf, String.format("O custo total da produção é: %.2f\n"
						+ "O valor de venda é: %.2f" ,valorProducao, valorVenda),
						PRODUCAO);
			}
			else
				msgErro(jf, ERR_CAD_PRODUCAO, PRODUCAO);
		}
		
	}

}
