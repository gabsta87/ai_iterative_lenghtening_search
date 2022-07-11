package solutionSearch;

import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable<Node>{
	private Node parent;
	private Node[] children;
	private Action action;
	private Problem problem;
	
	public Node(Problem p) {
		this.parent = null;
		this.action = null;
		this.problem = p;
	}
	
	public Node(Node parent, Problem p, Action a) {
		this.parent = parent;
		this.problem = p;
		this.action = a;
		this.action.setEnvironment(p);
		a.execute();
	}
	
	/**
	 * @return The children of this node, sorted by node's cost
	 */
	public Node[] exploreNode(){
		List<Action> actionsAllowed = problem.getAvailableActions();
		
		children = new Node[actionsAllowed.size()];
		
		for(int i = 0; i<actionsAllowed.size(); i++) {
			children[i] = new Node(this,problem.clone(),actionsAllowed.get(i));
		}
		return children;
	}
	
	/**
	 * @return The node's path that leads to this node
	 */
	public List<Node> getSolution(){
		Node currentNode = this;
		List<Node> solution = new LinkedList<Node>();
		
		solution.add(this);
		
		while(currentNode.parent != null) {
			currentNode = currentNode.parent;
			solution.add(currentNode);
		}
		
		return solution;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean isRoot() {
		return parent == null;
	}
	
	public boolean isSolved() {
		return problem.isSolved();
	}
	
	public double getCost() {
		if(action == null)
			return 0;
		return action.getCost();
	}
	
	public Problem getProblem() {
		return problem;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!this.getClass().isInstance(o))
			return false;
		
		return problem.equals(((Node)o).problem);
	}
	
	@Override
	public String toString() {
		return problem.toString();
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(getCost(), o.getCost());
	}
	
}
