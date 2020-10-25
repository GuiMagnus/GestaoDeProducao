package br.com.fabrica.arquivos;

import java.io.IOException;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;


/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Venda</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoVenda extends BinaryFile {
	
	
	/**
	 * Obt�m o tamanho do registro que � de bytes, pois s�o:
	 * 4 bytes do c�digo da venda.
	 *20 bytes da data da venda do produto Produto com 10 caracteres (2 bytes de cada car�cter UNICODE).
	 *18 bytes da hora da venda do produto Produto com 9 caracteres (2 bytes de cada car�cter UNICODE).
	 *100 bytes para o nome do produto vendido.
	 *4 bytes para a quantidade desse produto vendido.
	 *4 bytes para o pre�o unit�rio do produto.
	 *4 bytes para o valor total de cada venda
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		// TODO Auto-generated method stub
		return 154;
	}

	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>Venda</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Venda venda = new Venda();
		if(objeto instanceof Venda)
			venda = (Venda) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(venda.getCodigo());
		randomAccessFile.writeChars(setStringLength(venda.getData(), 10));
		randomAccessFile.writeChars(setStringLength(venda.getHora(), 9));
		randomAccessFile.writeChars(setStringLength(venda.getProduto().getNome(), 50));
		randomAccessFile.writeInt(venda.getProduto().getQuantidadeProduto());
		randomAccessFile.writeFloat(venda.getProduto().getPrecoFabricacao());
		randomAccessFile.writeFloat(venda.valorTotalVendaPorProduto());
	}

	// Vers�o sobrecarregada (overload) de writeObject.
		public void writeObject(Venda venda) throws IOException {
			Object object = venda;
			writeObject(object);
		}
	
	@Override
	public Object readObject() throws IOException {
		Venda venda = new Venda();
		venda.setCodigo(randomAccessFile.readInt());
		venda.setData(readString(10));
		venda.setHora(readString(9));
		
		Produto produto = new Produto();
		produto.setNome(readString(50));
		produto.setQuantidadeProduto(randomAccessFile.readInt());
		venda.setProduto(produto);

		return venda;
	}

}
