package view.view_janela;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;

import entidade.Aluno;

public class JanelaTabelaJLabel extends JFrame {
	
	public JanelaTabelaJLabel(Collection<Aluno> alunos) {
		super("Os Alunos");
		
		setLayout(new GridLayout(alunos.size(), 2));
		
		for(Aluno aluno: alunos) {
			JLabel labelId = new JLabel(aluno.getId());
			JLabel labelNome = new JLabel(aluno.getNome());
			add(labelId);
			add(labelNome);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pack();
		setVisible(true);
	}

}
