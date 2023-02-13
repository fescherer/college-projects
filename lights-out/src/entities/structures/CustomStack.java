package entities.structures;

import java.util.Stack;

import entities.State;

public class CustomStack implements StackQueueInterface{

	private Stack<State> elements = new Stack<>();

	@Override
	public void push(State estado) {
		this.elements.push(estado);
	}

	@Override
	public State pop() {
		return this.elements.pop();
	}

	@Override
	public int size() {
		return this.elements.size();
	}
	
}
