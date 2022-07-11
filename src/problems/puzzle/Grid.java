package problems.puzzle;

import java.util.LinkedList;
import java.util.List;

import solutionSearch.Action;

public class Grid implements Cloneable{
	private int[][] data;
	
	public Grid() {
		data = new int[3][];
		data[0]=new int[3];
		data[1]=new int[3];
		data[2]=new int[3];
		
		int counter = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				data[i][j] = counter++;
			}
		}
		data[0][0] = Square.EMPTY;
	}

	public int getValue(int x, int y) {
		return data[y][x];
	}
	
	public Coordinates getEmptySquareCoordinates() {
		Coordinates coords = new Coordinates();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == Square.EMPTY) {
					coords.x = j;
					coords.y = i;
					return coords;
				}
			}
		}
		return null;
	}
	
	public List<Action> getAvailableActions() {
		List<Action> result = new LinkedList<Action>();
		
		if(getEmptySquareCoordinates().y > 0)
			result.add(new MovePiece(Direction.UP));
		
		if(getEmptySquareCoordinates().y < 2)
			result.add(new MovePiece(Direction.DOWN));
	
		if(getEmptySquareCoordinates().x < 2)
			result.add(new MovePiece(Direction.RIGHT));
	
		if(getEmptySquareCoordinates().x > 0)
			result.add(new MovePiece(Direction.LEFT));
			
		return result;
	}

	public boolean movePieceFrom(Direction dir) {
		Coordinates destinationCoordinates = getEmptySquareCoordinates();
		
		switch(dir) {
		case UP:
			if(getEmptySquareCoordinates().y == 0)
				return false;
			destinationCoordinates.y--;
			break;
		case DOWN:
			if(getEmptySquareCoordinates().y == 2)
				return false;
			destinationCoordinates.y++;
			break;
		case RIGHT:
			if(getEmptySquareCoordinates().x == 2)
				return false;
			destinationCoordinates.x++;
			break;
		case LEFT:
			if(getEmptySquareCoordinates().x == 0)
				return false;
			destinationCoordinates.x--;
			break;
		}
		
		data[getEmptySquareCoordinates().y][getEmptySquareCoordinates().x] = data[destinationCoordinates.y][destinationCoordinates.x];
		data[destinationCoordinates.y][destinationCoordinates.x] = Square.EMPTY;
		
		return true;	
	}
	
	public String toString() {
		String result = ""+System.lineSeparator();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				result+=(data[i][j]==0 ? " " : data[i][j]);
			}
			result+=System.lineSeparator();
		}
//		result += "empty square : [x="+getEmptySquareCoordinates().x+",y="+getEmptySquareCoordinates().y+"]";
		return result;
	}
	
	@Override
	public Grid clone() {
		Grid result = new Grid();
		result.data = new int[data.length][];
		
		for(int i = 0; i < result.data.length; i++) {
			result.data[i] = new int[data[i].length];
			
			for(int j = 0; j < data[i].length; j++) {
				result.data[i][j] = data[i][j];
			}
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!this.getClass().isInstance(o))
			return false;

		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(getValue(j, i) != ((Grid)o).getValue(j, i))
					return false;
			}
		}
		return true;
	}
}
