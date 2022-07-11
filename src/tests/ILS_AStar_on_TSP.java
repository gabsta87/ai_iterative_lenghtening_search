package tests;

import java.awt.Frame;

import problems.tsp.City;
import problems.tsp.TravelingSalesmanProblem;
import problems.tsp.graphics.TSPPainter;
import solutionSearch.Node;
import solutionSearch.algorithms.Answer;
import solutionSearch.algorithms.IterativeLengtheningS;
import solutionSearch.algorithms.Success;
import solutionSearch.algorithms.UniformCostS;

public class ILS_AStar_on_TSP {
	private static int tspCitiesNumber = 9;
	private static int tspGeographicMaxDistance = 400;

	public static void main(String[] args) {

		TravelingSalesmanProblem p = new TravelingSalesmanProblem(tspCitiesNumber);
		randomizeCitiesCoords(p);
		
		System.out.println("Starting with "+p.getCities().length+" cities");
		
		String algoName = IterativeLengtheningS.getName();
		System.out.println("Trying "+algoName);
		long startTime = System.currentTimeMillis();
		Answer a = IterativeLengtheningS.getSolution(new Node(p));
		long endTime = System.currentTimeMillis();
		System.out.println("Execution took "+getTime(endTime-startTime));
		examineSolution(p, a, algoName);
		
		System.out.println();
		
		algoName = UniformCostS.getName();
		System.out.println("Trying "+algoName);
		startTime = System.currentTimeMillis();
		Answer b = UniformCostS.getSolution(new Node(p));
		endTime = System.currentTimeMillis();
		System.out.println("Execution took "+getTime(endTime-startTime));
		examineSolution(p, b,algoName).setLocation(tspGeographicMaxDistance*1, 0);
		
//		p = new TravelingSalesmanProblem(4);
//		p.getCities()[0].setCoordinates(100, 100);
//		p.getCities()[1].setCoordinates(200, 100);
//		p.getCities()[2].setCoordinates(100, 200);
//		p.getCities()[3].setCoordinates(200, 200);
//		
//		algoName = UniformCostS.getName()+" on defined Path";
//		System.out.println("Trying "+algoName);
//		startTime = System.currentTimeMillis();
//		b = UniformCostS.getSolution(new Node(p));
//		endTime = System.currentTimeMillis();
//		System.out.println("Execution took "+(endTime-startTime)/1000+" s");
//		examineSolution(p, b,algoName).setLocation(tspGeographicMaxDistance*2, 0);
		
	}

	private static String getTime(long timeInMS) {
		long timeInSeconds = timeInMS/1000;
		long hours = timeInSeconds/3600;
		long minutes = timeInSeconds%3600/60;
		long seconds = timeInSeconds%3600%60;
		return (hours>0?hours+"h":"")+(minutes>0?minutes+"m":"")+(seconds>0?seconds+"s":"");
	}
	
	private static Frame examineSolution(TravelingSalesmanProblem p, Answer a, String algorithmName) {
		if(!a.isSuccess()) {
			System.out.println("No solution was found");
			return null;
		}else {
			Success solution = (Success)a;
			System.out.println("A solution was found for a total cost of  "+ solution.getCost());
			
//			System.out.println("Starting in "+p.getStartingCity());
//			for(Node n : solution.getSolution()) {
//				System.out.println(n);
//			}
			
			return printSolution((TravelingSalesmanProblem)solution.getSolution().get(solution.getSolution().size()-1).getProblem(),algorithmName);
		}
	}

	private static Frame printSolution(TravelingSalesmanProblem p, String frameTitle) {
		Frame f = new Frame();
		f.add(new TSPPainter(p));
		int frameWidth = tspGeographicMaxDistance+50;
		int frameHeight = tspGeographicMaxDistance+50;
		f.setSize(frameWidth, frameHeight);
		f.setVisible(true);
		f.setTitle(frameTitle);
		return f;
	}	

	private static void randomizeCitiesCoords(TravelingSalesmanProblem p) {
		int x,y;
		for(City c : p.getCities()) {
			x = (int) (Math.random()*tspGeographicMaxDistance);
			y = (int) (Math.random()*tspGeographicMaxDistance);
			c.setCoordinates(x,y);
		}
	}

}
