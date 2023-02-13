package testes;

import java.io.IOException;
import java.util.ArrayList;

import fileManager.FileManager;
import fileManager.Reader;
import fileManager.Writer;
import main.Aluno;
import main.Curso;
import main.Rendimento;

public class TesteRendimento {

	public static void main(String[] args) throws IOException{
		
		Aluno fe = new Aluno("15", "Marquinhos");
		Curso mat = new Curso("Matemática", "GRADUACAO", 2020);
//		mat.adicionarAluno(fe);
//		mat.adicionarAluno(fe);
		Rendimento r = new Rendimento(fe , mat , 4 , 5 , 6 , 7);
		System.out.println(r);
		System.out.println(r.isAprovado());	
		
		Writer writer = new Writer();
		writer.writeRelatorio(mat);
		
	}
	
}
