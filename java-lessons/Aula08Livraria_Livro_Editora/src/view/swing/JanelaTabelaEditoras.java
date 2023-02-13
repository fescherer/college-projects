package view.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Editora;
import entidades.Livro;

public class JanelaTabelaEditoras extends JFrame {
	
	JScrollPane pane;
	JTable table;
	DefaultTableModel dtm;
	
	List<Editora> editorasLista = new ArrayList<>();
	Map<Editora, Collection<Livro>> editoras;
	
	public JanelaTabelaEditoras(Map<Editora, Collection<Livro>> editoras) {
		super("Livros");
		
		this.editoras = editoras; 
		
		Object[] nomesColunas = new Object[] {"Nome", "URL"};
		
		editorasLista = new ArrayList<>();
		for(Editora editora: editoras.keySet()) {
			editorasLista.add(editora);
		}
		
		Object[][] data = new Object[editorasLista.size()][2];
		int n = 0;
		for(Editora editora: editorasLista) {
			data[n][0] = editora.getNome();
			data[n][1] = editora.getUrl();
			n++;
		}
		
		dtm = new DefaultTableModel(data, nomesColunas);
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int cell) {return false;}
		};
		pane = new JScrollPane(table);
		add(pane);
		
		table.addMouseListener(new ComportamentoClicarTable());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		
	}
	
	class ComportamentoClicarTable implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				int linha = table.getSelectedRow();
				Editora editora = editorasLista.get(linha);
				Collection<Livro> livros = editoras.get(editora);
				new JanelaTabelaLivros(livros);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
}




