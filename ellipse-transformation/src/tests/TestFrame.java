package tests;

import javax.swing.SwingUtilities;

import controller.ControllerDesktop;

public class TestFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	public static void createAndShowGUI() {
		new ControllerDesktop();
	}

	
}
