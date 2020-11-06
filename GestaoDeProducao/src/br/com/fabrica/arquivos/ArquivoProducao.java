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
 * @see tsi.too.arquivo.binario.BinaryFile
 * @see tsi.too.arquivo.binario.Produto
 *
 * @author Guilherme Magnus
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
	  * @param obj um <code>Object</code> que ser� armazenado no arquivo.
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
		
		randomAccessFile.writeInt(obtemCodigoProducao());
		randomAccessFile.writeChars(setStringLength(producao.getProduto().getNome(),50));
		randomAccessFile.writeInt(producao.getProduto().getQuantidade());
		randomAccessFile.writeChars(setStringLength(producao.getData().toString(), 10));
		randomAccessFile.writeFloat(producao.getCustoProducao());
	}

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
		Data data = new Data(readString(10));
		producao.setData(data);
		producao.setCustoProducao(randomAccessFile.readFloat());
		return producao;
	}
	
	/**
	 * Recebe um Objeto com dados de uma produ��o referente a classe {@link Producao} a serem gravados
	 * no arquivo de producao.
	 * @param producao Um objeto producao a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public boolean escreveProducaoNoArquivo(Producao producao) {
		try {
			openFile(ARQ_PRODUCAO);
			setFilePointer(recordQuantity());
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
	
	/**
	 * Obt�m uma produ��o que foi cadastrada.
	 * @param indice <code>int</code> referencia ao produto que ser� obtido
	 * @return informa��es referentes a produ��o.
	 */
	public Producao leProducaoNoArquivo(int indice) {
		try {
			openFile(ARQ_PRODUCAO);
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
	 * @return retorna o c�digo sequencial para o pr�ximo dado de hist�rico
	 */
	public int obtemCodigoProducao() {
		try {
			if(recordQuantity() == 0)
				return 1;
			else {
				return (int) (recordQuantity() + 1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Obt�m a produ��o de um determinado produto.
	 * @param codigo <code>int</code> c�digo referente a produ��o
	 * @return <code>Producao</code> dados da produ��o procurada. 
	 */
	public Producao obterProducao(int codigo) {
		Producao producao = null;
		try {
			openFile(ARQ_PRODUCAO);
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
	 * @param codigo <code>int</code> c�digo referente a produ��o
	 * @return <code>List</code> lista de produ��es
	 */
	public List<Producao> leProducoesNoArquivo() {
		List<Producao> listaProducao = new ArrayList<>();
		try {
			openFile(ARQ_PRODUCAO);
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
	 * @param prod <code>Producao</code> produ��o a ser alterada.
	 * @return <code>Producao</code> produ��o alterada.
	 */
	public Producao alteraProducao(Producao prod) {
		Producao producao = null;
		try {
			openFile(ARQ_PRODUCAO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				
				if(producao.getCodigo() == prod.getCodigo()) {
					producao = prod;
					//produto.setTamanhoUnidade(prod.getTamanhoUnidade());
					escreveProducaoPorPosicao(producao, i);
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
	 * Escreve uma produ��o em uma determinada posi��o.
	 * @param producao <code>Producao</code> producao a ser cadastrada.
	 * @param posicao <code>int</code> posi��o que ser� escrito a produ��o
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveProducaoPorPosicao(Producao producao, int posicao) {
		try {
			openFile(ARQ_PRODUCAO);
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
