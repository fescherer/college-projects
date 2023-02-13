package botao_label_passwordfield;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Janela extends JFrame {
	
	JPasswordField passField = new JPasswordField(20);
	
	public Janela() {
		
		//setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("etiqueta");
		add(label);
		
		add(passField);
		passField.addActionListener(new ComportamentoTextField());
		
		JButton botao = new JButton("Aperte");
		add(botao);
		botao.addActionListener(new ComportamentoTextField());
		
		
		pack();
		setVisible(true);
	}
	
	class ComportamentoTextField implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			char[] pass = passField.getPassword();
			System.out.println("Escrito no TextField: " + pass);
			for(int i=0; i<pass.length; i++) {
				pass[i] = '0';
			}
			
		}
		
	}

}
