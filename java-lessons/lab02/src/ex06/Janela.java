package ex06;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com dois textfields, um label e um botão. Um textfield deve representar o nome, e o outro o sobrenome do usuário. Quando o usuário apertar o botão deve aparecer uma mensagem de comprimento “Olá " para o usuário.
	
	//Para acessar a label através da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	
	//Criar dois texfields
	JTextField textField1 = new JTextField("Nome", 20);
	JTextField textField2 = new JTextField("Sobrenome", 20);
	
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
		
		//Cria um botão
		JButton button = new JButton("Pressione");
		panel.add(button);
		button.addActionListener(new ButtonBehavior());
		
		//Adicionar metodos ao textField
		panel.add(textField1);
		panel.add(textField2);
		textField1.setForeground(Color.GRAY);
		textField2.setForeground(Color.GRAY);
		textField1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField1.getText().equals("Nome")) {
					textField1.setText("");
					textField1.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(textField1.getText().isEmpty()) {
					textField1.setText("Nome");
					textField1.setForeground(Color.GRAY);
				}
				
			}
		});
		
		textField2.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField2.getText().equals("Sobrenome")) {
					textField2.setText("");
					textField2.setForeground(Color.BLACK);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField2.getText().isEmpty()) {
					textField2.setText("Sobrenome");
					textField2.setForeground(Color.GRAY);
				}
				
			}
			
		});
		
		
		
		//Cria um label
		label = new JLabel();
		panel.add(label);
		
	}
	
	class ButtonBehavior implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = textField1.getText();
			String sobrenome = textField2.getText();
			if(!nome.equals("Nome") && !sobrenome.equals("Sobrenome")) {
				label.setText("Olá " + nome + " " + sobrenome + "!");
			}
		}
		
	}
	
}
