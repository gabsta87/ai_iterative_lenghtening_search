package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import problems.puzzle.PuzzleProblem;
import solutionSearch.Node;
import solutionSearch.algorithms.Answer;
import solutionSearch.algorithms.IterativeDeepeningS;
import solutionSearch.algorithms.Success;

class IDSTesterPuzzle {

	@Test
	void test() {
		PuzzleProblem p = new PuzzleProblem();
		p.randomizeGrid(40);
		
		assertFalse(p.isSolved());
		
		System.out.println("Initial problem");
		System.out.println(p);
		System.out.println();
		
		Answer ans = IterativeDeepeningS.getSolution(new Node(p));
		
		if(!ans.isSuccess()) {
			System.out.println("No solution was found");
		}else {
			Success solution = (Success)ans;
			System.out.println("A solution was found in "+ solution.getSolution().size() +" steps");
			
			for(Node n : solution.getSolution()) {
				System.out.println(n);
			}
		}
	}

}
