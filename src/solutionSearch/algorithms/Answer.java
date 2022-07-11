package solutionSearch.algorithms;

public abstract class Answer{
	
	public boolean isSuccess() {
		return false;
	}

	public boolean isCutOff() {
		return false;
	}

	public boolean isFailure() {
		return false;
	}
	
	@Override
	public abstract String toString();
	
}

class Failure extends Answer{
	double fLimit;

	public Failure(double newLimit) {
		this.fLimit = newLimit;
	}
	
	public Failure() {
		this.fLimit = -1;
	}

	@Override
	public String toString() {
		return "Failure" +(fLimit>0?":"+fLimit:"");
	}

	@Override
	public boolean isFailure() {
		return true;
	}

}

class CutOff extends Answer{
	public CutOff() {}

	@Override
	public boolean isCutOff() {
		return true;
	}

	@Override
	public String toString() {
		return "CutOff";
	}
}