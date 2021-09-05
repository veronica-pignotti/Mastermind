/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MVC_Model.Ball;

/**
 * In questa classe sono presenti i test relativi al {@link Ball}.
 **/
class BallTests {

	@Test
	public final void testEquals() {
		Ball ball1 = new Ball('A');
		Ball ball2 = new Ball('A');
		Ball ball3 = new Ball('a');
		Ball ball4 = new Ball('B');
		assertTrue(ball1.equals(ball2));
		assertFalse(ball1.equals(ball3));
		assertFalse(ball1.equals(ball4));
	}

}
