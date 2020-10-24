package br.com.fabrica.arquivo.aleatorio;

import java.io.IOException;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.modelo.UnidadeMedida;

/**
 *  Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Produto</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoProduto extends BinaryFile{

	/**
	 * Obtém o tamanho do registro que é de 120 bytes, pois são:
	 * 4 bytes do código do produto
	 *100 bytes do nome do Produto com 50 caracteres (2 bytes de cada carácter UNICODE)
	 *4 bytes para a unidade de medida(quilograma, grama, litro, mililitro)
	 *4 bytes para a margem de Lucro
	 *4 bytes para o preço da venda
	 *4 bytes da quantidade do produto
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		// TODO Auto-generated method stub
		return 120;
	}


	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que será armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
	 * <code>Produto</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Produto produto = new Produto();

		if(objeto instanceof Produto) 
			produto = (Produto) objeto;
		else
			throw new ClassCastException();

		randomAccessFile.writeChars(setStringLength(produto.getNome(), 50));
		randomAccessFile.writeInt(produto.codigo);
		randomAccessFile.writeChars(setStringLength(produto.getUnidadeMedida().getUnidade(), 2));
		randomAccessFile.writeFloat(produto.getMargemLucro());
		randomAccessFile.writeFloat(produto.getPrecoVenda());
		randomAccessFile.writeInt(produto.getQuantidadeProduto());

	}


	// Versão sobrecarregada (overload) de writeObject.
	public void writeObject(Produto produto) throws IOException {
		Object object = produto;
		writeObject(object);
	}

	/**
	 * Lê o objeto como um registro do arquivo.
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
	 * Verifica a medida que está armazenada na variável passada como parâmetro com os valores da enum UnidadeMedida e 
	 * caso contenha, retorna esse valor. 
	 * 
	 * @param medida valor a ser comparado com o atributo da enum para verificação de que tipo de medida está sendo usado(kg,g,ml,l)
	 * @return retorna o tipo da medida ou um valor nulo.
	 */
	public UnidadeMedida verificaMedida(String medida) {
		for ( UnidadeMedida dado : UnidadeMedida.values()) {
			if(dado.getUnidade().equalsIgnoreCase(medida))
				return dado;
		}
		return null;
	}
}