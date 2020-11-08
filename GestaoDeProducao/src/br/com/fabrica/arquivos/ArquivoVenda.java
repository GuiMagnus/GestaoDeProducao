package br.com.fabrica.arquivos;

import static br.com.fabrica.constantes.Constantes.ARQ_INSUMO;
import static br.com.fabrica.constantes.Constantes.ARQ_VENDA;
import static br.com.fabrica.constantes.Constantes.ARQ_VENDA_PRODUTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabrica.modelo.Venda;
import br.com.fabrica.validacoes.Data;

/**
 *  Esta classe fornece uma implementa��o para as opera��es que permitem manipular um arquivo de acesso 
 * aleat�rio para ler e escrever objetos da classe <code>Venda</code>.
 * @author Guilherme Magnus
 *
 */
public class ArquivoVenda extends BinaryFile {
	
	
	/**
	 * Obt�m o tamanho do registro que � de bytes, pois s�o:
	 * 4 bytes do c�digo da venda.
	 *20 bytes da data da venda do produto Produto com 10 caracteres (2 bytes de cada car�cter UNICODE).
	 *18 bytes da hora da venda do produto Produto com 9 caracteres (2 bytes de cada car�cter UNICODE).
	 *4 bytes para o valor total de cada venda
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	@Override
	public int recordSize() {
		return 46;
	}

	/**
	 * Escreve o objeto como um registro do arquivo.
	 *
	 * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S;
	 * @throws ClassCastException se o tipo do objeto a ser escrito no arquivo n�o for da classe 
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
		randomAccessFile.writeChars(setStringLength(venda.getData().toString(), 10));
		randomAccessFile.writeChars(setStringLength(venda.getHora(), 9));
		randomAccessFile.writeFloat(venda.getValorTotalVenda());
	}

		/**
		 * Vers�o sobrecarregada (overload) de writeObject.
		 * @param venda
		 * @throws IOException
		 */
		public void writeObject(Venda venda) throws IOException {
			Object object = venda;
			writeObject(object);
		}
	
	/**
	 * L� um registro do arquivo de Vendas realizadas referente a classe {@link Venda}
	 * e o retorna 
	 *@return Object Um objeto com os dados referente a uma venda de um produto.
	 */
	@Override
	public Object readObject() throws IOException {
		Venda venda = new Venda();
		venda.setCodigo(randomAccessFile.readInt());
		Data data = new Data(readString(10)); 
		venda.setData(data);
		venda.setHora(readString(9));
		venda.setValorTotalVenda(randomAccessFile.readFloat());

		return venda;
	}
	
	/***
	 * Obt�m o c�digo sequencial das vendas gravado no arquivo de vendas
	 * @return retorna o c�digo sequencial para o pr�ximo dado de registros das vendas.
	 */
	public int obtemCodigoVenda() {
		int codigo = 0;
		try {
			openFile(ARQ_VENDA);
			//System.out.println("tam"+recordQuantity());
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
	 * Obt�m a lista de produtos que foi cadastrada.
	 * @return <code>List</code> lista com os produtos cadastrados.
	 */
	public List<Venda> leProdutosNoArquivo() {
		List<Venda> listaVendas = new ArrayList<>();
		try {
			openFile(ARQ_VENDA);
			for(int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Venda venda = (Venda) readObject();
				listaVendas.add(venda);
			}
			closeFile();
			return listaVendas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Registra a venda que foi realizada
	 * @param venda <code>Venda</code> venda a ser registrada
	 * @return Retorna True ou False indicando se a grava��o obteve sucesso ou falha.
	 */
	public boolean gravaVenda(Venda venda) {
		try {
			openFile(ARQ_VENDA);
			setFilePointer(recordQuantity());
			writeObject(venda);
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
	public List<Venda> obtemVendas(String dataHoraInicio, String dataHoraFim){
		List<Venda> vendasPeriodo = new ArrayList<Venda>();
		Data dataInicio = new Data(dataHoraInicio);
		Data dataFim = new Data(dataHoraFim);
		try {
			openFile(ARQ_VENDA);
			for (int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Venda venda = (Venda) readObject();
				if(venda.getData().dataDentroDoPeriodo(dataInicio, dataFim) == true)
					vendasPeriodo.add(venda);
			}
			closeFile();
			return vendasPeriodo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Venda> obtemVendasHora(String horaInicio, String horaFim){
		List<Venda> vendasPeriodo = new ArrayList<Venda>();
		Data data = new Data();
		try {
			openFile(ARQ_VENDA);
			for (int i = 0; i < recordQuantity(); i++) {
				setFilePointer(i);
				Venda venda = (Venda) readObject();
				if(venda.getData().compareTo(data)==0) {
					if(new Data().comparaHora(horaInicio, horaFim, venda.getHora())== true)
						vendasPeriodo.add(venda);
				}
			}
			closeFile();
			return vendasPeriodo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
