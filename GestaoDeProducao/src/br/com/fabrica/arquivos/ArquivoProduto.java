package br.com.fabrica.arquivos;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;

import static br.com.fabrica.strings.Constantes.*;

/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Produto</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoProduto extends BinaryFile{

	/**
	 * Obt�m o tamanho do registro que � de 120 bytes, pois s�o:
	 * 4 bytes do c�digo do produto
	 *100 bytes do nome do Produto com 50 caracteres (2 bytes de cada car�cter UNICODE)
	 *4 bytes para a unidade de medida(quilograma, grama, litro, mililitro)
	 *4 bytes para a margem de Lucro
	 *4 bytes para o pre�o da venda
	 *4 bytes da quantidade do produto
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 120;
	}


	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
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
		//openFile("..\\GestaoDeProducao\\arquivos\\produto.dat");
		randomAccessFile.writeChars("");
		randomAccessFile.writeInt(produto.codigo);
		randomAccessFile.writeChars(setStringLength(produto.getUnidadeMedida().getUnidade(), 2));
		randomAccessFile.writeFloat(produto.getMargemLucro());
		randomAccessFile.writeFloat(produto.getPrecoVenda());
		randomAccessFile.writeInt(produto.getQuantidadeProduto());
		

	}


	// Vers�o sobrecarregada (overload) de writeObject.
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

		produto.setNome(readString(50));
		produto.setAuxiliarCodigo(randomAccessFile.readInt());
		String tipoProduto = readString(2);		
		produto.setUnidadeMedida(verificaMedida(tipoProduto));
		produto.setMargemLucro(randomAccessFile.readFloat());
		produto.setPrecoVenda(randomAccessFile.readFloat());
		produto.setQuantidadeProduto(randomAccessFile.readInt());
		return produto;
	}
	/**
	 * Verifica a medida que est� armazenada na vari�vel passada como par�metro com os valores da enum UnidadeMedida e 
	 * caso contenha, retorna esse valor. 
	 * 
	 * @param medida valor a ser comparado com o atributo da enum para verifica��o de que tipo de medida est� sendo usado(kg,g,ml,l)
	 * @return retorna o tipo da medida ou um valor nulo.
	 */
	public UnidadeMedida verificaMedida(String medida) {
		for ( UnidadeMedida dado : UnidadeMedida.values()) {
			if(dado.getUnidade().equalsIgnoreCase(medida))
				return dado;
		}
		return null;
	}
	
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
}