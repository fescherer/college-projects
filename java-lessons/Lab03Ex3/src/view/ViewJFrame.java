package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ViewJFrame extends JFrame implements View{
	
	private static final long serialVersionUID = 1L;
	
	public ViewJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		JPanel panelVisor = new JPanel();
		add(panelVisor, BorderLayout.NORTH);
		panelVisor.setBackground(Color.gray);
		panelVisor.setLayout(new BorderLayout());
		
		JLabel labelVisor = new JLabel("Wellcome");
		labelVisor.setFont(new Font("Serif", Font.PLAIN, 60));
		panelVisor.add(labelVisor, BorderLayout.LINE_END);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.CENTER);
		panelButton.setBackground(Color.MAGENTA );
		panelButton.setLayout(new BorderLayout());
		
		JPanel panelUpper = new JPanel();
		panelUpper.setBackground(Color.DARK_GRAY);
		panelUpper.setLayout(new GridLayout(1,2));
		panelButton.add(panelUpper, BorderLayout.NORTH);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(Color.white);
		panelButton.add(panelBottom, BorderLayout.CENTER);
		
		JPanel panelButtonAdvancedOperations = new JPanel();
		panelButtonAdvancedOperations.setLayout(new GridLayout(1,2));
		panelUpper.add(panelButtonAdvancedOperations);
		JButton buttonSquareRoot = new JButton("SQR");
		JButton buttonPower = new JButton("^");
		panelButtonAdvancedOperations.add(buttonSquareRoot);
		panelButtonAdvancedOperations.add(buttonPower);
		panelButtonAdvancedOperations.setBackground(Color.orange);
		
		JPanel panelButtonParenteses = new JPanel();
		panelButtonParenteses.setLayout(new GridLayout(1,2));
		panelUpper.add(panelButtonParenteses);
		JButton ButtonParenthesesLeft = new JButton(")");
		JButton ButtonParenthesesRight = new JButton("(");
		panelButtonParenteses.add(ButtonParenthesesLeft);
		panelButtonParenteses.add(ButtonParenthesesRight);
		panelButtonParenteses.setBackground(Color.cyan);
		
		JPanel panelButtonNumbers = new JPanel();
		panelButtonNumbers.setLayout(new GridLayout(3,5));
		panelBottom.add(panelButtonNumbers);
		JButton ButtonNumber7 = new JButton("7");
		panelButtonNumbers.add(ButtonNumber7);
		JButton ButtonNumber8 = new JButton("8");
		panelButtonNumbers.add(ButtonNumber8);
		JButton ButtonNumber9 = new JButton("9");
		panelButtonNumbers.add(ButtonNumber9);
		JButton ButtonNumber4 = new JButton("4");
		panelButtonNumbers.add(ButtonNumber4);
		JButton ButtonNumber5 = new JButton("5");
		panelButtonNumbers.add(ButtonNumber5);
		JButton ButtonNumber6 = new JButton("6");
		panelButtonNumbers.add(ButtonNumber6);
		JButton ButtonNumber1 = new JButton("1");
		panelButtonNumbers.add(ButtonNumber1);
		JButton ButtonNumber2 = new JButton("2");
		panelButtonNumbers.add(ButtonNumber2);
		JButton ButtonNumber3 = new JButton("3");
		panelButtonNumbers.add(ButtonNumber3);
		panelButtonNumbers.setBackground(Color.red);
		
		JPanel panelButtonBasicOperations = new JPanel();
		panelBottom.add(panelButtonBasicOperations, BorderLayout.CENTER);
		JButton ButtonOperationDivided = new JButton("/");
		panelButtonBasicOperations.add(ButtonOperationDivided);
		
		panelButtonBasicOperations.setBackground(Color.green);
		

		pack();
	}
	
	class PanelWithThreeElements extends JPanel{
		private static final long serialVersionUID = 1L;
		
		public PanelWithThreeElements(JButton button1, JButton button2, JButton button3) {
		
		}
	}

	@Override
	public String getOperator() {
		
		return null;
	}
	
	@Override
	public int getNumber1() {
		return 0;
	}
	
	@Override
	public int getNumber2() {
		return 0;
	}
	
	@Override
	public void showResult(int result) {
		
	}
	
	@Override
	public void setShowResultListener(ActionListener ActionListener) {
		
	}

	@Override
	public void buttonBehavior(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLabelText(String txt) {
		// TODO Auto-generated method stub
		
	}
}