package view;

import java.awt.event.ActionListener;

public interface View {

	
	public String getOperator();
	
	public int getNumber1();
	
	public int getNumber2();
	
	public void showResult(int result);
	
	public void setShowResultListener(ActionListener ActionListener);
	
	public void buttonBehavior(ActionListener al);
	
	public void setLabelText(String txt);
}
