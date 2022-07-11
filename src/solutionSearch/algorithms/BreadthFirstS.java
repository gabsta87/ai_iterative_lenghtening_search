package solutionSearch.algorithms;

import java.util.LinkedList;
import java.util.List;

import solutionSearch.Node;

public class BreadthFirstS {

	// This algorithm's implementation has not yet been tested
	public static Answer getSolution(Node startNode) {
		
		if (startNode.isSolved())
			return new Success(startNode);
		
		List<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new LinkedList<Node>();
		Node actualNode = startNode;
		Node[] children = startNode.exploreNode();
		
		frontier.add(actualNode);
		
		while(!frontier.isEmpty()){

			actualNode = frontier.remove(0);
			explored.add(actualNode);
			
			children = actualNode.exploreNode();
			
			for(Node n : children) {
				if(!frontier.contains(n) || !explored.contains(n)) {
					if (n.isSolved())
						return new Success(actualNode);
					frontier.add(n);
				}
			}
			
		}
		
		return new Failure();
	}
}
