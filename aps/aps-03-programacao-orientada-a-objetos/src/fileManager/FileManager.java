package fileManager;

import java.io.IOException;

public class FileManager {

	//Essa classe serve s� para colocar um diret�rio comum as classes Reader e Writer
	
	String diretorio;
	
	public FileManager(String aDiretorio) throws IOException {
		diretorio = aDiretorio;	
	}
	
	//Aqui � o diret�rio que o programa usa
	public FileManager(){
		diretorio = "res\\";
	}
	
}
