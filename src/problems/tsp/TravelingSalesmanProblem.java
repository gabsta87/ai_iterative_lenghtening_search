package problems.tsp;

import java.util.LinkedList;
import java.util.List;

import solutionSearch.Action;
import solutionSearch.Problem;

public class TravelingSalesmanProblem extends Problem {
	private City[] cities;
	private Path path;
	
	private TravelingSalesmanProblem() {}
	
	public TravelingSalesmanProblem(int size) {
		cities = new City[size];

		for(int i = 0; i < cities.length; i++) {
			cities[i] = new City(i);
		}
		
		this.path = new Path();
		this.path.setStart(cities[0]);
	}
	
	public void setStart(City c) {
		this.path.setStart(c);
	}
	
	public City getStartingCity() {
		return this.path.getStartingCity();
	}
	
	public City[] getCities() {
		return cities;
	}
	
	public boolean moveToCity(City c) {
		return path.addCity(c);
	}
	
	@Override
	public boolean isSolved() {
		if(path.size() < cities.length)
			return false;
		
		if(!path.isCircular())
			return false;
		
		return true;
	}

	@Override
	public List<Action> getAvailableActions() {
		List<Action> result = new LinkedList<Action>();
		
		for(int i = 0; i < cities.length; i++) {
			if(!path.contains(cities[i]) 
					&& !(path.size() < cities.length-1 && cities[i].equals(getStartingCity()))) {
				result.add(new MoveToCity(cities[i],(TravelingSalesmanProblem)this.clone()));
			}
		}
		
		return result;
	}

	@Override
	public Problem clone() {
		TravelingSalesmanProblem p = new TravelingSalesmanProblem();
		p.cities = this.cities;
		p.path = this.path.clone();
		return p;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o.getClass() != this.getClass())
			return false;
		TravelingSalesmanProblem p = ((TravelingSalesmanProblem)o);
		return p.cities == this.cities && p.path.equals(this.path);
	}
	
	@Override
	public String toString() {
		return path.toString();
	}

	public Path getPath() {
		return path;
	}
}
