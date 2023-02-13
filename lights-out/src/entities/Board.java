package entities;

import java.util.Arrays;
import java.util.List;

public class Board {

	int[][] tiles;
	int boardType;
	
	public Board(int[][] tiles, int aBoardType) {
		this.tiles = tiles;
		this.boardType = aBoardType;
	}
	
	public int[][] getTiles() {
		return tiles;
	}

	public int getBoardType() {
		return boardType;
	}

	public Board deepCopy() {
		int[][] tilesCopied = new int[boardType][boardType];
		
		for(int i=0; i<boardType; i++) {
			for(int j=0; j<boardType; j++) {
				tilesCopied[i][j] = this.tiles[i][j];
			}
		}
		return new Board(tilesCopied, boardType);
	}
	
	public void pressATile(List<Integer> tile) {
		int row = tile.get(0); 
		int column = tile.get(1);
		
		boolean up = true;
		boolean down = true;
		boolean right = true;
		boolean left = true;
		
		if(row == 0)
			up = false;
		//We cannot use else if, because the tile can be in a corner, 
		//so if we use else if, only one of the variables will turn off   	
		if(row == this.boardType-1)
			down = false;
		if(column == 0)
			left = false; 
		if(column == this.boardType-1) {
			right = false;
		}
		
		//First let's change the proper tile
		if(this.tiles[row][column] == 0) {
			this.tiles[row][column] = 1;
		} else {
			this.tiles[row][column] = 0;
		}
		
		//Change the adjacent tiles
		if(up) {
			if(this.tiles[row-1][column] == 0) {
				this.tiles[row-1][column] = 1;
			} else {
				this.tiles[row-1][column] = 0;
			}
		}
		
		if(down) {
			if(this.tiles[row+1][column] == 0) {
				this.tiles[row+1][column] = 1;
			} else {
				this.tiles[row+1][column] = 0;
			}
		}
		
		if(right) {
			if(this.tiles[row][column+1] == 0) {
				this.tiles[row][column+1] = 1;
			} else {
				this.tiles[row][column+1] = 0;
			}
		}
		
		
		if(left) {
			if(this.tiles[row][column-1] == 0) {
				this.tiles[row][column-1] = 1;
			} else {
				this.tiles[row][column-1] = 0;
			}
		}
		
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(int i=0; i<this.getBoardType(); i++) {
			for(int j=0; j<this.getBoardType(); j++) 
				res += this.getTiles()[i][j] + " ";
			res += "\n";
		}
		
		return res;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardType;
		result = prime * result + Arrays.deepHashCode(tiles);
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
		Board other = (Board) obj;
		if (!Arrays.deepEquals(tiles, other.tiles))
			return false;
		return true;
	}

	
	
}
