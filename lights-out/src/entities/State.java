package entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;



public class State {

	private Board board;
	private List<List<Integer>> tilesPressed;
	private int boardType;
	
	public State(Board aBoard, int boardType) {
		this.board = aBoard;
		this.boardType = boardType;
		this.tilesPressed = new LinkedList<>();
	}
	
	public State(Board aBoard, int boardType, List<List<Integer>> tilesPressed) {
		this.board = aBoard;
		this.tilesPressed = tilesPressed;
		this.boardType = boardType;
	}
	
	public boolean isObjective() {
		
		if(this.equals(ObjectiveState.OBJECTIVESTATE3X3) && boardType == 3)
			return true;
		else if(this.equals(ObjectiveState.OBJECTIVESTATE4X4) && boardType == 4)
			return true;
		return false;
		
	}
	
	public Collection<State> makeChildren(){
		
		Collection<State> children = new ArrayList<>();
		
		for(int i=0; i<boardType; i++) {
			for(int j=0; j<boardType; j++) {
				State child = this.deepCopy();
				List<Integer> list = new ArrayList<>();
				list.add(i);
				list.add(j);
				child.pressATile(list);
				children.add(child);
			}
		}
		return children;
	}
	
	public State deepCopy() {
		List<List<Integer>> tilesPressedCopied = new LinkedList<>(this.tilesPressed);
		return new State(this.board.deepCopy(),boardType, tilesPressedCopied);
	}
	
	public void pressATile(List<Integer> tile) {
		this.tilesPressed.add(tile);
		this.board.pressATile(tile);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String res = "\n";
		res += "State level: " + this.tilesPressed.size() + "\n";
		res += this.board + "\n";
		for(int i=0; i<this.tilesPressed.size(); i++) {
			res += this.tilesPressed.get(i) + "; ";
		}
		
		return res;
	}
	
	
}
