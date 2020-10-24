package br.com.fabrica.arquivo.aleatorio;

import java.io.IOException;

import br.com.fabrica.modelo.HistoricoPreco;


/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>HistoricoPreco</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoHistoricoPreco extends BinaryFile{
	
	/**
	 * Obt�m o tamanho do registro que � de 32 bytes, pois s�o:
	 *
	 * 20 bytes da data de altera��o do pre�o do produto ou insumo (2 bytes de cada car�cter UNICODE);
	 *  4 bytes do c�digo do insumo ou produto;
	 *  4 bytes do c�digo de cada objeto criado para o Hist�rico de pre�o
	 *	4 bytes do pre�o do insumo ou produto
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 32;
	}

	
	/**
	 * Escreve o objeto como um registro do arquivo.
	  *
	  * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S;
	  * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	  * <code>HistoricoPreco</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		HistoricoPreco historicoPreco = new HistoricoPreco();
		if(objeto instanceof HistoricoPreco)
			historicoPreco = (HistoricoPreco) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(historicoPreco.codigo);
		randomAccessFile.writeInt(historicoPreco.getCodigoReferenciaDeDado());
		randomAccessFile.writeFloat(historicoPreco.getPreco());
		randomAccessFile.writeChars(setStringLength(historicoPreco.getData(), 10));
		
	}

	// Vers�o sobrecarregada (overload) de writeObject.
		public void writeObject(HistoricoPreco historicoPreco) throws IOException {
			Object object = historicoPreco;
			writeObject(object);
		}
	
	@Override
	public Object readObject() throws IOException {
		HistoricoPreco historicoPreco = new HistoricoPreco();
		
		historicoPreco.setAuxiliarCodigo(randomAccessFile.readInt());
		historicoPreco.setCodigoReferenciaDeDado(randomAccessFile.readInt());
		historicoPreco.setPreco(randomAccessFile.readFloat());
		historicoPreco.setData(readString(10));
		return historicoPreco;
	}

}
