package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.puzzle.PuzzleProblem;

class PuzzleTester {

	@Test
	void test() {
		PuzzleProblem p = new PuzzleProblem();
		
		assertTrue(p.isSolved());
		
		p.randomizeGridAuto();

		assertFalse(p.isSolved());
	}

}
