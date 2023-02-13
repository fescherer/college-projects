package fileManager;

import java.io.IOException;

public class FileManager {

	//Essa classe serve só para colocar um diretório comum as classes Reader e Writer
	
	String diretorio;
	
	public FileManager(String aDiretorio) throws IOException {
		diretorio = aDiretorio;	
	}
	
	//Aqui é o diretório que o programa usa
	public FileManager(){
		diretorio = "res\\";
	}
	
}
