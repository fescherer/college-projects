package teste;

import controller.Controller;
import model.MeuModelCSV;
import view.view_janela.ViewJanela;
import view.view_jtable.*;

public class TesteController {
	
	public static void main(String[] args) {
		new Controller(new MeuModelCSV(), new JanelaJTable());
	}

}
