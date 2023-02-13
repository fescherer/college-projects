package ex04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com dois botões e um label contando quantas vezes cada um foi pressionado, separando as contagens. (a contagem não é compartilhada entre os dois botões)
	
	//Para acessar a label através da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	
	Janela(){
		//tamanho da janela
		setSize(400,400);
		
		//O que a janela faz ao clicar no x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicia no meio da tela
		setLocationRelativeTo(null);
		
		//tornar a janela visivel
		setVisible(true);
		
		//Fazer um container para o botão
		panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout());
		
		//Criar um botão
		JButton button1 = new JButton("Pressione");
		button1.addActionListener(new ButtonBehaviorInner());
		panel.add(button1);
		JButton button2 = new JButton("Pressione");
		panel.add(button2);
		button2.addActionListener(new ButtonBehaviorInner());
		
		//Cria um label
		label = new JLabel();
		panel.add(label);
		
	}
	
	class ButtonBehaviorInner implements ActionListener{
		int cont = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			cont++;
			label.setText(String.valueOf(cont));
			
		}
		
	}
}
