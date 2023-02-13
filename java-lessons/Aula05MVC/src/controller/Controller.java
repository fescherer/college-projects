package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import entidade.Aluno;
import model.Model;
import view.View;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model aModel, View aView) {
		this.model = aModel;
		this.view = aView;
		
		view.addListenerListar(new ComportamentoListarAlunos());
		
	}
	
	class ComportamentoListarAlunos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Collection<Aluno> alunos = model.loadAlunos();
			view.listar(alunos);
		}
		
	}

}
