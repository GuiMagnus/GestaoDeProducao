package br.com.fabrica.arquivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import static br.com.fabrica.constantes.Constantes.*;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;

/**
 *  Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Venda</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoVenda extends BinaryFile {
	
	
	/**
	 * Obtém o tamanho do registro que é de bytes, pois são:
	 * 4 bytes do código da venda.
	 *20 bytes da data da venda do produto Produto com 10 caracteres (2 bytes de cada carácter UNICODE).
	 *18 bytes da hora da venda do produto Produto com 9 caracteres (2 bytes de cada carácter UNICODE).
	 *100 bytes para o nome do produto vendido.
	 *4 bytes para a quantidade desse produto vendido.
	 *4 bytes para o preço unitário do produto.
	 *4 bytes para o valor total de cada venda
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 154;
	}

	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que será armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
	 * <code>Venda</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Venda venda = new Venda();
		if(objeto instanceof Venda)
			venda = (Venda) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(obtemCodigoVenda());
		randomAccessFile.writeChars(setStringLength(venda.getData(), 10));
		randomAccessFile.writeChars(setStringLength(venda.getHora(), 9));
		randomAccessFile.writeFloat(venda.valorTotalVendaPorProduto());
	}

		/**
		 * Versão sobrecarregada (overload) de writeObject.
		 * @param venda
		 * @throws IOException
		 */
		public void writeObject(Venda venda) throws IOException {
			Object object = venda;
			writeObject(object);
		}
	
	/**
	 * Lê um registro do arquivo de Vendas realizadas referente a classe {@link Venda}
	 * e o retorna 
	 *@return Object Um objeto com os dados referente a uma venda de um produto.
	 */
	@Override
	public Object readObject() throws IOException {
		Venda venda = new Venda();
		venda.setCodigo(randomAccessFile.readInt());
		venda.setData(readString(10));
		venda.setHora(readString(9));
		
		Produto produto = new Produto();
		produto.setNome(readString(50));
		produto.setQuantidadeProduto(randomAccessFile.readInt());

		return venda;
	}
	
	/***
	 * Obtém o código sequencial das vendas gravado no arquivo de vendas
	 * @return retorna o código sequencial para o próximo dado de registros das vendas.
	 */
	public int obtemCodigoVenda() {
		try {
			openFile(ARQ_VENDA);
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
