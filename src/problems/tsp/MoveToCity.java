package problems.tsp;

import solutionSearch.Action;
import solutionSearch.Problem;

public class MoveToCity extends Action{
	private TravelingSalesmanProblem p;
	private City newCity;
	
	public MoveToCity(City newCity, TravelingSalesmanProblem problem) {
		this.newCity = newCity;
		this.p = problem;
	}

	@Override
	public boolean execute() {
		return p.moveToCity(newCity);
	}

	@Override
	public boolean setEnvironment(Problem p) {
		if(p.getClass() != TravelingSalesmanProblem.class)
			return false;
		this.p = (TravelingSalesmanProblem)p;
		return true;
	}

	@Override
	public double getCost() {
		return p.getPath().getPathCost();
//		return p.getPath().getVisitedCities().get(p.getPath().size()-1).distance(newCity);
	}

	@Override
	public String toString() {
		return "MOVE TO "+newCity+" - "+getCost();
	}

}
