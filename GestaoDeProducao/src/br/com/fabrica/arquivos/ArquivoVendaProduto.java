package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_VENDA_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;


/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Venda</code>.
 * @author Guilherme Magnus e Rafaela
 *
 */
public class ArquivoVendaProduto extends BinaryFile {


	/**
	 * Obt�m o tamanho do registro que � de bytes, pois s�o:
	 * 4 bytes do c�digo da venda.
	 *100 bytes para o nome do produto vendido.
	 *4 bytes para a quantidade desse produto vendido.
	 *4 bytes para o pre�o unit�rio do produto.
	 *4 bytes para o valor total de cada item da venda
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 116;
	}

	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param objeto um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>Venda</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Produto produto = new Produto();
		if(objeto instanceof Produto)
			produto = (Produto) objeto;
		else
			throw new ClassCastException();

		randomAccessFile.writeInt(produto.getCodigo());
		randomAccessFile.writeChars(setStringLength(produto.getNome(), 50));
		randomAccessFile.writeInt(produto.getQuantidade());
		randomAccessFile.writeFloat(produto.getPrecoFabricacao());
		randomAccessFile.writeFloat(produto.getPrecoVenda());
	}

	// Vers�o sobrecarregada (overload) de writeObject.
	public void writeObject(Venda venda) throws IOException {
		Object object = venda;
		writeObject(object);
	}

	/**
	 * L� um dado do arquivo de produtos vendidos.
	 * 
	 * @return Object Retorna um objeto contendo os seus produtos vendidos. 
	 */
	@Override
	public Object readObject() throws IOException {

		Produto produto = new Produto();
		produto.setCodigo(randomAccessFile.readInt());
		produto.setNome(readString(50));
		produto.setQuantidade(randomAccessFile.readInt());
		produto.setPrecoFabricacao(randomAccessFile.readFloat());
		produto.setPrecoVenda(randomAccessFile.readFloat());

		return produto;
	}


	/***
	 * Obt�m o c�digo sequencial das vendas gravado no arquivo de vendas
	 * @return retorna o c�digo sequencial para o pr�ximo dado de registros das vendas.
	 */
	public int obtemCodigoVenda() {
		try {
			openFile(ARQ_VENDA_PRODUTO);
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
	 * Grava os produtos que foram vendidos em determinada venda
	 * @param venda <code>Venda</code> venda a ser registrada.
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public boolean gravaProdutosVendidos(Venda venda) {
		try {
			openFile(ARQ_VENDA_PRODUTO);
			setFilePointer(recordQuantity());
			for(Produto produto : venda.getProdutos())
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
	
	/**
	 * Obt�m os produtos que foram vendidos.
	 * @param vendas Lista que cont�m os produtos que foram vendidos
	 * @return os produtos vendidos de uma determinada venda.
	 */
	public List<Produto> produtosVendidos(List<Venda> vendas){
		List<Produto> produtosVendidos = new ArrayList<Produto>();
		try {
			for (Venda venda : vendas) {

				openFile(ARQ_VENDA_PRODUTO);
				setFilePointer(0);
				for (int i = 0; i < recordQuantity(); i++) {
					Produto produto = (Produto) readObject();
					if(venda.getCodigo() == produto.getCodigo())
						produtosVendidos.add(produto);
				}
				closeFile();
			}
			return produtosVendidos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
