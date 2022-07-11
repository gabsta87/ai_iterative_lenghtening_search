package problems.dustCleaner;

import java.util.List;

import solutionSearch.Action;
import solutionSearch.Problem;

public class DustProblem extends Problem {
	private Grid grid;
	
	public DustProblem(int size) {
		this.grid = new Grid(size);
	}

	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Action> getAvailableActions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Problem clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
