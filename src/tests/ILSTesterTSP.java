package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import problems.tsp.City;
import problems.tsp.TravelingSalesmanProblem;
import solutionSearch.Node;
import solutionSearch.algorithms.Answer;
import solutionSearch.algorithms.IterativeLengtheningS;
import solutionSearch.algorithms.Success;

class ILSTesterTSP {
	
	private int tspCitiesNumber = 6;
	private int tspGeographicMaxDistance = 500;

	@Test
	void test() {
		
		TravelingSalesmanProblem p = new TravelingSalesmanProblem(tspCitiesNumber);
		
		randomizeCitiesCoords(p);
		
		System.out.println("Searching a path for "+p.getCities().length+" cities");
		
		Answer a = IterativeLengtheningS.getSolution(new Node(p));
		
		if(!a.isSuccess()) {
			System.out.println("No solution was found");
		}else {
			assertTrue(a.isSuccess());
			Success solution = (Success)a;
			System.out.println("A solution was found for a total cost of  "+ solution.getCost());
			System.out.println("Starting in "+p.getStartingCity());
			
			for(Node n : solution.getSolution()) {
				System.out.println(n);
			}
		}
	}

	private void randomizeCitiesCoords(TravelingSalesmanProblem p) {
		int x,y;
		for(City c : p.getCities()) {
			x = (int) (Math.random()*tspGeographicMaxDistance);
			y = (int) (Math.random()*tspGeographicMaxDistance);
			c.setCoordinates(x,y);
		}
	}

}
