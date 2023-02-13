package testes;

import main.Faculdade;
import menu.Controller;
import menu.View;

public class TesteMenu {
	public static void main(String[] args) throws Exception {
		
		Faculdade Unip = new Faculdade();
		
		Controller c = new Controller(new View());
		c.init(Unip);
	
	}
}
