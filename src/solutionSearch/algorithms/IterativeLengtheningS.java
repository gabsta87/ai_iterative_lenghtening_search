package solutionSearch.algorithms;

import java.util.Arrays;

import solutionSearch.Node;

public class IterativeLengtheningS{
	
	public static Answer getSolution(Node root){
		double newLimit = 0;
		Answer a = getSolution(root, newLimit);
		
		while(a.isCutOff()) {
			newLimit = ((CutOffExtended) a).getLimit();
			a = getSolution(root, newLimit);
		}
		
		return a;
	}
	
	public static Answer getSolution(Node actualNode, double lengthLimit){
		Answer answer = null,newAnswer = null;
		
		if(actualNode.isSolved()) {
			answer = new Success(actualNode);
		}else if(actualNode.getCost() > lengthLimit) {
			answer = new CutOffExtended(actualNode);
		}else {
			boolean cutoff = false;
			Node[] children = actualNode.exploreNode();
			Arrays.sort(children);
			for(int i = 0; i < children.length; i++) {
				newAnswer = getSolution(children[i], lengthLimit);
				
				if(answer == null 
						|| (newAnswer.isCutOff() 
								&& (
										((CutOffExtended) answer).getLimit()) > 
										(((CutOffExtended) newAnswer).getLimit()) 
								)){
					answer = newAnswer;
				}
				
				if(answer.isCutOff()) {
					cutoff = true;
				}else if(!answer.isFailure()) {
					return answer;
				}
			}
			if(cutoff) {
				return answer;
			}else {
				return new Failure();
			}
		}
		return answer;
	}

	public static String getName() {
		return "Iterative Lengthening Search";
	}
}

class CutOffExtended extends CutOff{
	private Node limit;
	public CutOffExtended(Node n) {
		this.limit = n;
	}
	
	public double getLimit() {
		return this.limit.getCost();
	}
	
	@Override
	public String toString() {
		return ""+getLimit();
	}
}
