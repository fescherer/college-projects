package tests;

import dao.InputInstance;
import entities.Solver;
import entities.State;
import entities.structures.CustomQueue;

public class TesteSolver {

	public static void main(String[] args) {
		
		State inititalState = new State(InputInstance.getInstance("files/inst_4_0001.in"), InputInstance.initialBoardType);
		System.out.println("----------------------------------------");
		System.out.println("Initital State:");
		System.out.println(inititalState);
		System.out.println("----------------------------------------");
		
		
		Solver solver = new Solver(inititalState, new CustomQueue());
		State answer = solver.solve();
		System.out.println("----------------------------------------");
		System.out.println("Initital State: ");
		System.out.println(inititalState);
		System.out.println("----------------------------------------");
		System.out.println("Solution: ");
		System.out.println(answer);
		System.out.println("----------------------------------------");
		System.out.println("Closed States: " + solver.getClosedStates().size());	
	}
}
