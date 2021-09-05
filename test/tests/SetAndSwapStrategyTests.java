package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MVC_Model.Ball;
import MVC_Model.Code;
import Strategies.SetAndSwapStrategy;

/**
 * In questa classe sono presenti i test relativi a {@link SetAndSwapStrategy}. 
 **/
class SetAndSwapStrategyTests implements SetAndSwapStrategy {

	@Test
	public final void testSet() {
		Code code = new Code();
		Ball a = new Ball('a');
		Ball b = new Ball('b');
		code.add(a);
		code.add(b);
		Code code2 = new Code();
		code2.add(b);
		code2.add(b);
		assertEquals(code2, (Code) set(code, 0, b));
	}

	@Test
	public final void testSwap() {
		Code code = new Code();
		Ball a = new Ball('a');
		Ball b = new Ball('b');
		code.add(a);
		code.add(b);
		Code code2 = new Code();
		code2.add(b);
		code2.add(a);
		assertEquals(code2, swap(code, 0, 1));

	}

}
