package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_VENDA_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.Venda;


/**
 *  Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Venda</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoVendaProduto extends BinaryFile {


	/**
	 * Obtém o tamanho do registro que é de bytes, pois são:
	 * 4 bytes do código da venda.
	 *100 bytes para o nome do produto vendido.
	 *4 bytes para a quantidade desse produto vendido.
	 *4 bytes para o preço unitário do produto.
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
	 * @param obj um <code>Object</code> que será armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
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


	}

	// Versão sobrecarregada (overload) de writeObject.
	public void writeObject(Venda venda) throws IOException {
		Object object = venda;
		writeObject(object);
	}

	/**
	 * Lê o código de uma venda a partir do arquivo de vendas
	 * e adiciona em uma lista referente a classe {@link Venda} todos os produtos que foram vendidos
	 * a partir daquele código de venda. 
	 * @return Object Retorna um objeto contendo os atributos de venda incluindo seus produtos vendidos. 
	 */
	@Override
	public Object readObject() throws IOException {
		Venda venda = new Venda();
		venda.setCodigo(randomAccessFile.readInt());

		List<Produto> produtos = new ArrayList<Produto>();
		for(Produto produto : produtos) {
			produto.setNome(readString(50));
			produto.setQuantidade(randomAccessFile.readInt());
			produto.setPrecoVenda(randomAccessFile.readFloat());

			produtos.add(produto);
		}

		venda.setProdutos(produtos);

		return venda;
	}
	/***
	 * Obtém o código sequencial das vendas gravado no arquivo de vendas
	 * @return retorna o código sequencial para o próximo dado de registros das vendas.
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
	 * @return Retorna True ou False indicando se a gravação obteve sucesso ou falha.
	 */
	public boolean gravaProdutosVendidos(Venda venda) {
		try {
			openFile(ARQ_VENDA_PRODUTO);
			setFilePointer(recordQuantity());
			for(Produto produto : venda.getProdutos())
				writeObject(produto);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
