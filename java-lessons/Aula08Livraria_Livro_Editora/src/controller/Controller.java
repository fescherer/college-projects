package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

import entidades.Editora;
import entidades.Livro;
import model.dao.Dao;
import view.View;

public class Controller {
	
	Dao dao;
	View view;
	
	public Controller(Dao dao, View view) {
		this.dao = dao;
		this.view = view;
		
		init();
	}
	
	private void init() {
		view.addComportamentoBuscaLivros(new ComportamentoBuscarLivros());
		view.addComportamentoBuscaEditoras(new ComportamentoBuscarEditoras());
	}
	
	class ComportamentoBuscarLivros implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String palavraChave = view.getPalavraBuscada();
			Collection<Livro> livros = dao.getLivros(palavraChave);
			view.mostrarLivros(livros);
		}
	}
	
	class ComportamentoBuscarEditoras implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String palavraChave = view.getPalavraBuscada();
			Map<Editora, Collection<Livro>> editoras = dao.getEditoras(palavraChave);
			view.mostrarEditoras(editoras);
		}
	}
	
	

}
