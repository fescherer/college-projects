package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {

	private Model model;
	private View view;
	private String buttonContent;
	private boolean isNumber2 = false;
	private String visor = "Wellcome";
	private String number1 = "", number2 = "", operator = "";
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		this.init();
	}
	
	public void init(){
		view.setShowResultListener(new CalculateBehavior());
		view.buttonBehavior(new ButtonBehavior());
	}
	
	public String calculate() {
		return String.valueOf(model.calculate(Integer.parseInt(number1), Integer.parseInt(number2), operator));
	}
	
	class CalculateBehavior implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.showResult(model.calculate(view.getNumber1(), view.getNumber2(), view.getOperator()));
		}
		
	}
	
	class ButtonBehavior implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonContent = e.getActionCommand();
			char lastChar = visor.charAt(visor.length() - 1);
			
			if(buttonContent.charAt(0) >= '0' && buttonContent.charAt(0) <= '9') {
				//Is number
				if(!isNumber2) {
					number1 += buttonContent;
					visor = number1;
				} else {
					number2 += buttonContent;
					visor = number2;
				}
				
			} else if(buttonContent.equals("+")) {
				if(visor != "Wellcome") {
					operator = "+";
					if(lastChar != '+')
						visor = visor + "+";
					isNumber2 = true;
	
					if(number2 != "") {
						number1 = calculate();
						number2 = "";	
						visor = number1 + "+";
					}
				}
				
			}else if (buttonContent.equals("-")) {
				if(visor != "Wellcome") {
					operator = "-";
					if(lastChar != '-' && lastChar != '+')
						visor = visor + "-";
					isNumber2 = true;
	
					if(number2 != "") {
						number1 = calculate();
						number2 = "";	
						visor = number1 + "-";
					}
				}				
				
				
			} else if(buttonContent.equals("=")) {
				

				if(visor != "Wellcome" && lastChar != '+' && lastChar != '-' &&
						lastChar != '/' && lastChar != '*' ) {
				visor = calculate();
				}
			} else if(buttonContent.equals("C")) {
				number1  = ""; number2  = ""; operator = "";
				visor = "Wellcome";
				isNumber2 = false;
				}
				
			
			
			view.setLabelText(visor);
			System.out.println(number1);
			System.out.println(number2);
			
		}
		
		
	
	}
	
}
	


	
