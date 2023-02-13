package view;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

import entidades.Editora;
import entidades.Livro;

public interface View {
	
	public void mostrarLivros(Collection<Livro> livros);
	public void mostrarEditoras(Map<Editora, Collection<Livro>> editoras);
	
	public void addComportamentoBuscaLivros(ActionListener al);
	public void addComportamentoBuscaEditoras(ActionListener al);
	
	public String getPalavraBuscada();

}
