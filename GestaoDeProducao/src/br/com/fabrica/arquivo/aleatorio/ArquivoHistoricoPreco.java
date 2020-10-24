package br.com.fabrica.arquivo.aleatorio;

import java.io.IOException;

import br.com.fabrica.modelo.HistoricoPreco;


/**
 *  Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>HistoricoPreco</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoHistoricoPreco extends BinaryFile{
	
	/**
	 * Obtém o tamanho do registro que é de 32 bytes, pois são:
	 *
	 * 20 bytes da data de alteração do preço do produto ou insumo (2 bytes de cada carácter UNICODE);
	 *  4 bytes do código do insumo ou produto;
	 *  4 bytes do código de cada objeto criado para o Histórico de preço
	 *	4 bytes do preço do insumo ou produto
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 32;
	}

	
	/**
	 * Escreve o objeto como um registro do arquivo.
	  *
	  * @param obj um <code>Object</code> que será armazenado no arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S;
	  * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
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

	// Versão sobrecarregada (overload) de writeObject.
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
