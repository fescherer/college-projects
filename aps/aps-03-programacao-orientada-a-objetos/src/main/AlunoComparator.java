package main;

import java.util.Comparator;

public class AlunoComparator implements Comparator<Aluno>{

	//Essa serve para comparar Alunos, assim definindo 
	//que dois alunos só serão iguais se tiverem o mesmo id
	@Override
	public int compare(Aluno arg0, Aluno arg1) {
		return arg0.getId().compareTo(arg1.getId());
	}
}
