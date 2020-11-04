package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_HISTORICO_INSUMO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.HistoricoPreco;


/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>HistoricoPreco</code>.
 * @author GuilhermeMagnus
 *
 */
public class ArquivoHistoricoPreco extends BinaryFile{

	/**
	 * Obt�m o tamanho do registro que � de 32 bytes, pois s�o:
	 *
	 * 20 bytes da data de altera��o do pre�o do produto ou insumo (2 bytes de cada car�cter UNICODE);
	 *  4 bytes do c�digo do insumo ou produto;
	 *  4 bytes do c�digo de cada objeto criado para o Hist�rico de pre�o
	 *	4 bytes do pre�o do insumo ou produto
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 32;
	}


	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
	 * <code>HistoricoPreco</code>.
	 */
	@Override
	public void writeObject(Object objeto) throws IOException {
		HistoricoPreco historicoPreco = new HistoricoPreco();
		if(objeto instanceof HistoricoPreco)
			historicoPreco = (HistoricoPreco) objeto;
		else
			throw new ClassCastException();

		randomAccessFile.writeInt(obtemCodigoHistorico());
		randomAccessFile.writeInt(historicoPreco.getCodigoReferenciaDeDado());
		randomAccessFile.writeFloat(historicoPreco.getPreco());
		randomAccessFile.writeChars(setStringLength(historicoPreco.getData(), 10));

	}

	// Vers�o sobrecarregada (overload) de writeObject.
	public void writeObject(HistoricoPreco historicoPreco) throws IOException {
		Object object = historicoPreco;
		writeObject(object);
	}

	/**
	 * L� um registro do arquivo historico de pre�os de um produto ou insumo
	 * e adiciona no objeto HistoricoPreco para ser retornado.
	 * @return Retorna um objeto referente a classe {@link HistoricoPreco} com dados do pre�o
	 * de determinado produto ou insumo.
	 */
	@Override
	public Object readObject() throws IOException {
		HistoricoPreco historicoPreco = new HistoricoPreco();

		
		historicoPreco.setCodigo(randomAccessFile.readInt());
		historicoPreco.setCodigoReferenciaDeDado(randomAccessFile.readInt());
		historicoPreco.setPreco(randomAccessFile.readFloat());
		historicoPreco.setData(readString(10));

		return historicoPreco;
	}

	/***
	 * Obt�m o c�digo sequencial do hist�rico de insumos
	 * @return retorna o c�digo sequencial para o pr�ximo dado de hist�rico
	 */
	public int obtemCodigoHistorico() {
		int codigo = 0;
		try {
			//openFile(ARQ_HISTORICO_INSUMO);
			if(recordQuantity() == 0)
				codigo = 1;
			else {
				codigo = (int) (recordQuantity() + 1);
			}
			//closeFile();
			return codigo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean escreveHistoricoNoArquivo(List<HistoricoPreco> hpList, String arquivo) {
		try {
			openFile(arquivo);
			setFilePointer(recordQuantity());
			for(HistoricoPreco hp : hpList) {
				writeObject(hp);
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


	public List<HistoricoPreco> obtemHistorico(int codigo) {
		HistoricoPreco hp = new HistoricoPreco();
		List<HistoricoPreco> hpList = new ArrayList<HistoricoPreco>();
		try {
			openFile(ARQ_HISTORICO_INSUMO);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				hp = (HistoricoPreco) readObject();
				if(hp.getCodigoReferenciaDeDado() != codigo)
					continue;
				hpList.add(hp);
			}
			closeFile();
			return hpList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}


