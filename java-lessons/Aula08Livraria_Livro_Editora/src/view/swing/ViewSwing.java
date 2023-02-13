package view.swing;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import entidades.Editora;
import entidades.Livro;
import view.View;

public class ViewSwing extends JFrame implements View {
	
	private JButton botaoBuscaLivros;
	private JButton botaoBuscaEditora;
	private JTextField campoPalavraChave;
	
	public ViewSwing() {
		super("Biblioteca");
		
		setLayout(new GridLayout(3, 1));
		
		botaoBuscaLivros = new JButton("Busca Livros");
		add(botaoBuscaLivros);
		
		botaoBuscaEditora = new JButton("Busca Editora");
		add(botaoBuscaEditora);
		
		campoPalavraChave = new JTextField(50);
		add(campoPalavraChave);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void mostrarLivros(Collection<Livro> livros) {
		new JanelaTabelaLivros(livros);
	}

	@Override
	public void mostrarEditoras(Map<Editora, Collection<Livro>> editoras) {
		new JanelaTabelaEditoras(editoras);
	}

	@Override
	public void addComportamentoBuscaLivros(ActionListener al) {
		botaoBuscaLivros.addActionListener(al);
	}

	@Override
	public void addComportamentoBuscaEditoras(ActionListener al) {
		botaoBuscaEditora.addActionListener(al);
	}

	@Override
	public String getPalavraBuscada() {
		return campoPalavraChave.getText();
	}

}
