package radiobutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Janela extends JFrame {
	
	JRadioButton opcaoVermelho = new JRadioButton("Vermelho");
	JRadioButton opcaoAzul = new JRadioButton("Azul");
	JRadioButton opcaoVerde = new JRadioButton("Verde");
	
	public Janela(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(opcaoVermelho);
		bg.add(opcaoVerde);
		bg.add(opcaoAzul);
		
		add(opcaoVermelho);
		add(opcaoVerde);
		add(opcaoAzul);
		
		JButton botao = new JButton("Verifica");
		botao.addActionListener(new ComportamentoCheckBox());
		add(botao);
		
		
		pack();
		setVisible(true);
	}
	
	class ComportamentoCheckBox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println();
			System.out.println("Opções:");
			if(opcaoVermelho.isSelected()) {System.out.println("Vermelho");}
			if(opcaoVerde.isSelected()) {System.out.println("Verde");}
			if(opcaoAzul.isSelected()) {System.out.println("Azul");}
			System.out.println();
		}
		
	}

}
