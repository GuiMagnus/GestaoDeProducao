package br.com.fabrica.arquivos;

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
	 *4 bytes para o valor total de cada venda
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		// TODO Auto-generated method stub
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
		Venda venda = new Venda();
		if(objeto instanceof Venda)
			venda = (Venda) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(venda.getCodigo());
		for(Produto produto : venda.getProdutos()) {
			randomAccessFile.writeChars(setStringLength(produto.getNome(), 50));
			randomAccessFile.writeInt(produto.getQuantidadeProduto());
			randomAccessFile.writeFloat(produto.getPrecoFabricacao());
		}
		
		
	}

	// Versão sobrecarregada (overload) de writeObject.
		public void writeObject(Venda venda) throws IOException {
			Object object = venda;
			writeObject(object);
		}
	
	@Override
	public Object readObject() throws IOException {
		Venda venda = new Venda();
		venda.setCodigo(randomAccessFile.readInt());
		
		List<Produto> produtos = new ArrayList<Produto>();
		for(Produto produto : produtos) {
			produto.setNome(readString(50));
			produto.setQuantidadeProduto(randomAccessFile.readInt());
			produto.setPrecoVenda(randomAccessFile.readFloat());
			
			produtos.add(produto);
		}
		
		venda.setProdutos(produtos);

		return venda;
	}

}
