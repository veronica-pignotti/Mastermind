package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IncorrectFormatException;
import MVC_Model.Clue;
import MVC_Model.Clues;

/**
 * In questa classe sono presenti i test relativi a {@link Clues}.
 * */
class CluesTests {

	@Test
	public final void testEqualsClues() {
		Clues clues = new Clues(Clue.White, Clue.Black, Clue.White, Clue.White, Clue.Black);
		Clues expected = new Clues(Clue.Black, Clue.Black, Clue.White, Clue.White, Clue.White);
		assertTrue(clues.equals(expected));
	}

	@Test
	public final void testNotEqualsClues() {
		Clues clues = new Clues(Clue.White, Clue.Black, Clue.White, Clue.Black);
		Clues expected = new Clues(Clue.Black, Clue.Black, Clue.White, Clue.White, Clue.White);
		assertFalse(clues.equals(expected));
	}

	@Test
	public final void testAddClue() {
		Clues clues = new Clues();
		clues.addClue(Clue.White);
		clues.addClue(Clue.White);
		clues.addClue(Clue.Black);
		clues.addClue(Clue.White);
		clues.addClue(Clue.White);
		clues.addClue(Clue.Black);
		clues.addClue(Clue.White);
		clues.addClue(Clue.Black);
		clues.addClue(Clue.White);
		clues.addClue(Clue.White);
		Clues expected = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.White, Clue.White, Clue.White, Clue.White,
				Clue.White, Clue.White, Clue.White);
		assertTrue(clues.equals(expected));
	}

	@Test
	public final void testOnlyBlackClues() {
		Clues clues = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.Black);
		assertTrue(clues.onlyBlackClues(4));
	}

	@Test
	public final void testNotOnlyBlackClues() {
		Clues clues = new Clues(Clue.Black, Clue.White, Clue.Black, Clue.Black);
		assertFalse(clues.onlyBlackClues(4));
	}

	@Test
	public final void testConvertInClues() throws IncorrectFormatException {
		String str = "WWBBWBW";
		Clues expected = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.White, Clue.White, Clue.White, Clue.White);
		assertEquals(expected, new Clues().converteInClues(str));
	}

	@Test
	public final void testThrowIncorrectFormatException() {
		assertThrows(IncorrectFormatException.class, () -> new Clues().converteInClues("WWBAWBW"));
	}
}
