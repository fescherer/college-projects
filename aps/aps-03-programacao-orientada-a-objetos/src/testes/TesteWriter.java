package testes;

import java.io.IOException;

import fileManager.Writer;
import main.Aluno;
import main.Curso;
import main.Rendimento;

public class TesteWriter {

	public static void main(String[] args) throws IOException {
		
		Writer writer = new Writer();
		Aluno jorginho = new Aluno("31", "Jorginho");
//		writer.writeAluno(jorginho);
		
		Curso bancoDados = new Curso("Banco de Dados", "GRADUACAO", 2020);
//		writer.writeCurso(bancoDados);
		
		Aluno zuzu = new Aluno("21", "zuzu");
		new Rendimento(zuzu, bancoDados, 10, 6, 0, 0);
		new Rendimento(jorginho, bancoDados, 7.4560, 2, 8, 0);
		
	
		writer.writeRelatorio(bancoDados);
	}
}
