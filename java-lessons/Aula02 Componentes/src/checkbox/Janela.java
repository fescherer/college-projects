package checkbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Janela extends JFrame {
	
	JCheckBox opcaoVermelho = new JCheckBox("Vermelho");
	JCheckBox opcaoAzul = new JCheckBox("Azul");
	JCheckBox opcaoVerde = new JCheckBox("Verde");
	
	public Janela(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		add(opcaoVermelho);
		add(opcaoVerde);
		add(opcaoAzul);
		
//		opcaoVermelho.addActionListener(new ComportamentoCheckBox());
//		opcaoVerde.addActionListener(new ComportamentoCheckBox());
//		opcaoAzul.addActionListener(new ComportamentoCheckBox());
		
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
