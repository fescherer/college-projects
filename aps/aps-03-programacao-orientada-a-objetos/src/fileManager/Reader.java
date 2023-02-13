package fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import main.Aluno;
import main.AlunoComparator;
import main.Curso;
import main.Rendimento;

public class Reader extends FileManager{
	
	//Essa classe serve para guardar todos os métodos que são relacionados a ler arquivos
	
	BufferedReader reader;
	
	public Reader() throws IOException {
		super();
	}
	
	public Reader(String aDiretorio) throws IOException {
		super(aDiretorio);
	}

	//Método para ler o arquivos alunos.csv
	public TreeMap<String, Aluno> readAluno(TreeMap<String, Aluno> alunos) throws IOException{
		reader = new BufferedReader(new FileReader(diretorio + "alunos.csv"));
		String linha;
		String id = "";
		String nome = "";
		//Ele irá ler enquanto a linha for diferente de null, ou seja, até a última linha
		while((linha = reader.readLine()) != null) {
			//Aqui é colocado toda a linha dentro de um array String
			//Onde cada pedaço do array é definido até o ;
			//Depois separamos eles em variaveis para deixar mais organizado
			String[] dados = linha.split(";");
			id = dados[0];
			nome = dados[1];
			Aluno a = new Aluno(id, nome);
			alunos.put(id,a);
		}	
		reader.close();
		return alunos;
	}

	//Método para ler o arquivo cursos.csv
	public ArrayList<Curso> readCurso(ArrayList<Curso> cursos) throws IOException{
		reader = new BufferedReader(new FileReader(diretorio + "cursos.csv"));
		String linha;
		String nome = "";
		String nivel = "";
		int ano = 0;
		
		while((linha = reader.readLine()) != null) {
			String[] dados = linha.split(";");
			nome = dados[0];
			nivel = dados[1];
			ano = Integer.parseInt(dados[2]);
			Curso c = new Curso(nome, nivel, ano);
			cursos.add(c);
		}	
		reader.close();
		return cursos;
		}
	
	//Método para ler um arquivo de relatório de curso
	public TreeMap<Aluno, Rendimento> readRelatorio(Curso curso,
			TreeMap<String,Aluno> alunos) throws IOException{
		try {
			reader = new BufferedReader(new FileReader(diretorio + curso.getNome() + "_" + 
										curso.getNivel() + "_" + curso.getAno() + ".csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar o relatório desse curso");
			System.out.println("Verifique se os dados estão corretos");
		}
		TreeMap<Aluno, Rendimento> rendimentosCurso = new TreeMap<>(new AlunoComparator());
		String linha, id;
		double np1,np2,notaReposicao,notaExame;
		while((linha = reader.readLine()) != null) {
			String[] dados = linha.split(";");
			id = dados[0];
			np1 = Double.parseDouble(dados[1]);
			np2 = Double.parseDouble(dados[2]);
			notaReposicao = Double.parseDouble(dados[3]);
			notaExame = Double.parseDouble(dados[4]);
			
			if(alunos.containsKey(id)) {
				Rendimento r = new Rendimento(alunos.get(id), curso, np1, np2, notaReposicao, notaExame);
				rendimentosCurso.put(alunos.get(id),r);
			}else {
				System.out.println("Aluno " + id + " não cadastrado no relatorio do curso: \n" + curso);
			}
		}
		reader.close();
		return rendimentosCurso;
		
	}
}
