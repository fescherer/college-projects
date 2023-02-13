package testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import fileManager.Reader;
import main.Aluno;
import main.Curso;

public class TesteReader {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		
		TreeMap<String, Aluno> alunos = new TreeMap<>();
		
		reader.readAluno(alunos);
		
		for(Map.Entry<String, Aluno> alunoAtual : alunos.entrySet()) {
			System.out.println(alunoAtual);
		}
		
		ArrayList<Curso> cursos = new ArrayList<>();
		
		reader.readCurso(cursos);
		
		for(Curso cursoAtual : cursos) {
			System.out.println(cursoAtual);
		}
		
	}
	
}
