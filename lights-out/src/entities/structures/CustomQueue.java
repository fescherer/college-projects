package entities.structures;

import java.util.LinkedList;
import java.util.Queue;

import entities.State;

public class CustomQueue implements StackQueueInterface{

	Queue<State> elements = new LinkedList<>();

	@Override
	public void push(State estado) {
		elements.add(estado);
	}

	@Override
	public State pop() {
		return elements.poll();
	}

	@Override
	public int size() {
		return elements.size();
	}
}
