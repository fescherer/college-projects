package teste;

import java.util.ArrayList;
import java.util.Collection;

import entidade.Aluno;
import model.MeuModelCSV;
import model.Model;

public class TesteModel {
	
	public static void main(String[] args) {
		Model model = new MeuModelCSV();
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		alunos.add(new Aluno("123", "Ana"));
		alunos.add(new Aluno("124", "Bet"));
		alunos.add(new Aluno("125", "Car"));
		
		model.saveAlunos(alunos);
		
		Collection<Aluno> alunosSalvos = model.loadAlunos();
		
		for(Aluno aluno: alunosSalvos) {
			System.out.println(aluno);
		}
		
	}

}
