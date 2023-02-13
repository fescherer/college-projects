package entities.structures;

import entities.State;

public interface StackQueueInterface {

	public void push(State estado);
	public State pop();
	public int size();
}
