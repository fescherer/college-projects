package teste;

import controller.Controller;
import model.ModelCalculator;
import view.ViewFrame;
import view.ViewJFrame;

public class RealTest {
	public static void main(String[] args) {
		new Controller(new ModelCalculator(), new ViewFrame());
	}
}
