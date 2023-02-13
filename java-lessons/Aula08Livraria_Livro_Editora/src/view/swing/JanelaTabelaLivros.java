package view.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Livro;

public class JanelaTabelaLivros extends JFrame {
	
	JScrollPane pane;
	JTable table;
	DefaultTableModel dtm;
	
	public JanelaTabelaLivros(Collection<Livro> livros) {
		super("Livros");
		Object[] nomesColunas = new Object[] {"Título", "ISBN", "Editora", "Preço"};
		
		List<Livro> livrosLista = new ArrayList<>();
		for(Livro livro: livros) {
			livrosLista.add(livro);
		}
		Object[][] data = new Object[livrosLista.size()][4];
		int n = 0;
		for(Livro livro: livrosLista) {
			data[n][0] = livro.getTitulo();
			data[n][1] = livro.getIsbn();
			data[n][2] = livro.getEditora().getNome();
			data[n][3] = Double.toString(livro.getPreco());
			n++;
		}
		
		dtm = new DefaultTableModel(data, nomesColunas);
		table = new JTable(dtm);
		pane = new JScrollPane(table);
		add(pane);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		
	}
	
}
