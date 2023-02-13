package teste2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBehavior implements ActionListener{
	int cont = 0;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		cont++;
		System.out.println("Botao pressionado " + cont + " vezes");
	}
	

}
