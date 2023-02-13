package teste;

import model.MeuModelCSV;
import model.Model;
import view.view_janela.JanelaTabelaJLabel;

public class TesteJanelaTabelaImprovisadaAlunos {
	
	public static void main(String[] args) {
		Model model = new MeuModelCSV();
		
		
		new JanelaTabelaJLabel(model.loadAlunos());
	}

}
