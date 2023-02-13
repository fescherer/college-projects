package tests;


import dao.InputInstance;
import entities.Board;
import entities.ObjectiveState;
import entities.State;

public class TestEqualsInstance {

	public static void main(String[] args) {
		
		Board b1 = InputInstance.getInstance("files/inputInstance4x4.in");
		State s1 = new State(b1, b1.getBoardType());
		System.out.println("Instance: ");
		System.out.println(s1);
		System.out.println(s1.isObjective());
		
		System.out.println("------------------------------------------------------");
		
		Board b2 = InputInstance.getInstance("files/inputInstance4x4Objective.in");
		State s2 = new State(b2, b2.getBoardType());
		System.out.println("Instance: ");
		System.out.println(s2);
		System.out.println(s2.isObjective());
		
		System.out.println("------------------------------------------------------");
		
		Board b3 = InputInstance.getInstance("files/inputInstance3x3.in");
		State s3 = new State(b3, b3.getBoardType());
		System.out.println("Instance: ");
		System.out.println(s3);
		System.out.println(s3.isObjective());
		
		System.out.println("------------------------------------------------------");
		
		Board b4 = InputInstance.getInstance("files/inputInstance3x3Objective.in");
		State s4 = new State(b4, b4.getBoardType());
		System.out.println("Instance: ");
		System.out.println(s4);
		System.out.println(s4.isObjective());
		
		System.out.println("------------------------------------------------------");
	}
	
}
