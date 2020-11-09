package br.com.fabrica.gerencia.ig;

import static br.com.fabrica.constantes.Constantes.*;
import static br.com.fabrica.constantes.Constantes.ERR_CAD_VENDA;
import static br.com.fabrica.constantes.Constantes.VENDA;
import static br.com.fabrica.gui.EntradaESaida.msgErro;
import static br.com.fabrica.gui.EntradaESaida.msgInfo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.arquivos.ArquivoProducao;
import br.com.fabrica.arquivos.ArquivoVenda;
import br.com.fabrica.arquivos.ArquivoVendaProduto;
import br.com.fabrica.gui.IgVendas;
import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;
import br.com.fabrica.validacoes.Data;
import br.com.fabrica.validacoes.Validacoes;

/**
 * Classe responsável por gerenciar as funções da classe <code>IgVendas</code>
 * @see IgVendas
 * @author Rafaela
 *
 */
public class GerenciaIgVenda {
	private static ArquivoVenda arquivoVenda = new ArquivoVenda();
	private static ArquivoVendaProduto arquivoVendaProduto = new ArquivoVendaProduto();
	
	/**
	 * Registra uma venda que foi feita
	 * @param jf janela principal
	 * @param dtm tabela que receberá os dados
	 * @param data data da venda
	 * @param hora hora da venda
	 * @param tfVenda valor da venda
	 */
	public static void registraVenda(JFrame jf, DefaultTableModel dtm, JTextField data, 
			JTextField hora, JTextField tfVenda) {
		Venda venda = new Venda();
		venda.setCodigo(arquivoVenda.obtemCodigoVenda());
		venda.setData(new Data(data.getText()));
		venda.setHora(hora.getText());
		venda.setValorTotalVenda(Validacoes.transformaEmFloat(tfVenda.getText()));
		List<Produto> produtos = new ArrayList<Produto>();
		for (int i = 0; i < dtm.getRowCount(); i++) {
			Produto produto = new Produto();
			produto.setNome(String.format("%s",dtm.getValueAt(i, 0)));
			produto.setCodigo(venda.getCodigo());
			produto.setQuantidade(Integer.parseInt(String.format("%s",dtm.getValueAt(i, 1))));
			produto.setPrecoFabricacao(Float.parseFloat(String.format("%s",dtm.getValueAt(i, 2))));
			produto.setPrecoVenda(Float.parseFloat(String.format("%s",dtm.getValueAt(i, 3))));
			produtos.add(produto);
			
		}
		venda.setProdutos(produtos);
		boolean cadastroVenda = arquivoVenda.gravaVenda(venda);
		if(cadastroVenda) {
			boolean cadastroProdutoVenda = arquivoVendaProduto.gravaProdutosVendidos(venda);
			if(cadastroProdutoVenda)
				msgInfo(jf, CAD_VENDA, VENDA);
			else
				msgErro(jf, ERR_CAD_VENDA, VENDA);
		}
		
		//Altera Quantidade Produção
		ArquivoProducao ap = new ArquivoProducao();
		List<Producao> listaProducao = ap.leProducoesNoArquivo(ARQ_PRODUCAO);
		for(Producao producao : listaProducao) {
			for(Produto produto : produtos) {
				if(producao.getCodigo() == produto.getCodigo()) {
					producao.getProduto().setQuantidade(producao.getProduto().getQuantidade() - 
							produto.getQuantidade());
					ap.alteraProducao(producao, ARQ_PRODUCAO);
				}
			}
		}
	}
}
