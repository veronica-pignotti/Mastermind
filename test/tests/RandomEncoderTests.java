package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.AttemptsTerminatedException;
import exceptions.IncorrectFormatException;
import MVC_Model.Alphabet;
import MVC_Model.Clue;
import MVC_Model.Clues;
import MVC_Model.RandomEncoder;
import interfaces.CodeContract;

/**
 * In questa classe sono presenti i test relativi a {@link RandomEncoder}.
 * */
class RandomEncoderTests {

	private final Alphabet alphabet = new Alphabet(7,false);
	private final RandomEncoder encoder = new RandomEncoder();

	@Test
	final void testCreateCluesWithoutRepetitions() throws IncorrectFormatException, AttemptsTerminatedException {

		CodeContract secretCode = (CodeContract) alphabet.convertInCode("a,b,c,d");

		CodeContract c1 = alphabet.convertInCode("a,b,c,d");
		Clues clues1 = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.Black);
		assertEquals(clues1, encoder.createClues(secretCode, c1));

		CodeContract c2 = alphabet.convertInCode("a,b,d,c");
		Clues clues2 = new Clues(Clue.Black, Clue.Black, Clue.White, Clue.White);
		assertEquals(clues2, encoder.createClues(secretCode, c2));

		CodeContract c3 = alphabet.convertInCode("a,c,e,d");
		Clues clues3 = new Clues(Clue.Black, Clue.White, Clue.Black);
		assertEquals(clues3, encoder.createClues(secretCode, c3));

		CodeContract c4 = alphabet.convertInCode("d,c,a,b");
		Clues clues4 = new Clues(Clue.White, Clue.White, Clue.White, Clue.White);
		assertEquals(clues4, encoder.createClues(secretCode, c4));

		CodeContract c5 = alphabet.convertInCode("a,b,e,f");
		Clues clues5 = new Clues(Clue.Black, Clue.Black);
		assertEquals(clues5, encoder.createClues(secretCode, c5));

		CodeContract c6 = alphabet.convertInCode("d,e,f,g");
		Clues clues6 = new Clues(Clue.White);
		assertEquals(clues6, encoder.createClues(secretCode, c6));

		CodeContract c7 = alphabet.convertInCode("a,e,f,g");
		Clues clues7 = new Clues(Clue.Black);
		assertEquals(clues7, encoder.createClues(secretCode, c7));
	}

	@Test
	final void testCreateCluesWithRepetitions() throws IncorrectFormatException, AttemptsTerminatedException {
		
		CodeContract secretCode = alphabet.convertInCode("a,a,c,d");

		CodeContract c1 = alphabet.convertInCode("a,a,c,d");
		Clues clues1 = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.Black);
		assertEquals(clues1, encoder.createClues(secretCode, c1));

		CodeContract c2 = alphabet.convertInCode("a,b,a,c");
		Clues clues2 = new Clues(Clue.Black, Clue.White, Clue.White);
		assertEquals(clues2, encoder.createClues(secretCode, c2));

		CodeContract c3 = alphabet.convertInCode("d,a,c,a");
		Clues clues3 = new Clues(Clue.White, Clue.Black, Clue.Black, Clue.White);
		assertEquals(clues3, encoder.createClues(secretCode, c3));

		CodeContract c4 = alphabet.convertInCode("d,c,a,a");
		Clues clues4 = new Clues(Clue.White, Clue.White, Clue.White, Clue.White);
		assertEquals(clues4, encoder.createClues(secretCode, c4));
	}

	@Test
	final void testCreateCluesWithRepetitions2() throws IncorrectFormatException, AttemptsTerminatedException {

		CodeContract secretCode = alphabet.convertInCode("a,a,c,d,b");

		CodeContract c1 = alphabet.convertInCode("a,a,c,d,b");
		Clues clues1 = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.Black, Clue.Black);
		assertEquals(clues1, encoder.createClues(secretCode, c1));

		CodeContract c2 = alphabet.convertInCode("a,b,b,a,c");
		Clues clues2 = new Clues(Clue.Black, Clue.White, Clue.White, Clue.White);
		assertEquals(clues2, encoder.createClues(secretCode, c2));

		CodeContract c3 = alphabet.convertInCode("d,a,c,b,a");
		Clues clues3 = new Clues(Clue.White, Clue.Black, Clue.Black, Clue.White, Clue.White);
		assertEquals(clues3, encoder.createClues(secretCode, c3));

		CodeContract c4 = alphabet.convertInCode("d,c,a,b,a");
		Clues clues4 = new Clues(Clue.White, Clue.White, Clue.White, Clue.White, Clue.White);
		assertEquals(clues4, encoder.createClues(secretCode, c4));

		CodeContract c5 = alphabet.convertInCode("d,g,a,f,a");
		Clues clues5 = new Clues(Clue.White, Clue.White, Clue.White);
		assertEquals(clues5, encoder.createClues(secretCode, c5));

		CodeContract c6 = alphabet.convertInCode("d,g,a,f,e");
		Clues clues6 = new Clues(Clue.White, Clue.White);
		assertEquals(clues6, encoder.createClues(secretCode, c6));
	}
	
	@Test
	final void testCreateCluesWithRepetitions3() throws IncorrectFormatException, AttemptsTerminatedException {

		CodeContract secretCode = alphabet.convertInCode("a,b,a,c,c,c");

		CodeContract c1 = alphabet.convertInCode("b,d,a,b,c,c");
		Clues clues1 = new Clues(Clue.Black, Clue.Black, Clue.Black, Clue.White);
		assertEquals(clues1, encoder.createClues(secretCode, c1));

		
	}
}