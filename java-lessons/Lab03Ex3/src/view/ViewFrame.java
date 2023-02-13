package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewFrame extends JFrame implements View{
	
	private static final long serialVersionUID = 1L;
	
	private String number1;
	private String number2;
	private String operator;
	
	JButton ButtonNumber0;
	JButton ButtonNumber1;
	JButton ButtonNumber2;
	JButton ButtonNumber3;
	JButton ButtonNumber4;
	JButton ButtonNumber5;
	JButton ButtonNumber6;
	JButton ButtonNumber7;
	JButton ButtonNumber8;
	JButton ButtonNumber9;
	
	JButton ButtonOperatorAddition;
	JButton ButtonOperatorSubtraction;
	JButton ButtonOperatorMultiplication;
	JButton ButtonOperatorDivision;
	
	JButton ButtonOperatorExponentiation;
	JButton ButtonOperatorSquareRoot;
	
	JButton ButtonParenteseRight;
	JButton ButtonParenteseLeft;
	
	JButton ButtonEqual;
	JButton ButtonErase;
	JButton ButtonDot;
	
	ButtonGroup bgNumbers;
	ButtonGroup bgOperators;
	
	JLabel labelVisor;
	
	public ViewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("Felipe's Calculator");
		
		JPanel panelVisor = new JPanel();
		add(panelVisor, BorderLayout.NORTH);
		panelVisor.setBackground(Color.gray);
		panelVisor.setLayout(new BorderLayout());
		
		labelVisor = new JLabel("Wellcome");
		labelVisor.setFont(new Font("Serif", Font.PLAIN, 60));
		panelVisor.add(labelVisor, BorderLayout.LINE_END);
		
		JLabel labelCalculation = new JLabel("Calculation");
		labelCalculation.setFont(new Font("Serif", Font.PLAIN, 40));
		panelVisor.add(labelCalculation, BorderLayout.NORTH);
		
		JPanel panelBottom = new PanelButtons();
		add(panelBottom, BorderLayout.CENTER);
		panelBottom.setBackground(Color.gray);
	}
	
	class PanelButtons extends JPanel{
		private static final long serialVersionUID = 1L;
		
		public PanelButtons() {
			setLayout(new GridLayout(5,4, 2, 2));
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			ButtonNumber0 = new JButton("0");
			ButtonNumber1 = new JButton("1");
			ButtonNumber2 = new JButton("2");
			ButtonNumber3 = new JButton("3");
			ButtonNumber4 = new JButton("4");
			ButtonNumber5 = new JButton("5");
			ButtonNumber6 = new JButton("6");
			ButtonNumber7 = new JButton("7");
			ButtonNumber8 = new JButton("8");
			ButtonNumber9 = new JButton("9");
			
			ButtonOperatorAddition = new JButton("+");
			ButtonOperatorSubtraction = new JButton("-");
			ButtonOperatorMultiplication = new JButton("*");
			ButtonOperatorDivision = new JButton("/");

			
			ButtonOperatorExponentiation = new JButton("^");
			ButtonOperatorSquareRoot = new JButton("SQR");
			
			ButtonParenteseRight = new JButton("(");
			ButtonParenteseLeft = new JButton(")");
			
			ButtonEqual = new JButton("=");
			ButtonErase = new JButton("C");
			ButtonDot = new JButton(".");
			
			JPanel panelParenteses = new JPanel();
			panelParenteses.setLayout(new GridLayout(1,2));
			panelParenteses.add(ButtonParenteseRight);
			panelParenteses.add(ButtonParenteseLeft);
			add(panelParenteses);
			
			add(ButtonOperatorSquareRoot);
			add(ButtonOperatorExponentiation);
			
			add(ButtonErase);
			
			add(ButtonNumber7);
			add(ButtonNumber8);
			add(ButtonNumber9);
			
			add(ButtonOperatorDivision);
			
			add(ButtonNumber4);
			add(ButtonNumber5);
			add(ButtonNumber6);
			
			add(ButtonOperatorMultiplication);
		
			add(ButtonNumber1);
			add(ButtonNumber2);
			add(ButtonNumber3);

			add(ButtonOperatorSubtraction);
			
			add(ButtonNumber0);
			add(ButtonDot);
			add(ButtonEqual);
			
			add(ButtonOperatorAddition);
			
			
		}
	}
	
	class buttonBehaviorteste implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			
		}
		
	}

	@Override
	public String getOperator() {
		
		//if()
		return "";
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
	public void setLabelText(String txt) {
		labelVisor.setText(txt);
	}

	@Override
	public void buttonBehavior(ActionListener al) {
		ButtonNumber0.addActionListener(al);
		ButtonNumber1.addActionListener(al);
		ButtonNumber2.addActionListener(al);
		ButtonNumber3.addActionListener(al);
		ButtonNumber4.addActionListener(al);
		ButtonNumber5.addActionListener(al);
		ButtonNumber6.addActionListener(al);
		ButtonNumber7.addActionListener(al);
		ButtonNumber8.addActionListener(al);
		ButtonNumber9.addActionListener(al);
		
		ButtonOperatorAddition.addActionListener(al);
		ButtonOperatorSubtraction.addActionListener(al);
		ButtonOperatorMultiplication.addActionListener(al);
		ButtonOperatorDivision.addActionListener(al);
		
		ButtonOperatorExponentiation.addActionListener(al);
		ButtonOperatorSquareRoot.addActionListener(al);
		
		ButtonParenteseRight.addActionListener(al);
		ButtonParenteseLeft.addActionListener(al);
		
		ButtonEqual.addActionListener(al);
		ButtonErase.addActionListener(al);
		ButtonDot.addActionListener(al);
		
	}
}