package tests;

import java.util.Collection;

import dao.InputInstance;
import entities.Board;
import entities.State;

public class TestChildren {

	
	public static void main(String[] args) {
		
		Board b = InputInstance.getInstance("files/inputInstance3x3.in");
		State s = new State(b,3);
		
		Collection<State> children = s.makeChildren();


		
		System.out.println("Original State: \n");
		System.out.println(s);
		
		System.out.println("\n----------------------------------------------------------------");
		
		System.out.println("Children");
		for(State c: children) {
			System.out.println(c);
			System.out.println("IS OBJECTIVE? " + c.isObjective());
			System.out.println("-----------------------------------------------------------");
		}
		}
}
