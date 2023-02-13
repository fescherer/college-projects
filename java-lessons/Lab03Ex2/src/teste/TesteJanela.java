package teste;

import controller.Controller;
import model.ModelCSV;
import view.JanelaJtable;

public class TesteJanela {
	public static void main(String[] args) {
		new Controller(new JanelaJtable(), new ModelCSV());
	}
}
