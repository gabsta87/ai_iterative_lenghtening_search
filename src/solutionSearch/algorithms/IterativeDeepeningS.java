package solutionSearch.algorithms;

import solutionSearch.Node;

public class IterativeDeepeningS{
	
	public static Answer getSolution(Node root){
		
		Answer solution = null;
		int depthLimit = 0;
		
		while(true){
			solution = DepthLimitedS.getSolution(root,depthLimit);
			depthLimit++;
			if(!solution.isCutOff()) {
				return solution;
			}
		}
	}

	public static String getName() {
		return "Iterative Deepening Search";
	}
}
