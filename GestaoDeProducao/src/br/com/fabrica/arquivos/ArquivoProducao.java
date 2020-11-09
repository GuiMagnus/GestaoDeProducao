package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_PRODUCAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Producao;
import br.com.fabrica.modelo.Produto;
import br.com.fabrica.validacoes.Data;


/**
 * Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Produção</code>.
 *
 * @see BinaryFile
 * @see Produto
 *
 * @author Guilherme Magnus e Rafaela
 */

public class ArquivoProducao extends BinaryFile{
	/**
	 * Obtém o tamanho do registro que é de 128 bytes, pois são:
	 *4 bytes do codigo da produção.
	 *100 bytes do nome do produto com 50 caracteres (2 bytes de cada carácter UNICODE);
	 *20 bytes da data de produção
	 *4 bytes custo produção
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 128;
	}

	
	
	/**
	  * Escreve o objeto como um registro do arquivo.
	  *
	  * @param objeto um <code>Object</code> que será armazenado no arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S;
	  * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo não for da classe 
	  * <code>Producao</code>.
	  **/
	@Override
	public void writeObject(Object objeto) throws IOException {
		Producao producao = new Producao();
		if(objeto instanceof Producao)
			producao = (Producao) objeto;
		else
			throw new ClassCastException();
		
		randomAccessFile.writeInt(producao.getCodigo());
		randomAccessFile.writeChars(setStringLength(producao.getProduto().getNome(),50));
		randomAccessFile.writeInt(producao.getProduto().getQuantidade());
		randomAccessFile.writeFloat(producao.getCustoProducao());
		randomAccessFile.writeChars(setStringLength(producao.getData().toString(), 10));
		
	}

	/**
	 * Escreve um objeto com os dados de uma produção no arquivo
	 * @param producao <code>Producao</code> que será escrita
	 * @throws IOException Erro relacionado a entrada e saída de dados.
	 */
	public void writeObject(Producao producao) throws IOException {               
		Object object = producao;
		writeObject(object);
	}

	/**
	  * Lê o objeto como um registro do arquivo.
	  *
	  * @return um <code>Produção</code> com os atributos do objeto lido do arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S.
	  **/
	@Override
	public Object readObject() throws IOException {
		Producao producao = new Producao();
		
		producao.setCodigo(randomAccessFile.readInt());
		Produto produto = new Produto();
		produto.setNome(readString(50));
		produto.setQuantidade(randomAccessFile.readInt());
		producao.setProduto(produto);
		producao.setCustoProducao(randomAccessFile.readFloat());
		Data data = new Data(readString(10));
		producao.setData(data);
		
		return producao;
	}
	
	/**
	 * Recebe um Objeto com dados de uma produção referente a classe {@link Producao} a serem gravados
	 * no arquivo de producao.
	 * @param arquivo uma String contendo o nome do arquivo onde serão gravados os dados.
	 * @param producao Um objeto producao a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a gravação obteve sucesso ou falha.
	 */
	public Producao escreveProducaoNoArquivo(Producao producao, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(recordQuantity());
			writeObject(producao);
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Obtém uma produção que foi cadastrada.
	 * @param indice <code>int</code> referencia ao produto que será obtido
	 * @param arquivo<code>String</code>nome do arquivo onde serão obtidos os dados.
	 * @return informações referentes a produção.
	 */
	public Producao leProducaoNoArquivo(int indice, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(indice);
			Producao producao = (Producao) readObject();
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * Obtém o código sequencial para a produção
	 * @param arquivo Arquivo de onde será obtido o código
	 * @return retorna o código sequencial para o próximo dado de histórico
	 */
	public int obtemCodigoProducao(String arquivo) {
		int codigo = 0;
		try {
			openFile(arquivo);
			if(recordQuantity() == 0)
				codigo = 1;
			else {
				codigo = (int) (recordQuantity() + 1);
			}
			closeFile();
			return codigo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return codigo;
		} catch (IOException e) {
			e.printStackTrace();
			return codigo;
		}
	}
	
	/**
	 * Obtém a produção de um determinado produto.
	 * @param codigo <code>int</code> código referente a produção
	 * @param arquivo<code>String</code> nome do arquivo de onde será obtida a produção
	 * @return <code>Producao</code> dados da produção procurada. 
	 */
	public Producao obterProducao(int codigo, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			for (int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(producao.getCodigo() == codigo)
					break;
			}
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Obtém as produções cadastradas.
	 * @param arquivo Arquivo de onde irá obter as informações. 
	 * @return <code>List</code> lista de produções
	 */
	public List<Producao> leProducoesNoArquivo(String arquivo) {
		List<Producao> listaProducao = new ArrayList<>();
		try {
			openFile(arquivo);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Producao producao = (Producao) readObject();
				listaProducao.add(producao);
			}
			closeFile();
			return listaProducao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Altera as informações de uma produção cadastrada.
	 * @param arquivo <code>String</code> nome do arquivo de onde serão alterados os dados de produção
	 * @param prod <code>Producao</code> produção a ser alterada.
	 * @return <code>Producao</code> produção alterada.
	 */
	public Producao alteraProducao(Producao prod, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(producao.getProduto().getNome().equalsIgnoreCase(prod.getProduto().getNome())) {
					producao.getProduto().setQuantidade(prod.getProduto().getQuantidade());
					escreveProducaoPorPosicao(producao, i, ARQ_PRODUCAO);
					break;
				}
			}
			closeFile();
			return producao;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return producao;
		} catch (IOException e) {
			e.printStackTrace();
			return producao;
		}
	}
	
	/**
	 * Altera as informações de uma produção cadastrada.
	 * @param prod <code>Producao</code> produção a ser alterada.
	 * @param arquivo <code>String</code> nome do arquivo de onde será alterada a quantidade da produção
	 * @return <code>Producao</code> produção alterada.
	 */
	public Producao alteraQuantidadeProducao(Producao prod, String arquivo) {
		Producao producao = null;
		try {
			openFile(arquivo);
			
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				producao = (Producao) readObject();
				if(!producao.getProduto().getNome().equalsIgnoreCase(prod.getProduto().getNome())) {
					System.out.println("No if");
					continue;
				}else {
					producao.getProduto().setQuantidade(producao.getProduto().getQuantidade() + 
							prod.getProduto().getQuantidade());
					escreveProducaoPorPosicao(producao, i, arquivo);
					closeFile();
					return producao;
				}
			}
			closeFile();
			return escreveProducaoNoArquivo(prod, arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null	;
		}
	}
	
	/**
	 * Escreve uma produção em uma determinada posição.
	 * @param producao <code>Producao</code> producao a ser cadastrada.
	 * @param posicao <code>int</code> posição que será escrito a produção
	 * @param arquivo <code>String</code> nome do arquivo de onde será escrito os dados de produção
	 * @return Retorna True ou False indicando se a gravação teve sucesso ou falha.
	 */
	public boolean escreveProducaoPorPosicao(Producao producao, int posicao, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(posicao);
			writeObject(producao);
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
}
