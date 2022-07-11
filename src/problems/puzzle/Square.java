package problems.puzzle;

import java.awt.Point;

public class Square {
	public static final int EMPTY = 0;
	
	private int status = EMPTY;
	private Point coords;
	
	public Square(int value,int x, int y) {
		this.status = value;
		this.coords = new Point(x,y);
	}
	
	public Point getCoordinates() {
		return coords;
	}
	
	public void setValue(int value) {
		this.status = value;
	}
	
	public int getValue() {
		return this.status;
	}
	
	public String toString() {
		return status>0 ? ""+status : "";
	}
}
