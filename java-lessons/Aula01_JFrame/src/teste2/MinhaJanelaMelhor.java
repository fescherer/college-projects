package teste2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MinhaJanelaMelhor extends JFrame{
	//O certo de fazer uma janela é personalizando ela, ou seja, usando o extends JFrame
	
	public MinhaJanelaMelhor() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JPanel esquerda = new JPanel();
		esquerda.setBackground(Color.CYAN);
		add(esquerda, BorderLayout.LINE_START);
		JButton oi = new JButton("Oi");
		esquerda.add(oi);
		oi.addActionListener(new ButtonBehavior());
		
		
		JPanel direita = new JPanel();
		direita.setBackground(Color.MAGENTA);
		add(direita, BorderLayout.LINE_END);
		direita.add(new JButton("Tchau"));
	}
	
	private static final long serialVersionUID = 1L;
	
}
