package problems.puzzle;

import java.util.List;

import solutionSearch.Action;
import solutionSearch.Problem;

public class PuzzleProblem extends Problem{
	private Grid grid;
	
	public PuzzleProblem() {
		this.grid = new Grid();
	}
	
	private PuzzleProblem(Grid grid) {
		this.grid = grid;
	}
	
	public void randomizeGridAuto() {
		int i = (int) (20 + Math.random() * 50);
		randomizeGrid(i);
	}
	
	public void randomizeGrid(int i) {
		
		for(int j = 0; j < i; j++) {
			int direction = (int) (Math.random()*4);
			switch(direction) {
				case 0:
					this.grid.movePieceFrom(Direction.DOWN);
					break;
				case 1:
					this.grid.movePieceFrom(Direction.UP);
					break;
				case 2:
					this.grid.movePieceFrom(Direction.LEFT);
					break;
				case 3:
					this.grid.movePieceFrom(Direction.RIGHT);
					break;
			}
		}
	}
	
	Grid getGrid() {
		return this.grid;
	}
	
	public boolean isSolved() {
		if(grid.getValue(0,0) != Square.EMPTY)
			return false;
		
		int counter = 0;
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(counter == grid.getValue(j, i))
					counter++;
			}
		}
		
		return counter == 9;
	}
	
	@Override
	public PuzzleProblem clone() {
		return new PuzzleProblem(grid.clone());
	}

	@Override
	public List<Action> getAvailableActions() {
		return grid.getAvailableActions();
	}

	@Override
	public boolean equals(Object o) {
		if(!this.getClass().isInstance(o))
			return false;
		
		return grid.equals(((PuzzleProblem)o).grid);
	}
	
	@Override
	public String toString() {
		return grid.toString();
	}
}
