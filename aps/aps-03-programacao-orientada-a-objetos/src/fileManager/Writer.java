package fileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import main.Aluno;
import main.Curso;
import main.Rendimento;

public class Writer extends FileManager{
	BufferedWriter writer;
	
	public Writer() throws IOException {
		super();
	}
	
	public Writer(String aDiretorio, BufferedWriter writer) throws IOException {
		super(aDiretorio);
		this.writer = writer;
	}

	//Métodos para escrever em um arquivo
	public void writeAluno(Aluno aluno) throws IOException{
		//O parâmetro true é para falar que se o arquivo já existe, é para escrever na última linha dele
		writer = new BufferedWriter(new FileWriter(diretorio + "alunos.csv", true )); 
		writer.write(aluno.getId() + ";" + aluno.getNome() + "\n");
		writer.flush();
		writer.close();
	}
	
	public void writeCurso(Curso curso) throws IOException{
		writer = new BufferedWriter(new FileWriter(diretorio + "cursos.csv", true ));
		writer.write(curso.getNome() + ";" + curso.getNivel() + ";" + curso.getAno() + "\n");
		writer.flush();
		writer.close();
	}
	
	public void writeRelatorio(Curso curso) throws IOException{
		writer = new BufferedWriter(new FileWriter(diretorio + curso.getNome() + "_" 
									+ curso.getNivel() + "_" + curso.getAno() + ".csv"));
		//Usamos um for-each para iterar o array e escrever aluno por aluno no relatorio do curso
		for (Map.Entry<Aluno, Rendimento> r : curso.getRendimentos().entrySet()){
			writer.write(r.getValue().getAluno().getId() + ";"
					+ r.getValue().getNp1().getNota() + ";"
					+ r.getValue().getNp2().getNota() + ";" 
					+ r.getValue().getReposicao().getNota() + ";" 
					+ r.getValue().getExame().getNota() + "\n");
		}
		writer.flush();
		writer.close();
	}
}

