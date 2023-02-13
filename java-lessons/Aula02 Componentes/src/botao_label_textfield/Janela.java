package botao_label_textfield;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JTextField field = new JTextField(20);
	
	public Janela() {
		
		//setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("etiqueta");
		add(label);
		
		add(field);
		field.addActionListener(new ComportamentoTextField());
		
		JButton botao = new JButton("Aperte");
		add(botao);
		botao.addActionListener(new ComportamentoTextField());
		
		
		pack();
		setVisible(true);
	}
	
	class ComportamentoTextField implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String messageField = field.getText();
			System.out.println("Escrito no TextField: " + messageField);
			
		}
		
	}

}
