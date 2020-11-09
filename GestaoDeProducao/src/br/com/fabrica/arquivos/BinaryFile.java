package br.com.fabrica.arquivos;

import java.io.*;

/**
 * Fornece opera��es para um arquivo bin�rio usando os servi�os de um arquivo com acesso aleat�rio.
 * As opera��es definidas por esta classse s�o independentes da estrutura de um arquivo
 * espec�fico. Portanto, os servi�os desta classe abstrata podem ser utilizados por qualquer
 * classe que queira implementar a estrutura (atributos) e os servi�os (m�todos) de um arquivo
 * com acesso aleat�rio.
 * 
 * <p><b>ATEN��O:</b> A estrutura do arquivo em rela��o a quantidade e os tipos de dados do registro
 * � definida pelo cliente da classe. No entanto, exige-se que o tamanho dos registros seja fixo. 
 * Esta restri��o � fundamental para o correto funcionamento dos m�todos da classe <code>BinaryFile</code>.</p>
 * 
 * @author Prof. M�rlon Oliveira da Silva
 * 
 * @version 0.3
 */
public abstract class BinaryFile {
	private String fileName;
	
	/** 
	 * Arquivo bin�rio de acesso aleat�rio para escrita e leitura de dados.
	 */
     protected RandomAccessFile randomAccessFile; 
     

     /**
      * Calcula o tamanho em bytes do arquivo.
      *
      *  @return um <code>long</code> com o tamanho, em bytes, do arquivo.
      *  
      *  @throws IOException se ocorrer um erro ao tentar acessar o arquivo.
      **/
	 public long fileSize() throws IOException {
		 // Obt�m o tamanho, em bytes, do arquivo em disco.
 	     return randomAccessFile.length();
	 } 

     /**
      * Abre o arquivo para a escrita e a leitura de dados. Se o arquivo n�o existir ele ser� criado.
      *
      * @param fileName um <code>String</code> com o nome do arquivo em disco.
      * 
      * @throws FileNotFoundException se o arquivo n�o puder ser aberto ou criado para entrada e sa�da de dados.
      **/
	 public void openFile(String fileName) throws FileNotFoundException {
		 // Obt�m o nome do arquivo.
		 this.fileName = fileName;

	     // Abre o arquivo para leitura e grava��o.
		 randomAccessFile = new RandomAccessFile(fileName, "rw");
	 } 

     /**
      * Fecha o arquivo.
      * 
      * @throws IOException se ocorrer um erro ao tentar fechar o arquivo.
      **/
	 public void closeFile() throws IOException {
		 if (randomAccessFile != null) randomAccessFile.close();
	 } 

	 /**
	  * Ajusta o tamanho da <i>string</i> para um n�mero fixo de caracteres.
	  *
	  * @param str <code>String</code> que ter� o tamanho ajustado para o valor especificado por <code>size</code>.
	  * @param size um <code>int</code> com o novo tamanho da string <i>str</i>.
	  *
	  * @return uma <code>String</code> com o conte�do especificado por <i>str</i> e tamanho definido por <i>size</i>.
	  **/
	 public String setStringLength(String str, int size) {
		 
		 StringBuffer buffer = null;

		 // Cria uma nova string com os caracteres do argumento str.
		 if (str != null)
		 {  buffer = new StringBuffer(str);

		 // Configura o tamanho da nova string para o n�mero de caracteres desejado.
		 buffer.setLength(size);
		 
		 }
		 else // Cria uma nova string sem caracteres e com a quantidade especificada no argumento size. 
			buffer = new StringBuffer(size);
		 return buffer.toString();
	 } 

	 /**
	  * L� uma <i>string</i> do arquivo com o n�mero de caracteres definido por <code>size</code>. 
	  *
	  *  @param size quantidade de caracteres da <i>string</i>.
	  *
	  *  @return a <i>string</i> lida do arquivo.  
	  *  
	  *  @throws IOException se ocorrer um erro  ao tentar ler do arquivo. 
	  **/
	 public String readString(int size) throws IOException {
		 char str[] = new char[size];

		 // L� a string do arquivo, um car�cter por vez.
		 for ( int count = 0; count < str.length; count++ )
			 str[count] = randomAccessFile.readChar();
		 
		 return new String(str).replace('\0', ' ').trim();
	 } 

	 /**
	  * Obt�m o nome do arquivo.
	  *
	  * @return um <code>String</code> com o nome do arquivo em disco.
	  **/
	 public String getFileName() {
		 return fileName;
	 }

	/**
      * Calcula a quantidade de registros do arquivo.
      *
      * @return um <code>long</code> com o n�mero de registros do arquivo.
      * 
      * @throws IOException se ocorrer um erro ao tentar obter o n�mero de registros do arquivo.
      **/
	 public long recordQuantity() throws IOException {
		 // Obt�m a quantidade de registros do arquivo dividindo o tamanho do arquivo pelo tamanho do registro.
		 return fileSize() / recordSize();
	 } 

	/**
	 * Posiciona o ponteiro do arquivo na posi��o especificada pelo n�mero do registro. Considere o
	 * registro zero como o primeiro registro do arquivo.
	 *
	 * @param recordNumber n�mero inteiro correspondente a um registro do arquivo.
	 * 
	 * @throws IOException se ocorrer um erro de E/S como, por exempo, acessar um n�mero do registro inv�lido.
	 **/
	public void setFilePointer(long recordNumber) throws IOException {
		 /* Valida o n�mero do registro e se inv�lido dispara a exce��o. Considera recordNumber como 
		  * menor ou igual ao n�mero total de registros do arquivo para permitir o m�todo seek posicionar 
		  * no fim do arquivo e possibilitar a inser��o de novos registros no arquivo.  
		 */
	    if (recordNumber >= 0 && recordNumber <= recordQuantity())
		   randomAccessFile.seek(recordNumber * recordSize());
		else
		   throw new IOException(); // N�mero de registro inv�lido.
	} 

	 /**
	  * Exclui um registro do arquivo.
	  *
	  * @param recordNumber um n�mero inteiro correspondente a um registro do arquivo. 
	  * O primeiro registro � de n�mero zero (0).
	  * 
	  * @throws IOException se ocorrer um erro de E/S como, por exempo, acessar um n�mero do registro inv�lido.
	  **/
	public void excludeFileRecord(int recordNumber) throws IOException {
		// Posiciona o ponteiro do arquivo no �ltimo registro.
		setFilePointer(recordQuantity() - 1);

		// Verifica se o registro a ser exclu�do n�o � �ltimo.
		if (recordNumber != recordQuantity() - 1) {
			// L� os dados do objeto armazenado no �ltimo registro do arquivo.
			Object objeto = readObject(); // Exemplo de polimorfismo na chamada de readObject. 

			// Posiciona no �nicio do registro a ser exclu�do.
			setFilePointer(recordNumber);

			// Escreve os dados do �ltimo registro no registro a ser exclu�do.
			writeObject(objeto); // Exemplo de polimorfismo na chamada de writeObject.
		}

		// Trunca o arquivo, ou seja, apaga o �ltimo registro. Exemplo de polimorfismo na chamada de recordSize. 
		randomAccessFile.setLength(fileSize() - recordSize());
	} 

	/**
	 * Calcula o tamanho, em bytes, do registro composto por vari�veis membro do objeto.
	 *
	 * @return um <code>int</code> com o tamanho, em bytes, do registro.
	 */
	public abstract int recordSize();

	/**
	  * Escreve o objeto como um registro do arquivo.
	  *
	  * @param obj um <code>Object</code> que ser� armazenado no arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S.
	  **/
	 public abstract void writeObject(Object objeto) throws IOException;

	 /**
	  * L� o objeto como um registro do arquivo.
	  *
	  * @return um <code>Object</code> com os atributos do objeto lido do arquivo.
	  * 
	  * @throws IOException se ocorrer um erro de E/S.
	  **/
	 public abstract Object readObject() throws IOException;
} // class BinaryFile
