package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Validacoes;

/**
 *  Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Produto</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoProduto extends BinaryFile{

	/**
	 * Obtém o tamanho do registro que é de 124 bytes, pois são:
	 * 4 bytes do código do produto
	 *100 bytes do nome do Produto com 50 caracteres (2 bytes de cada carácter UNICODE)
	 *4 bytes para a unidade de medida(quilograma, grama, litro, mililitro)
	 *4 bytes para a margem de Lucro
	 *4 bytes para o preço da venda
	 *4 bytes da quantidade do produto
	 *4 bytes do tamanho da unidade
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 124;
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
		Produto produto;
		if(objeto instanceof Produto) {
			produto = (Produto) objeto;
		}
		else
			throw new ClassCastException();
		randomAccessFile.writeInt(produto.getCodigo());
		randomAccessFile.writeChars(setStringLength(produto.getNome(), 50));
		randomAccessFile.writeChars(setStringLength(produto.getUnidadeMedida().getUnidade(), 2));
		randomAccessFile.writeFloat(produto.getMargemLucro());
		randomAccessFile.writeFloat(produto.getPrecoVenda());
		randomAccessFile.writeInt(produto.getQuantidadeProduto());
		randomAccessFile.writeFloat(produto.getTamanhoUnidade());

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

		produto.setCodigo(randomAccessFile.readInt());
		produto.setNome(readString(50));
		String tipoProduto = readString(2);		
		produto.setUnidadeMedida(Validacoes.verificaMedida(tipoProduto));
		produto.setMargemLucro(randomAccessFile.readFloat());
		produto.setPrecoVenda(randomAccessFile.readFloat());
		produto.setQuantidadeProduto(randomAccessFile.readInt());
		produto.setTamanhoUnidade(randomAccessFile.readFloat());
		return produto;
	}
	
	/**
	 * Grava as informações dos produtos referente a classe {@link Produto}
	 * no arquivo de acesso aleatório dos produtos.
	 * @param produto Contém as informações de determinado produto que serão gravadas no arquivo.
	 * @return Retorna true ou false indicando se foi possível escrever no arquivo.
	 */
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
	
	/**
	 * Percorre o arquivo de produtos e lê um dado gravado no arquivo 
	 * indicado pela variável indice. Caso encontre retorna um objeto da classe {@link Produto}
	 * com os dados obtidos ou em falha retorna null.
	 * @param indice Variável que indica o registro a ser obtido do arquivo.
	 * @return Retorna um objeto contendo os dados obtidos ou null caso o registro seja inválido
	 */
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
	/**
	 * Percorre todo o arquivo de produtos adicionando cada registro a uma lista do tipo 
	 * da classe {@link Produto} e a retorna.
	 * 
	 * @return Retorna uma lista com todos os registros do arquivo de Produtos ou null caso
	 * o arquivo esteja vazio.
	 */
	public List<Produto> leProdutosNoArquivo() {
		List<Produto> listaProdutos = new ArrayList<>();
		try {
			openFile(ARQ_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Produto produto = (Produto) readObject();
				listaProdutos.add(produto);
			}
			closeFile();
			return listaProdutos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/***
	 * Obtém o código sequencial dos produtos a partir do número de registro no arquivo de produtos
	 * caso esteja vazio este será o primeiro produto a ser gravado no arquivo.
	 * @return retorna o código sequencial para o próximo dado do registro de produtos.
	 */
	public int obtemCodigoProduto() {
		int codigo = 0;
		try {
			openFile(ARQ_PRODUTO);
			if(recordQuantity() == 0)
				codigo = 1;
			else {
				codigo = (int) (recordQuantity() + 1);
			}
			closeFile();
			return codigo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean escreveProdutoNoArquivoPorPosicao(Produto produto, int posicao) {
		try {
			openFile(ARQ_PRODUTO);
			setFilePointer(posicao);
			System.out.println(produto);
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
	
	public Produto alteraProduto(Produto prod) {
		Produto produto = null;
		try {
			openFile(ARQ_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				produto = (Produto) readObject();
				
				if(produto.getCodigo() == prod.getCodigo()) {
					
					produto.setTamanhoUnidade(prod.getTamanhoUnidade());
					escreveProdutoNoArquivoPorPosicao(produto, i);
					break;
				}
			}
			closeFile();
			return produto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return produto;
		} catch (IOException e) {
			e.printStackTrace();
			return produto;
		}
	}
	
	public Produto obtemProduto(int codigoProduto) {
		Produto produto = null;
		try {
			openFile(ARQ_PRODUTO);
			
			for(int i = 0; i < recordQuantity(); i++) {
				
				setFilePointer(i);
				
				produto = (Produto) readObject();
				if(produto.getCodigo() == codigoProduto) {
					break;
				}
			}
			closeFile();
			return produto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return produto;
		} catch (IOException e) {
			e.printStackTrace();
			return produto;
		}
	}
}