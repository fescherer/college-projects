package entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entities.structures.StackQueueInterface;

public class Solver {

	 private State inicialState;
	 private StackQueueInterface states;
	 private Set<State> closedStates;
	
	 
	 public Solver(State aInicialState, StackQueueInterface aStackQueueInterface) {
		 this.inicialState = aInicialState;
		 this.states = aStackQueueInterface;
		 this.states.push(this.inicialState);
		 closedStates = new HashSet<>();
	 }
	
	 public State solve() {
		 
		 while(states.size()>0) {

			 State s = states.pop();
			 System.out.println(s);
			 if(s.isObjective()) {
				 return s;
			 }
			 
			 if(!closedStates.contains(s)) 
				 closedStates.add(s);
			 
			 System.out.println("Closed States size : " + closedStates.size());
			 	 
			 Collection<State> children = s.makeChildren();
			 for(State child: children) {
				 if(!closedStates.contains(child))
					 states.push(child); 
			 }


		 }
		 System.out.println("This board doesn't have a solution");
		 return null;
	 }

	public Set<State> getClosedStates() {
		return closedStates;
	}
	 
}
