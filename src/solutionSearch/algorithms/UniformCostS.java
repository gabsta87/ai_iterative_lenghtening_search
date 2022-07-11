package solutionSearch.algorithms;

import java.util.LinkedList;
import java.util.List;

import solutionSearch.Node;

public class UniformCostS {

	public static Answer getSolution(Node root){

		Node actualNode = root;
		List<Node> frontier = new LinkedList<Node>();
		for(Node n: root.exploreNode()) {
			frontier.add(n);
		}
		List<Node> explored = new LinkedList<Node>();
		
		while(true) {
			if(frontier.isEmpty())
				return new Failure();
			
			frontier.sort(null);
			
			actualNode = frontier.remove(0);
			
			if(actualNode.isSolved())
				return new Success(actualNode);
			
			explored.add(actualNode);
			
			for (int i = 0; i < actualNode.exploreNode().length; i++) {
				Node child = actualNode.exploreNode()[i];
				if(!explored.contains(child) || !frontier.contains(child)) {
					frontier.add(child);
				}else if(frontier.contains(child)) {
					int j = frontier.indexOf(child);
					if (child.getCost() < frontier.get(j).getCost()) {
						frontier.remove(j);
						frontier.add(j,child);
					}
				}
			}
		}
	}

	public static String getName() {
		return "Uniform Cost Search";
	}
}
