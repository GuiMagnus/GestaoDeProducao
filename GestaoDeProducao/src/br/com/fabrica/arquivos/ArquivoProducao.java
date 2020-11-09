package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_PRODUCAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Data;


/**
 * Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Produ��o</code>.
 *
 * @see BinaryFile
 * @see Produto
 *
 * @author Guilherme Magnus e Rafaela
 */

public class ArquivoProducao extends BinaryFile{
	/**
	 * Obt�m o tamanho do registro que � de 128 bytes, pois s�o:
	 *4 bytes do codigo da produ��o.
	 *100 bytes do nome do produto com 50 caracteres (2 bytes de cada car�cter UNICODE);
	 *20 bytes da data de produ��o
	 *4 bytes custo produ��o
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 128;
	}

	
	
	/**
	  * Escreve o objeto como um registro do arquivo.
	  *
	  * @param objeto um <code>Object</code> que ser� armazenado no arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S;
	  * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	  * <code>Producao</code>.
	  **/
	@Override
	public void writeObject(Object objeto) throws IOException {
		Producao producao = new Producao();
		if(objeto instanceof Producao)
			producao = (Producao) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(producao.getCodigo());
		randomAccessFile.writeChars(setStringLength(producao.getProduto().getNome(),50));
		randomAccessFile.writeInt(producao.getProduto().getQuantidade());
		randomAccessFile.writeFloat(producao.getCustoProducao());
		randomAccessFile.writeChars(setStringLength(producao.getData().toString(), 10));
		
	}

	/**
	 * Escreve um objeto com os dados de uma produ��o no arquivo
	 * @param producao <code>Producao</code> que ser� escrita
	 * @throws IOException Erro relacionado a entrada e sa�da de dados.
	 */
	public void writeObject(Producao producao) throws IOException {               
		Object object = producao;
		writeObject(object);
	}

	/**
	  * L� o objeto como um registro do arquivo.
	  *
	  * @return um <code>Produ��o</code> com os atributos do objeto lido do arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S.
	  **/
	@Override
	public Object readObject() throws IOException {
		Producao producao = new Producao();
		
		producao.setCodigo(randomAccessFile.readInt());
		Produto produto = new Produto();
		produto.setNome(readString(50));
		produto.setQuantidade(randomAccessFile.readInt());
		producao.setProduto(produto);
		producao.setCustoProducao(randomAccessFile.readFloat());
		Data data = new Data(readString(10));
		producao.setData(data);
		
		return producao;
	}
	
	/**
	 * Recebe um Objeto com dados de uma produ��o referente a classe {@link Producao} a serem gravados
	 * no arquivo de producao.
	 * @param arquivo uma String contendo o nome do arquivo onde ser�o gravados os dados.
	 * @param producao Um objeto producao a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public Producao escreveProducaoNoArquivo(Producao producao, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(recordQuantity());
			writeObject(producao);
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Obt�m uma produ��o que foi cadastrada.
	 * @param indice <code>int</code> referencia ao produto que ser� obtido
	 * @param arquivo<code>String</code>nome do arquivo onde ser�o obtidos os dados.
	 * @return informa��es referentes a produ��o.
	 */
	public Producao leProducaoNoArquivo(int indice, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(indice);
			Producao producao = (Producao) readObject();
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * Obt�m o c�digo sequencial para a produ��o
	 * @param arquivo Arquivo de onde ser� obtido o c�digo
	 * @return retorna o c�digo sequencial para o pr�ximo dado de hist�rico
	 */
	public int obtemCodigoProducao(String arquivo) {
		int codigo = 0;
		try {
			openFile(arquivo);
			if(recordQuantity() == 0)
				codigo = 1;
			else {
				codigo = (int) (recordQuantity() + 1);
			}
			closeFile();
			return codigo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return codigo;
		} catch (IOException e) {
			e.printStackTrace();
			return codigo;
		}
	}
	
	/**
	 * Obt�m a produ��o de um determinado produto.
	 * @param codigo <code>int</code> c�digo referente a produ��o
	 * @param arquivo<code>String</code> nome do arquivo de onde ser� obtida a produ��o
	 * @return <code>Producao</code> dados da produ��o procurada. 
	 */
	public Producao obterProducao(int codigo, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			for (int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(producao.getCodigo() == codigo)
					break;
			}
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Obt�m as produ��es cadastradas.
	 * @param arquivo Arquivo de onde ir� obter as informa��es. 
	 * @return <code>List</code> lista de produ��es
	 */
	public List<Producao> leProducoesNoArquivo(String arquivo) {
		List<Producao> listaProducao = new ArrayList<>();
		try {
			openFile(arquivo);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Producao producao = (Producao) readObject();
				listaProducao.add(producao);
			}
			closeFile();
			return listaProducao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Altera as informa��es de uma produ��o cadastrada.
	 * @param arquivo <code>String</code> nome do arquivo de onde ser�o alterados os dados de produ��o
	 * @param prod <code>Producao</code> produ��o a ser alterada.
	 * @return <code>Producao</code> produ��o alterada.
	 */
	public Producao alteraProducao(Producao prod, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(producao.getProduto().getNome().equalsIgnoreCase(prod.getProduto().getNome())) {
					producao.getProduto().setQuantidade(prod.getProduto().getQuantidade());
					escreveProducaoPorPosicao(producao, i, ARQ_PRODUCAO);
					break;
				}
			}
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return producao;
		} catch (IOException e) {
			e.printStackTrace();
			return producao;
		}
	}
	
	/**
	 * Altera as informa��es de uma produ��o cadastrada.
	 * @param prod <code>Producao</code> produ��o a ser alterada.
	 * @param arquivo <code>String</code> nome do arquivo de onde ser� alterada a quantidade da produ��o
	 * @return <code>Producao</code> produ��o alterada.
	 */
	public Producao alteraQuantidadeProducao(Producao prod, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(!producao.getProduto().getNome().equalsIgnoreCase(prod.getProduto().getNome())) {
					System.out.println("No if");
					continue;
				}else {
					producao.getProduto().setQuantidade(producao.getProduto().getQuantidade() + 
							prod.getProduto().getQuantidade());
					escreveProducaoPorPosicao(producao, i, arquivo);
					closeFile();
					return producao;
				}
			}
			closeFile();
			return escreveProducaoNoArquivo(prod, arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null	;
		}
	}
	
	/**
	 * Escreve uma produ��o em uma determinada posi��o.
	 * @param producao <code>Producao</code> producao a ser cadastrada.
	 * @param posicao <code>int</code> posi��o que ser� escrito a produ��o
	 * @param arquivo <code>String</code> nome do arquivo de onde ser� escrito os dados de produ��o
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveProducaoPorPosicao(Producao producao, int posicao, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(posicao);
			writeObject(producao);
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
}
