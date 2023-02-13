package model;

import java.util.Collection;

import entidade.Aluno;

public interface Model {
	
	public Collection<Aluno> loadAlunos();
	public void saveAlunos(Collection<Aluno> alunos);
	

}
