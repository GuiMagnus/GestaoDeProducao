package br.com.fabrica.constantes;

/**
 * Classe para definir Strings literais
 * @author Rafaela
 *
 */
public class Constantes {
	/**
	 * <code>String</code> : Determina o arquivo relacionado a produtos.
	 */
	public static String ARQ_PRODUTO = "..\\GestaoDeProducao\\arquivos\\produto.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado ao relatório de produção.
	 */
	public static String ARQ_REL_PROD = "..\\GestaoDeProducao\\arquivos\\relatorioProducao.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a Histórico de preços.
	 */
	public static String ARQ_HISTORICO_INSUMO = "..\\GestaoDeProducao\\arquivos\\historicoPrecoInsumo.dat";
	/**
	 * <code>String</code> : Determina o arquivo relacionado a Histórico de preços.
	 */
	public static String ARQ_HISTORICO_PRODUTO = "..\\GestaoDeProducao\\arquivos\\historicoPrecoProduto.dat";
	
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a insumos.
	 */
	public static String ARQ_INSUMO = "..\\GestaoDeProducao\\arquivos\\insumo.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a produção.
	 */
	public static String ARQ_PRODUCAO = "..\\GestaoDeProducao\\arquivos\\producao.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a venda.
	 */
	public static String ARQ_VENDA = "..\\GestaoDeProducao\\arquivos\\venda.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a venda de um produto.
	 */
	public static String ARQ_VENDA_PRODUTO = "..\\GestaoDeProducao\\arquivos\\vendaProduto.dat";
	
	
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado a produtos.
	 */
	public static String ARQ_PRECO_INSUMO = "..\\GestaoDeProducao\\arquivos\\historicoPrecoInsumo.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado aos preços dos produtos.
	 */
	public static String ARQ_PRECO_PRODUTO = "..\\GestaoDeProducao\\arquivos\\historicoPrecoProduto.dat";
	
	/**
	 * <code>String</code> : Determina o arquivo relacionado ao insumos do produtos.
	 */
	public static String ARQ_INSUMO_PRODUTO = "..\\GestaoDeProducao\\arquivos\\insumosProduto.dat";
	
	/**
	 * <code>String</code> : Mensagem informando que o produto foi cadastrado com sucesso
	 */
	public static String CAD_PRODUTO = "Produto cadastrado com sucesso";
	
	/**
	 * <code>String</code> : Mensagem informando o cadastro de produtos
	 */
	public static String PRODUTO = "Cadastro de Produtos";
	
	/**
	 * <code>String</code> : Mensagem informando que o produto não foi cadastrado.
	 */
	public static String ERR_CAD_PRODUTO = "Falha ao cadastrar produto";
	
	/**
	 * <code>String</code> : Mensagem informando que o insumo foi cadastrado com sucesso.
	 */
	public static String CAD_INSUMO = "Insumo cadastrado com sucesso";
	
	/**
	 * <code>String</code> : Mensagem informando o cadastro de insumos.
	 */
	public static String INSUMO = "Cadastro de Insumos";
	
	/**
	 * <code>String</code> : Mensagem informando que o insumo não foi cadastrado.
	 */
	public static String ERR_CAD_INSUMO = "Falha ao cadastrar insumo";
	
	/**
	 * <code>String</code> : Mensagem informando que o insumo não foi cadastrado.
	 */
	public static String ERR_CAD_INSUMO_PRODUTO = "É necessário selecionar um produto primeiro";
	
	/**
	 * <code>String</code> : Mensagem informando que a produção foi cadastrado com sucesso.
	 */
	public static String CAD_PRODUCAO = "Produção cadastrada com sucesso";
	
	/**
	 *<code>String</code> :  Mensagem informando o cadastro de produção.
	 */
	public static String PRODUCAO = "Cadastro de Produção";
	
	/**
	 * <code>String</code> : Mensagem informando que a produção não foi cadastrada.
	 */
	public static String ERR_CAD_PRODUCAO = "Falha ao cadastrar produção";
	
	/**
	 * <code>String</code> : Mensagem informando que o nome do insumo não foi informado.
	 */
	public static String ERR_NOME_INSUMO = "O nome do insumo precisa ser informado";
	
	/**
	 * <code>String</code> : Mensagem informando que a quantidade do insumo não foi informado.
	 */
	public static String ERR_QTD_INSUMO = "A quantidade do insumo precisa ser informado";
	
	/**
	 * <code>String</code> : Mensagem informando que a quantidade do insumo não foi informado.
	 */
	public static String ERR_INSUMOS_REPETIDOS = "Insumos Repetidos serão ignorados!";
	/**
	 * <code>String</code> : Mensagem informando que o preço do insumo não foi informado.
	 */
	public static String ERR_PRECO_INSUMO = "O preço do insumo precisa ser informado";
	
	/**
	 * <code>String</code> : Mensagem informando que nenhum insumo não foi cadastrado.
	 */
	public static String ERR_NAO_CAD_INSUMO = "Nenhum insumo cadastrado";
	
	/**
	 * <code>String</code> : Mensagem informando a alteração do preco.
	 */
	public static String ALTERA_PRECO = "Preço alterado com sucesso";
	
	/**
	 * <code>String</code> : Titulo para tela de alteração do preco.
	 */
	public static String ALTERACAO = "Alterar preço";
	
	/**
	 * <code>String</code> : Mensagem informando erro na alteração do preco.
	 */
	public static String ERR_ALTERA_PRECO = "Erro ao alterar o preço";
	
	/**
	 * Expressão regular para validação de data
	 * dia pode ter valores entre 01 e 31, meses podem ser de 01 a 12, e anos de 1900 a 2099.
	 */
	public static String EXP_DATA = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}";
	
	/**
	 * <code>String</code> : Expressão regular para validar hora
	 */
	public static String EXP_HORA = "[0-2][0-3]:[0-5][0-9]:[0-5][0-9]";
	
	/**
	 * <code>String</code> : Mensagem de erro para informar a falta de insumos.
	 */
	public static String ERR_QTD_INSUMO_PROD = "Não existem insumos o suficiente para essa produção";
	
	/**
	 * <code>String</code> : Expressão regular para validar data
	 */
	public static String VALOR_DEFAULT_COMBOBOX = "Selecione uma opção";
	
	/**
	 * <code>String</code> : Mensagem de erro para informar a unidade de medida inválida.
	 */
	public static String ERR_UNIDADE_MEDIDA = "Unidade de Medida inválida";
	
	/**
	 * <code>String</code> : Mensagem de erro para informar a unidade de medida inválida.
	 */
	public static String ERR_CAD_UNIDADE_MEDIDA = "Erro ao cadastrar tamanho da unidade!";
	
	/**
	 * <code>String</code> : Mensagem de erro para informar que a quantidade é insuficiente.
	 */
	public static String ERR_QTDE_MAXIMA = "Quantidade produzida insuficiente!";
	
	/**
	 * <code>String</code> : Mensagem informando sucesso ao cadastrar venda.
	 */
	public static String CAD_VENDA = "Venda cadastrada com sucesso";
	
	
	/**
	 * <code>String</code> : Mensagem informando sucesso ao cadastrar venda.
	 */
	public static String QTDE_VENDA_NULA = "A Venda deve conter pelo menos 1 quantidade";
	
	/**
	 *<code>String</code> :  Mensagem informando o cadastro de Venda.
	 */
	public static String VENDA = "Venda de produtos";
	
	/**
	 * <code>String</code> : Mensagem informando erro ao cadastrar venda.
	 */
	public static String ERR_CAD_VENDA = "Não foi possível registrar a venda";
	
	public static String ERR_DATA_HORA_INVALIDA = "Data inválida ou Hora Inválida!\n"
			+ "Forneça uma data no formato:dd/MM/yyyy ou Hora no formato HH:mm:ss";
	
	
	public static String RELATORIO_VENDA = "Relatório de Vendas";
	
	public static String ERR_RELATORIO_VENDA = "Nenhuma venda realizada nesse período!";
	
	public static String VALOR_DEFAULT_CB_ORCAMENTO = "Selecione um mês:";
}
