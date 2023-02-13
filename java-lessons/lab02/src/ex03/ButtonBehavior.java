package ex03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBehavior implements ActionListener{
	int cont = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		cont++;
		System.out.println("Botão pressionado " + cont + " vezes.");
		
	}

}
