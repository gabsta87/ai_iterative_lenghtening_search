package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.tsp.TravelingSalesmanProblem;
import solutionSearch.Node;
import solutionSearch.algorithms.Answer;
import solutionSearch.algorithms.Success;
import solutionSearch.algorithms.UniformCostS;

class UCSTesterTSP {

	@Test
	void test() {

		TravelingSalesmanProblem p2 = new TravelingSalesmanProblem(4);
		p2.getCities()[0].setCoordinates(100, 100);
		p2.getCities()[1].setCoordinates(200, 100);
		p2.getCities()[2].setCoordinates(100, 200);
		p2.getCities()[3].setCoordinates(200, 200);
		
		System.out.println("Searching a path for "+p2.getCities().length+" cities");
		
		Answer a2 = UniformCostS.getSolution(new Node(p2));
		
		if(!a2.isSuccess()) {
			System.out.println("No solution was found");
		}else {
			assertTrue(a2.isSuccess());
			Success solution = (Success)a2;
			System.out.println("A solution was found for a total cost of  "+ solution.getCost());
			assertEquals(400, solution.getCost());
			System.out.println("Starting in "+p2.getStartingCity());
			
			for(Node n : solution.getSolution()) {
				System.out.println(n);
			}
		}
	}

}
