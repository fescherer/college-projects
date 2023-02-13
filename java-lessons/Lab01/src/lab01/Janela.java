package lab01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{

	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int height = screenSize.height;
	int width = screenSize.width;

	private JPanel panel;
	public Janela(){
		
		//Configurar um tamanho e onde a tela irá iniciar
		setSize(width/2, height/2); 
		setLocationRelativeTo(null);
		
		//Configurar o que fazer quando clicar no fechar
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tornar visivel
		setVisible(true);
		
		//Configurar um layout(O borderLayout preenche a tela inteira)
		setLayout(new BorderLayout());
		
		//Adicionar um panel
		panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.MAGENTA);
		
		//Adicionar um botão que muda de cor a cada clique
		JButton botao = new JButton("Mudar de cor");
		panel.add(botao,BorderLayout.CENTER);
		botao.addActionListener(new ButtonBehavior());
		
	
		
	}
	
	public class ButtonBehavior implements ActionListener{
		//Aqui entramos no conceito de inner class, aparentemente, se a classe está dentro de outra classe, ela consegue pegar os atributos da classe mae
		@Override
		public void actionPerformed(ActionEvent e) {
		this.trocaCor();
			
		}
		
		public void trocaCor() {
			Random rand = new Random();
			
			float corR = rand.nextFloat();
			float corG = rand.nextFloat();
			float corB = rand.nextFloat();
			panel.setBackground(new Color(corR, corG, corB));
		}
		

	}
	
}
