package br.com.fabrica.gerencia.ig;

import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fabrica.gerencia.modelo.GerenciaRelatorioProducao;
import br.com.fabrica.modelo.Producao;

public class GerenciaIgRelatorioProducao {
	/**
	 * Obtém os dados dos produtos que foram produzidos, ordena e exibe em uma tabela.
	 * @param jf tela principal
	 * @param tfDataI período Inicial.
	 * @param tfDataF período Final.
	 * @param dfm tabela onde os dados serão armazenados.
	 */
	public static void relatorio(JFrame jf, JTextField tfDataI, JTextField tfDataF,
			DefaultTableModel dfm) {
		List<Producao> listaPeriodo = GerenciaRelatorioProducao.producaoPorPeriodo(tfDataI.getText(),
				tfDataF.getText());
		Collections.sort(listaPeriodo);
		for(int i = 0; i < listaPeriodo.size(); i++) {
			dfm.insertRow(dfm.getRowCount(),
					new Object[] {listaPeriodo.get(i).getProduto().getNome(), listaPeriodo.get(i).getProduto().getQuantidade(),
							listaPeriodo.get(i).getCustoProducao()
							});
		}
	}
}
