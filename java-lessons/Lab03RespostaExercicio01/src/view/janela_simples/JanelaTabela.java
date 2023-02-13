package view.janela_simples;

import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidade.Produto;

public class JanelaTabela extends JFrame {
	
	public JanelaTabela(Collection<Produto> produtos) {
		DefaultTableModel dtm = new DefaultTableModel(new Object[] {"id", "nome", "valor"}, 1);
		JTable tabela = new JTable(dtm); 
		JScrollPane pane = new JScrollPane(tabela);
		add(pane);
		
		for(Produto produto: produtos) {
			Object[] linha = new Object[] {produto.getId(), produto.getNome(), produto.getValor()};
			dtm.addRow(linha);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
