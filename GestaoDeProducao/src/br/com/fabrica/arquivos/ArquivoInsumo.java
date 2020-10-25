package br.com.fabrica.arquivos;

import static br.com.fabrica.strings.Constantes.ARQ_INSUMO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.fabrica.modelo.Insumo;



/**
 * Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Insumo</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoInsumo extends BinaryFile{


	/**
	 * Obt�m o tamanho do registro que � de 112 bytes, pois s�o:
	 *
	 * 100 bytes do nome do insumo com 50 caracteres (2 bytes de cada car�cter UNICODE);
	 *  4 bytes do c�digo do insumo;
	 *  4 bytes do c�digo do produto a que ele pertence
	 *  4 bytes da quantidade a ser usada do insumo no produto a que ele pertence.
	 *	4 bytes do pre�o do insumo
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 116;
	}



	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>Insumo</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Insumo insumo = new Insumo();

		if(objeto instanceof Insumo) 
			insumo = (Insumo) objeto;
		else
			throw new ClassCastException();

		randomAccessFile.writeInt(obtemCodigoInsumo());
		randomAccessFile.writeInt(insumo.getCodigoProduto());
		randomAccessFile.writeChars(setStringLength(insumo.getNome(), 50));
		randomAccessFile.writeFloat(insumo.getQuantidade());
		randomAccessFile.writeFloat(insumo.getPrecoUnitario());
	}

	// Vers�o sobrecarregada (overload) de writeObject.
	public void writeObject(Insumo insumo) throws IOException {
		Object object = insumo;
		writeObject(object);
	}


	/**
	 * L� o objeto como um registro do arquivo.
	 *
	 * @return um <code>Insumo</code> com os atributos do objeto lido do arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S.
	 **/
	@Override
	public Object readObject() throws IOException {
		Insumo insumo = new Insumo();

		insumo.setCodigo(randomAccessFile.readInt());
		insumo.setCodigoProduto(randomAccessFile.readInt());
		insumo.setNome(readString(50));
		insumo.setQuantidade(randomAccessFile.readInt());
		insumo.setPrecoUnitario(randomAccessFile.readFloat());

		return insumo;
	}
	
	/**
	 * Recebe um Objeto com dados de um insumo referente a classe {@link Insumo} a serem gravados
	 * no arquivo de Insumos.
	 * @param insumo Um objeto insumo a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public boolean escreveInsumoNoArquivo(Insumo insumo) {
		try {
			openFile(ARQ_INSUMO);
			setFilePointer(recordQuantity());
			writeObject(insumo);
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
	 * Recebe uma lista de insumos de determinado produto e escreve os registros
	 * no arquivo de insumos. 
	 * @param insumos Uma lista com dados referente a classe {@link Insumo} para serem gravados 
	 * no arquivo de insumos.
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveInsumosNoArquivo(List<Insumo> insumos) {
		try {
			openFile(ARQ_INSUMO);
			setFilePointer(recordQuantity());
			for(Insumo insumo : insumos)
				writeObject(insumo);
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
	
	
	
	/***
	 * Obt�m o c�digo sequencial dos insumos a partir do n�mero de registro no arquivo de insumos
	 * caso esteja vazio este ser� o primeiro produto a ser gravado no arquivo.
	 * @return retorna o c�digo sequencial para o pr�ximo dado do registro de produtos.
	 */
	public int obtemCodigoInsumo() {
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
