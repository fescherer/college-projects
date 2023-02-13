package init;

import main.Faculdade;
import menu.Controller;
import menu.View;

public class InitProgram {


	public static void main(String[] args) throws Exception {
		
		Faculdade Amazonia = new Faculdade();
		
		Controller c = new Controller(new View());
		c.init(Amazonia);
	
	}
	
}
