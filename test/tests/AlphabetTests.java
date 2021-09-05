/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MVC_Model.Alphabet;

/**
 * In questa classe sono presenti i test relativi ad {@link Alphabet}. 
 **/

class AlphabetTests {

	@Test
	public final void testCreateAnAlphabetWithUppercaseCharacters() {
		Alphabet alphabet = new Alphabet(3,true);
		char[] expected = { 'A', 'B', 'C' };
		assertArrayEquals(expected, alphabet.toArray());
	}

	@Test
	public final void testCreateAnAlphabetWithLowercaseCharacters() {
		Alphabet alphabet = new Alphabet(3,false);
		char[] expected = { 'a', 'b', 'c' };
		assertArrayEquals(expected, alphabet.toArray());
	}
	
	@Test
	public final void testCreateAnAlphabetWithIllegalParameter1() {
		boolean exception = true;
		try {
			new Alphabet(0,false);
		}catch(IllegalArgumentException e) { 
			assertTrue(exception);
		}
	}
	
	@Test
	public final void testCreateAnAlphabetWithIllegalParameter2() {
		boolean exception = true;
		try {
			new Alphabet(26,false);
		}catch(IllegalArgumentException e) { 
			assertTrue(exception);
		}
	}
	@Test
	public final void testContainsElement() {
		Alphabet alphabet = new Alphabet(3, true);
		assertTrue(alphabet.contains('C'));
	}

	@Test
	public final void testNotContainsElement() {
		Alphabet alphabet = new Alphabet(3,true);
		assertFalse(alphabet.contains('D'));
		assertFalse(alphabet.contains('b'));
	}
}
