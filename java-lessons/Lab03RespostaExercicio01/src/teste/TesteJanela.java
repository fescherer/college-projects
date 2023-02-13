package teste;

import controller.Controller;
import model.ModelCSV;
import view.janela.Janela;
import view.janela_simples.JanelaSimples;

public class TesteJanela {
	
	public static void main(String[] args) {
		new Controller(new Janela(), new ModelCSV());
	}

}
