package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IncorrectCodeLengthException;
import exceptions.IncorrectFormatException;
import MVC_Model.Alphabet;
import MVC_Model.Ball;
import MVC_Model.Code;
import interfaces.CodeContract;

/**
 * In questa classe sono presenti i test relativi a {@link Code}.
 **/
class CodeTests {

	@Test
	public final void testEquals() {
		Code code = new Code();
		Ball b1 = new Ball('a');
		Ball b2 = new Ball('b');
		Ball b3 = new Ball('c');
		Ball b4 = new Ball('d');
		code.add(b1);
		code.add(b2);
		code.add(b3);
		code.add(b4);
		Code code2 = new Code();
		code2.add(b1);
		code2.add(b2);
		code2.add(b3);
		code2.add(b4);
		assertTrue(code.equals(code2));
		Code code3 = new Code();
		code3.add(b1);
		code3.add(b2);
		code3.add(b3);
		code3.add(b4);
		code3.add(b4);
		assertFalse(code.equals(code3));
	}

	@Test
	public final void testControlLength() {
		Code code = new Code();
		Ball a = new Ball('a');
		Ball b = new Ball('b');
		code.add(a);
		code.add(b);
		assertThrows(IncorrectCodeLengthException.class, () -> code.controlLength(3));
	}

	@Test
	public final void testControlRepetitiveBalls() {
		Code code = new Code();
		Ball a = new Ball('a');
		Ball b = new Ball('b');
		code.add(a);
		code.add(b);
		code.add(b);
		assertTrue(code.controlRepetitiveBalls());
		Code code2 = new Code();
		code2.add(a);
		code2.add(b);
		assertFalse(code2.controlRepetitiveBalls());

	}

	@Test
	public final void testConvertInCode() throws IncorrectFormatException {
		Alphabet alphabet = new Alphabet(3,true);
		Code code = new Code();
		Ball a = new Ball('A');
		Ball b = new Ball('B');
		code.add(a);
		code.add(b);
		String correctString = "A,B";
		CodeContract strConverted = alphabet.convertInCode(correctString);
		assertEquals(code, strConverted);
		String incorrectString = "A,B,C,D";
		assertThrows(IncorrectFormatException.class, () -> alphabet.convertInCode(incorrectString));
	}
}
