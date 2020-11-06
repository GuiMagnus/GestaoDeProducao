package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_INSUMO;
import static br.com.fabrica.constantes.Constantes.ARQ_PRECO_INSUMO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Insumo;



/**
 * Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Insumo</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoInsumo extends BinaryFile{

	/**
	 * Obt�m o tamanho do registro que � de 112 bytes, pois s�o:
	 *
	 * 100 bytes do nome do insumo com 50 caracteres (2 bytes de cada car�cter UNICODE);
	 *  4 bytes do c�digo do insumo;
	 *  4 bytes do c�digo do produto a que ele pertence
	 *  4 bytes da quantidade a ser usada do insumo no produto a que ele pertence.
	 *	4 bytes do pre�o do insumo
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 112;
	}

	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
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
		randomAccessFile.writeChars(setStringLength(insumo.getNome(), 50));
		randomAccessFile.writeFloat(insumo.getQuantidade());
		randomAccessFile.writeFloat(insumo.getPrecoUnitario());
	}

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
		insumo.setNome(readString(50));
		insumo.setQuantidade(randomAccessFile.readFloat());
		insumo.setPrecoUnitario(randomAccessFile.readFloat());
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
			openFile(ARQ_INSUMO);
			setFilePointer(recordQuantity());
			writeObject(insumo);
			ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
			ahp.escreveHistoricoNoArquivo(insumo.getHistorico(), ARQ_PRECO_INSUMO);
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
	public boolean escreveInsumosNoArquivo(List<Insumo> insumos, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(recordQuantity());
			for(Insumo insumo : insumos) {
				writeObject(insumo);
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
	 * Obt�m o c�digo sequencial dos insumos a partir do n�mero de registro no arquivo de insumos
	 * caso esteja vazio este ser� o primeiro produto a ser gravado no arquivo.
	 * @return retorna o c�digo sequencial para o pr�ximo dado do registro de produtos.
	 */
	public boolean obtemCodigoInsumo(Insumo insumo, int posicao) {
		try {
			openFile(ARQ_INSUMO);
			setFilePointer(posicao);
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
	
	/***
	 * Obt�m o c�digo sequencial dos insumos a partir do n�mero de registro no arquivo de insumos
	 * caso esteja vazio este ser� o primeiro insumo a ser gravado no arquivo.
	 * @return retorna o c�digo sequencial para o pr�ximo dado do registro de insumos.
	 */
	public int obtemCodigoInsumo() {
		int codigo = 0;
		try {
			openFile(ARQ_INSUMO);
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
			openFile(ARQ_INSUMO);
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
	 * Altera a quantidade de um determinado insumo
	 * @param insumo <code>Insumo</code> insumo que se deseja alterar.
	 * @param qtde <code>int</code> informa��o que ser� atualizada. 
	 * @return <code>Insumo</code> objeto alterado
	 */
	public Insumo alteraQuantidade(Insumo insumo,float qtde) {
		Insumo insumoAux = null;
		try {
			openFile(ARQ_INSUMO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				insumoAux = (Insumo) readObject();
				if(insumoAux.getCodigo() == insumo.getCodigo()) {
					insumoAux.setQuantidade(insumo.getQuantidade() - qtde);
					escreveInsumoNoArquivoPorPosicao(insumoAux, i);
					break;
				}
			}
			closeFile();
			return insumo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return insumo;
		} catch (IOException e) {
			e.printStackTrace();
			return insumo;
		}
	}
	
	
	/**
	 * Escreve um insumo em uma determinada posi��o.
	 * @param insumo <code>Insumo</code> insumo a ser cadastrado.
	 * @param posicao <code>int</code> posi��o que ser� escrito o insumo
	 * @return Retorna True ou False indicando se a grava��o teve sucesso ou falha.
	 */
	public boolean escreveInsumoNoArquivoPorPosicao(Insumo insumo, int posicao) {
		try {
			openFile(ARQ_INSUMO);
			setFilePointer(posicao);
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
	 * Altera pre�o de um determinado insumo
	 * @param insumo <code>Insumo</code> insumo que se deseja alterar.
	 * @param qtde <code>int</code> informa��o que ser� atualizada. 
	 * @return <code>Insumo</code> objeto alterado
	 */
	public boolean alteraPreco(int codigoProduto, int codigoInsumo, float novoPreco) {
		try {
			openFile(ARQ_INSUMO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Insumo insumo = (Insumo) readObject();
				if(insumo.getCodigoProduto() == codigoProduto && insumo.getCodigo() == codigoInsumo) {
					insumo.setPrecoUnitario(novoPreco);
					escreveInsumoNoArquivoPorPosicao(insumo, i);
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
	 * Obt�m os insumos referentes a um determinado produto.
	 * @param codigo <code>int</code> c�digo referente ao produto
	 * @return <code>List</code> lista de insumos do produto
	 */
	public List<Insumo> obtemInsumosDeUmProduto(int codigo){
		List<Insumo> listaDeInsumosDeUmProduto = new ArrayList<Insumo>();
		List<Insumo> listaDeInsumos = leInsumosNoArquivo();
		for (Insumo insumo : listaDeInsumos)
			if(insumo.getCodigoProduto() == codigo)
				listaDeInsumosDeUmProduto.add(insumo);
		return listaDeInsumosDeUmProduto;
	}

}
