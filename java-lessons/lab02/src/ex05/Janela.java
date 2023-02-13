package ex05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com um textfield e um label. Quando o usuário escrever qualquer coisa no textfield e apertar “Enter”. O label deve atualizar para “frase: x”, onde x é o texto entrado pelo usuário.
	
	//Para acessar a label através da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	//Criar um texfield
	JTextField textField = new JTextField(20);
	
	Janela(){
		//tamanho da janela
		setSize(400,400);
		
		//O que a janela faz ao clicar no x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicia no meio da tela
		setLocationRelativeTo(null);
		
		//tornar a janela visivel
		setVisible(true);
		
		//Fazer um container para o texfield e label
		panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout());
		
		//Adicionar metodos ao textField
		textField.addActionListener(new TextFieldListener());
		panel.add(textField);
		
		
		//Cria um label
		label = new JLabel();
		panel.add(label);
		
	}
	
	class TextFieldListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String txt = textField.getText();
			label.setText(txt);
		}
		
	}
}
