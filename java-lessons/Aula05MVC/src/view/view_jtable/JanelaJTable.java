package view.view_jtable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidade.Aluno;
import view.View;

public class JanelaJTable extends JFrame implements View {
	
	JTable tabela;
	DefaultTableModel dtm;
	
	JButton botaoListar;
	
	public JanelaJTable() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		dtm = new DefaultTableModel(new Object[] {"id", "nome"}, 0) ;
		tabela = new JTable(dtm);
		JScrollPane tabelaPanel = new JScrollPane(tabela);
		add(tabelaPanel, BorderLayout.CENTER);
		
		botaoListar = new JButton("Listar");
		JPanel botaoPanel = new JPanel();
		botaoPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		botaoPanel.add(botaoListar);
		add(botaoPanel, BorderLayout.PAGE_END);
		
		pack();
		setVisible(true);
	}

	@Override
	public void listar(Collection<Aluno> alunos) {
		dtm.setNumRows(0);
		for(Aluno aluno: alunos) {
			Object[] linha = new Object[] {aluno.getId(), aluno.getNome()};
			dtm.addRow(linha);
		}
	}

	@Override
	public void addListenerListar(ActionListener listenerListar) {
		botaoListar.addActionListener(listenerListar);
	}
	

}
