package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Produto</code>.
 * @author Guilherme Magnus e Rafaela.
 *
 */
public class ArquivoProduto extends BinaryFile{

	/**
	 * Obt�m o tamanho do registro que � de 124 bytes, pois s�o:
	 * 4 bytes do c�digo do produto
	 *100 bytes do nome do Produto com 50 caracteres (2 bytes de cada car�cter UNICODE)
	 *4 bytes para a unidade de medida(quilograma, grama, litro, mililitro)
	 *4 bytes para a margem de Lucro
	 *4 bytes para o pre�o da venda
	 *4 bytes da quantidade do produto
	 *4 bytes do tamanho da unidade
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 124;
	}


	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param objeto um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>Produto</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Produto produto;
		if(objeto instanceof Produto) {
			produto = (Produto) objeto;
		}
		else
			throw new ClassCastException();
		randomAccessFile.writeInt(produto.getCodigo());
		randomAccessFile.writeChars(setStringLength(produto.getNome(), 50));
		randomAccessFile.writeChars(setStringLength(produto.getUnidadeMedida().getUnidade(), 2));
		randomAccessFile.writeFloat(produto.getMargemLucro());
		randomAccessFile.writeFloat(produto.getPrecoVenda());
		randomAccessFile.writeInt(produto.getQuantidade());
		randomAccessFile.writeFloat(produto.getTamanhoUnidade());

	}


	/**
	 * Escreve no arquivo os dados de um produto.
	 * @param produto objeto de onde ser�o armazenadas as informa��es.
	 * @throws IOException Erro relacionado a entrada e sa�da de dados.
	 */
	public void writeObject(Produto produto) throws IOException {
		Object object = produto;
		writeObject(object);
	}

	/**
	 * L� o objeto como um registro do arquivo.
	 *
	 * @return um <code>Produto</code> com os atributos do objeto lido do arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S.
	 **/
	@Override
	public Object readObject() throws IOException {
		Produto produto = new Produto();

		produto.setCodigo(randomAccessFile.readInt());
		produto.setNome(readString(50));
		String tipoProduto = readString(2);		
		produto.setUnidadeMedida(Validacoes.verificaMedida(tipoProduto));
		produto.setMargemLucro(randomAccessFile.readFloat());
		produto.setPrecoVenda(randomAccessFile.readFloat());
		produto.setQuantidade(randomAccessFile.readInt());
		produto.setTamanhoUnidade(randomAccessFile.readFloat());
		return produto;
	}
	
	/**
	 * Grava as informa��es dos produtos referente a classe {@link Produto}
	 * no arquivo de acesso aleat�rio dos produtos.
	 * @param produto Cont�m as informa��es de determinado produto que ser�o gravadas no arquivo.
	 * @return Retorna true ou false indicando se foi poss�vel escrever no arquivo.
	 */
	public boolean escreveProdutoNoArquivo(Produto produto) {
		try {
			openFile(ARQ_PRODUTO);
			setFilePointer(recordQuantity());
			
			writeObject(produto);
			
			closeFile();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false; 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Percorre o arquivo de produtos e l� um dado gravado no arquivo 
	 * indicado pela vari�vel indice. Caso encontre retorna um objeto da classe {@link Produto}
	 * com os dados obtidos ou em falha retorna null.
	 * @param indice Vari�vel que indica o registro a ser obtido do arquivo.
	 * @return Retorna um objeto contendo os dados obtidos ou null caso o registro seja inv�lido
	 */
	public Produto leProdutoNoArquivo(int indice) {
		try {
			openFile(ARQ_PRODUTO);
			setFilePointer(indice);
			Produto produto = (Produto) readObject();
			closeFile();
			return produto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Percorre todo o arquivo de produtos adicionando cada registro a uma lista do tipo 
	 * da classe {@link Produto} e a retorna.
	 * 
	 * @return Retorna uma lista com todos os registros do arquivo de Produtos ou null caso
	 * o arquivo esteja vazio.
	 */
	public List<Produto> leProdutosNoArquivo() {
		List<Produto> listaProdutos = new ArrayList<>();
		try {
			openFile(ARQ_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Produto produto = (Produto) readObject();
				listaProdutos.add(produto);
			}
			closeFile();
			return listaProdutos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/***
	 * Obt�m o c�digo sequencial dos produtos a partir do n�mero de registro no arquivo de produtos
	 * caso esteja vazio este ser� o primeiro produto a ser gravado no arquivo.
	 * @return retorna o c�digo sequencial para o pr�ximo dado do registro de produtos.
	 */
	public int obtemCodigoProduto() {
		int codigo = 0;
		try {
			openFile(ARQ_PRODUTO);
			if(recordQuantity() == 0)
				codigo = 1;
			else {
				codigo = (int) (recordQuantity() + 1);
			}
			closeFile();
			return codigo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Escreve um produto em uma determinada posi��o.
	 * @param produto <code>Produto</code> produto a ser cadastrado.
	 * @param posicao <code>int</code> posi��o que ser� escrito o produto
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveProdutoNoArquivoPorPosicao(Produto produto, int posicao) {
		try {
			openFile(ARQ_PRODUTO);
			setFilePointer(posicao);
			System.out.println(produto);
			writeObject(produto);
			closeFile();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false; 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Altera as informa��es de um produto cadastrada.
	 * @param prod <code>Produto</code> produto a ser alterada.
	 * @return <code>Produto</code> produ��o alterada.
	 */
	public Produto alteraProduto(Produto prod) {
		Produto produto = null;
		try {
			openFile(ARQ_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				produto = (Produto) readObject();
				
				if(produto.getCodigo() == prod.getCodigo()) {
					
					produto.setTamanhoUnidade(prod.getTamanhoUnidade());
					escreveProdutoNoArquivoPorPosicao(produto, i);
					break;
				}
			}
			closeFile();
			return produto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return produto;
		} catch (IOException e) {
			e.printStackTrace();
			return produto;
		}
	}
	
	/**
	 * Obt�m o produto cadastrado.
	 * @param codigoProduto <code>int</code> c�digo referente ao produto
	 * @return <code>Produto</code> dados do produto procurado 
	 */
	public Produto obtemProduto(int codigoProduto) {
		Produto produto = null;
		try {
			openFile(ARQ_PRODUTO);
			
			for(int i = 0; i < recordQuantity(); i++) {
				
				setFilePointer(i);
				
				produto = (Produto) readObject();
				if(produto.getCodigo() == codigoProduto) {
					break;
				}
			}
			closeFile();
			return produto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return produto;
		} catch (IOException e) {
			e.printStackTrace();
			return produto;
		}
	}
}