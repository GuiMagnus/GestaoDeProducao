package br.com.fabrica.arquivo.aleatorio;

import java.io.IOException;


import br.com.fabrica.modelo.Insumo;



/**
 * Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Insumo</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoInsumo extends BinaryFile{


	/**
	 * Obtém o tamanho do registro que é de 112 bytes, pois são:
	 *
	 * 100 bytes do nome do insumo com 50 caracteres (2 bytes de cada carácter UNICODE);
	 *  4 bytes do código do insumo;
	 *  4 bytes do código do produto a que ele pertence
	 *  4 bytes da quantidade a ser usada do insumo no produto a que ele pertence.
	 *	4 bytes do preço do insumo
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 116;
	}



	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que será armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
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

	// Versão sobrecarregada (overload) de writeObject.
	public void writeObject(Insumo insumo) throws IOException {
		Object object = insumo;
		writeObject(object);
	}


	/**
	 * Lê o objeto como um registro do arquivo.
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
