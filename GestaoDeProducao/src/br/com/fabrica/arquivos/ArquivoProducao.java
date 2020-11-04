package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_PRODUCAO;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;


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
	 *4 bytes da quantidade;
	 *20 bytes da data de produ��o
	 *4 bytes custo produ��o
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 132;
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
		randomAccessFile.writeInt(producao.getProduto().getQuantidadeProduto());
		randomAccessFile.writeChars(setStringLength(producao.getData(), 10));
		randomAccessFile.writeFloat(producao.getCustoProducao());
	}

	public void writeObject(Producao producao) throws IOException {
		/* Solu��o 1: n�o usa o cast, usa o relacionamento "� um" entre o objeto de subclasse Produto e o objeto de 
		 * 					superclasse Object para invocar o m�todo writeObject que recebe um Object.
		 */                  
		Object object = producao;
		writeObject(object);
		
		/* Solu��o 2: usa o cast que � desnecess�rio por causa do relacionamento "� um" entre o objeto
		 *                  de subclasse Produto e o objeto de superclasse Object para invocar o m�todo writeObject
		 *                  que recebe um Object. O cast s� � necess�rio para evitar a recurs�o e chamar a 
		 *                  vers�o sobrecarregada de writeObject que recebe um Object.   
		 *                  
		 *                   writeObject((Object) produto);
		 */
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
		produto.setQuantidadeProduto(randomAccessFile.readInt());
		
		producao.setProduto(produto);
		producao.setData(readString(10));
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
	
	public Producao leProdutoNoArquivo(int indice) {
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
	
}
