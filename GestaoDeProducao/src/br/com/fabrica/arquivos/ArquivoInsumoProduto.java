package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_INSUMO_PRODUTO;
import static br.com.fabrica.constantes.Constantes.ARQ_PRECO_INSUMO;
import static br.com.fabrica.constantes.Constantes.ARQ_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.HistoricoPreco;
import br.com.fabrica.modelo.Insumo;



/**
 * Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Insumo</code>.
 * @author Guilherme Magnus e Rafaela.
 *
 */
public class ArquivoInsumoProduto extends BinaryFile{


	/**
	 * Obt�m o tamanho do registro que � de 112 bytes, pois s�o:
	 *
	 * 100 bytes do nome do insumo com 50 caracteres (2 bytes de cada car�cter UNICODE);
	 *  4 bytes do c�digo do insumo;
	 *  4 bytes do c�digo do produto a que ele pertence
	 *  4 bytes da quantidade a ser usada do insumo no produto a que ele pertence.
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 112;
	}



	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param objeto um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>Insumo</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		Insumo insumo = new Insumo();

		if(objeto instanceof Insumo) 
			insumo = (Insumo) objeto;
		else
			throw new ClassCastException();
		randomAccessFile.writeInt(insumo.getCodigo());
		randomAccessFile.writeInt(insumo.getCodigoProduto());
		randomAccessFile.writeChars(setStringLength(insumo.getNome(), 50));
		randomAccessFile.writeFloat(insumo.getQuantidade());
	}

	/**
	 * Escreve um objeto insumo no arquivo.
	 * @param insumo objeto insumo que cont�m as informa��es de um insumo
	 * @throws IOException Erro relacionada a entrada e sa�da de dados.
	 */
	public void writeObject(Insumo insumo) throws IOException {
		Object object = insumo;
		writeObject(object);
	}


	/**
	 * L� o objeto como um registro do arquivo.
	 *
	 * @return um <code>Insumo</code> com os atributos do objeto lido do arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S.
	 **/
	@Override
	public Object readObject() throws IOException {
		Insumo insumo = new Insumo();

		insumo.setCodigo(randomAccessFile.readInt());
		insumo.setCodigoProduto(randomAccessFile.readInt());
		insumo.setNome(readString(50));
		insumo.setQuantidade(randomAccessFile.readFloat());
		return insumo;
	}

	/**
	 * Recebe um Objeto com dados de um insumo referente a classe {@link Insumo} a serem gravados
	 * no arquivo de Insumos.
	 * @param insumo Um objeto insumo a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public boolean escreveInsumoNoArquivo(Insumo insumo) {
		try {
			openFile(ARQ_INSUMO_PRODUTO);
			setFilePointer(recordQuantity());
			writeObject(insumo);
			ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
			for(HistoricoPreco hp : insumo.getHistorico())
				ahp.escreveHistoricoNoArquivo(hp, ARQ_PRECO_INSUMO);
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
	 * Recebe uma lista de insumos de determinado produto e escreve os registros
	 * no arquivo de insumos. 
	 * @param insumos Uma lista com dados referente a classe {@link Insumo} para serem gravados 
	 * no arquivo de insumos.
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveInsumosNoArquivo(List<Insumo> insumos) {
		try {
			ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
			openFile(ARQ_INSUMO_PRODUTO);
			setFilePointer(recordQuantity());
			for(Insumo insumo : insumos) {
				writeObject(insumo);
				for(HistoricoPreco hp : insumo.getHistorico())
					ahp.escreveHistoricoNoArquivo(hp, ARQ_PRECO_INSUMO);
			}
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
	

	/***
	 * Obt�m o c�digo sequencial dos produtos a partir do n�mero de registro no arquivo de produtos
	 * caso esteja vazio este ser� o primeiro produto a ser gravado no arquivo.
	 * @return retorna o c�digo sequencial para o pr�ximo dado do registro de produtos.
	 */
	public int obtemCodigoInsumo() {
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
	
	/**
	 * Obt�m os insumos que est�o cadastrados.
	 * @return <code>List</code> lista de insumos cadastrados
	 */
	public List<Insumo> leInsumosNoArquivo() {
		List<Insumo> listaInsumos = new ArrayList<>();
		try {
			openFile(ARQ_INSUMO_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Insumo insumo = (Insumo) readObject();
				listaInsumos.add(insumo);
			}
			closeFile();
			return listaInsumos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Altera pre�o de um determinado insumo
	 * @param codigoProduto <code>int</code> c�digo do produto para altera��o do insumo
	 * @param codigoInsumo <code>int</code> codigo do insumo a ser alterado.
	 * @param novoPreco  <code>float</code> pre�o a ser atualizado.
	 * @return <code>true</code> caso consiga alterar. <code>false</code> caso n�o consiga.
	 */
	public boolean alteraInsumo(int codigoProduto, int codigoInsumo, float novoPreco) {
		try {
			openFile(ARQ_INSUMO_PRODUTO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Insumo insumo = (Insumo) readObject();
				if(insumo.getCodigoProduto() == codigoProduto && insumo.getCodigo() == codigoInsumo) {
					insumo.setPrecoUnitario(novoPreco);
					escreveInsumosNoArquivoPorPosicao(insumo, i);
					break;
				}
			}
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
	 * Escreve um insumo em uma determinada posi��o.
	 * @param insumo <code>Insumo</code> insumo a ser cadastrado.
	 * @param posicao <code>int</code> posi��o que ser� escrito o insumo
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveInsumosNoArquivoPorPosicao(Insumo insumo, int posicao) {
		try {
			openFile(ARQ_INSUMO_PRODUTO);
			setFilePointer(recordQuantity());
			writeObject(insumo);
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
	 * Obt�m os insumos referentes a um determinado produto.
	 * @param codigo <code>int</code> c�digo referente ao produto
	 * @return <code>List</code> lista de insumos do produto
	 */
	public List<Insumo> obtemInsumosDeUmProduto(int codigo){
		
		List<Insumo> listaDeInsumosDeUmProduto = new ArrayList<Insumo>();
		List<Insumo> listaDeInsumos = leInsumosNoArquivo();
		
		for (Insumo insumo : listaDeInsumos)
				listaDeInsumosDeUmProduto.add(insumo);
		
		return listaDeInsumosDeUmProduto;
	}

}
