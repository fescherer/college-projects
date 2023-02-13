package view.janela_simples;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JanelaCadastrar extends JFrame {
	
	JTextField tfId = new JTextField("Id", 20);
	JTextField tfNome = new JTextField("Nome", 20);
	JTextField tfValor = new JTextField("Valor", 20);
	
	JButton botaoConfirmar = new JButton("Confirmar");
	
	public JanelaCadastrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new GridLayout(4, 1));
		
		add(tfId);
		add(tfNome);
		add(tfValor);
		add(botaoConfirmar);
		
		pack();
		setVisible(true);
	}
	
	public int    getId()    {return Integer.parseInt(tfId.     getText());}
	public String getNome()  {return                  tfNome.   getText();}
	public double getValor() {return Double.parseDouble(tfValor.getText());}
	
	public void setCadastrarListener(ActionListener al) {
		botaoConfirmar.addActionListener(al);
	}

}
