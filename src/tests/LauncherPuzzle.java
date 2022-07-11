package tests;

import problems.puzzle.PuzzleProblem;
import solutionSearch.Node;
import solutionSearch.algorithms.Answer;
import solutionSearch.algorithms.IterativeDeepeningS;
import solutionSearch.algorithms.Success;
import solutionSearch.algorithms.UniformCostS;

public class LauncherPuzzle {

	public static void main(String[] args) {
		PuzzleProblem p = new PuzzleProblem();
		p.randomizeGridAuto();
		
		String algoName;
		long startTime,endTime;

		algoName = UniformCostS.getName();
		System.out.println("Trying "+algoName);
		startTime = System.currentTimeMillis();
		Answer b = UniformCostS.getSolution(new Node(p));
		endTime = System.currentTimeMillis();
		System.out.println("Execution took "+(endTime-startTime)/1000+" s");
		examineSolution(p, b,algoName);
		
		algoName = IterativeDeepeningS.getName();
		System.out.println("Trying "+algoName);
		startTime = System.currentTimeMillis();
		Answer c = IterativeDeepeningS.getSolution(new Node(p));
		endTime = System.currentTimeMillis();
		System.out.println("Execution took "+(endTime-startTime)/1000+" s");
		examineSolution(p, c,algoName);
	}
	
	private static void examineSolution(PuzzleProblem p, Answer a, String algorithmName) {
		if(!a.isSuccess()) {
			System.out.println("No solution was found");
		}else {
			Success solution = (Success)a;
			System.out.println("A solution was found in  "+ ((Success)solution).getSolution().size()+" steps");
			
			for(Node n : solution.getSolution()) {
				System.out.println(n);
			}
			
		}
	}

}
