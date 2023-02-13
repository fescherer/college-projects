package view;

import java.awt.event.ActionListener;
import java.util.Collection;

import entidade.Aluno;

public interface View {
	
	public void listar(Collection<Aluno> alunos);
	public void addListenerListar(ActionListener listenerListar);

}
