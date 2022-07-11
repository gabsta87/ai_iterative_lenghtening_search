package solutionSearch.algorithms;

import solutionSearch.Node;

public class DepthLimitedS {
	
	public static Answer getSolution(Node actualNode, int depthLimit){
		Answer answer = null;
		
		if(actualNode.isSolved()) {
			answer = new Success(actualNode);
		}else if(depthLimit == 0) {
			answer = new CutOff();
		}else {
			boolean cutoff = false;
			Node[] children = actualNode.exploreNode();
			for(int i = 0; i < children.length; i++) {
				answer = getSolution(children[i], depthLimit-1);
				if(answer.isCutOff()) {
					cutoff = true;
				}else if(!answer.isFailure()) {
					return answer;
				}
			}
			if(cutoff) {
				return new CutOff();
			}else {
				return new Failure();
			}
		}
		return answer;
	}
}
