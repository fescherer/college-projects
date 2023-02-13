package view.view_janela;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;

import entidade.Aluno;
import view.View;

public class ViewJanela extends JFrame implements View{
	
	private JButton botaoListar;
	
	public ViewJanela() {
		super("Janela Alunos");
		
		setLayout(new FlowLayout());
		
		botaoListar = new JButton("Listar Os Alunos");
		add(botaoListar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}

	@Override
	public void listar(Collection<Aluno> alunos) {
		new JanelaTabelaJLabel(alunos);
	}

	@Override
	public void addListenerListar(ActionListener listenerListar) {
		botaoListar.addActionListener(listenerListar);
	}

}
