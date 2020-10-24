package br.com.fabrica.arquivo.aleatorio;

import java.io.IOException;


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

		randomAccessFile.writeInt(insumo.codigo);
		randomAccessFile.writeInt(insumo.getCodigoProduto());
		randomAccessFile.writeChars(setStringLength(insumo.getNome(), 50));
		randomAccessFile.writeInt(insumo.getQuantidade());
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

		insumo.setAuxiliarCodigo(randomAccessFile.readInt());
		insumo.setCodigoProduto(randomAccessFile.readInt());
		insumo.setNome(readString(50));
		insumo.setQuantidade(randomAccessFile.readInt());
		insumo.setPrecoUnitario(randomAccessFile.readFloat());

		return insumo;
	}

}
