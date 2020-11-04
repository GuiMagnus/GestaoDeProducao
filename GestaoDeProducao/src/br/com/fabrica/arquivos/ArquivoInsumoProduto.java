package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Insumo;
import br.com.fabrica.validacoes.Validacoes;



/**
 * Esta classe fornece uma implementação para as operações que permitem manipular um arquivo de acesso 
 * aleatório para ler e escrever objetos da classe <code>Insumo</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoInsumoProduto extends BinaryFile{


	/**
	 * Obtém o tamanho do registro que é de 112 bytes, pois são:
	 *
	 * 100 bytes do nome do insumo com 50 caracteres (2 bytes de cada carácter UNICODE);
	 *  4 bytes do código do insumo;
	 *  4 bytes do código do produto a que ele pertence
	 *  4 bytes da quantidade a ser usada do insumo no produto a que ele pertence.
	 *  4 bytes do tamanho da unidade.
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
		randomAccessFile.writeChars(setStringLength(insumo.getMedida().getUnidade(),2));
	}

	// Versão sobrecarregada (overload) de writeObject.
	public void writeObject(Insumo insumo) throws IOException {
		Object object = insumo;
		writeObject(object);
	}


	/**
	 * Lê o objeto como um registro do arquivo.
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
		insumo.setMedida(Validacoes.verificaMedida(readString(2)));
		return insumo;
	}

	/**
	 * Recebe um Objeto com dados de um insumo referente a classe {@link Insumo} a serem gravados
	 * no arquivo de Insumos.
	 * @param insumo Um objeto insumo a ser gravado no arquivo.
	 * @return Retorna True ou False indicando se a gravação obteve sucesso ou falha.
	 */
	public boolean escreveInsumoNoArquivo(Insumo insumo) {
		try {
			openFile(ARQ_INSUMO_PRODUTO);
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
	 * @return Retorna True ou False indicando se a gravação teve sucesso ou falha.
	 */
	public boolean escreveInsumosNoArquivo(List<Insumo> insumos) {
		try {
			ArquivoHistoricoPreco ahp = new ArquivoHistoricoPreco();
			openFile(ARQ_INSUMO_PRODUTO);
			setFilePointer(recordQuantity());
			for(Insumo insumo : insumos) {
				writeObject(insumo);
				ahp.escreveHistoricoNoArquivo(insumo.getHistorico(), ARQ_PRECO_INSUMO);
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
	 * Obtém o código sequencial dos produtos a partir do número de registro no arquivo de produtos
	 * caso esteja vazio este será o primeiro produto a ser gravado no arquivo.
	 * @return retorna o código sequencial para o próximo dado do registro de produtos.
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
	public List<Insumo> obtemInsumosDeUmProduto(int codigo){
		
		List<Insumo> listaDeInsumosDeUmProduto = new ArrayList<Insumo>();
		List<Insumo> listaDeInsumos = leInsumosNoArquivo();
		
		for (Insumo insumo : listaDeInsumos)
			//if(insumo.getCodigoProduto() == codigo)
				listaDeInsumosDeUmProduto.add(insumo);
		
		return listaDeInsumosDeUmProduto;
	}

}
