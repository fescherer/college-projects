package model;

public class ModelCalculator implements Model{

	private int result;

	@Override
	public int calculate(int number1, int number2, String operator) {
		
		switch(operator) {
		case "+":
			result = number1 + number2;
			break;
			
		case "-":
			result = number1 - number2;
			break;
			
		case "*":
			result = number1 * number2;
			break;
			
		case "/":
			result = number1 / number2;
			break;
			
		default:
			System.out.println("Unknow Operator");
			break;
		}
		
		return result;
	}

}
