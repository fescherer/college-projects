package teste;



import controller.Controller;
import model.Model;
import model.ModelCalculator;
import view.View;
import view.ViewJFrame;

public class Teste {


	public static void main(String[] args) {
		View view = new ViewJFrame();
		Model model = new ModelCalculator();
		Controller c = new Controller(model, view);
		
		System.out.println(model.calculate(3, 4, "+"));
		
	}
}
