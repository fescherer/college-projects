package ex08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com dois botões e um label contando quantas vezes cada um foi pressionado, separando as contagens. (a contagem não é compartilhada entre os dois botões)
	
	//Para acessar a label através da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	JRadioButton amarelo;
	JRadioButton vermelho;
	JRadioButton verde;
	
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
		JButton button = new JButton("Pressione");
		button.addActionListener(new ButtonBehaviorInner());
		panel.add(button);
		
		//Cria radioButtons
		ButtonGroup coresBG = new ButtonGroup();
		amarelo = new JRadioButton("Amarelo");
		vermelho = new JRadioButton("Vermelho");
		verde = new JRadioButton("Verde");
		
		panel.add(amarelo);
		panel.add(vermelho);
		panel.add(verde);
		
		coresBG.add(amarelo);
		coresBG.add(vermelho);
		coresBG.add(verde);
		
		//Cria um label
		label = new JLabel();
		panel.add(label);
		
	}
	
	class ButtonBehaviorInner implements ActionListener{
		String color;
		@Override
		public void actionPerformed(ActionEvent e) {
			if(amarelo.isSelected()) {color = "Amarelo";}
			else if(verde.isSelected()) {color = "Verde";}
			else if(vermelho.isSelected()) {color = "Vermelho";}
			label.setText(color);
			
		}
		
	}
}
