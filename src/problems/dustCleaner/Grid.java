package problems.dustCleaner;

public class Grid {
	private Square[][] squares;
	
	public Grid(int size) {
		this.squares = new Square[size][];
		
		for(int i = 0; i < squares.length; i++) {
			squares[i] = new Square[size];
		}
	}

	class Square{
		private double dirt;
		public Square() {
			
		}
	}
}
