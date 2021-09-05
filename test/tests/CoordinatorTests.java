package tests;

import org.junit.jupiter.api.Test;

import MVC_Controller.Coordinator;
import MVC_Model.Settings;

/**
 * In questa classe sono presenti i test relativi a {@link Coordinator}.
 * */
public class CoordinatorTests {

	@Test
	public final void coordinateRandomRandomLevel1() {
		new Coordinator(new Settings("RandomEncoder", "RandomDecoder", 1, false, true)).start();
	}

	@Test
	public final void coordinateRandomRandomLevel2() {
		new Coordinator(new Settings("RandomEncoder", "RandomDecoder", 2, false, true)).start();
	}

	@Test
	public final void coordinateRandomRandomLevel3() {
		new Coordinator(new Settings("RandomEncoder", "RandomDecoder", 3, false, true)).start();
	}

	@Test
	public final void coordinateRandomRandomFullGame() {
		new Coordinator(new Settings("RandomEncoder", "RandomDecoder", 0, false, true)).start();
	}

	@Test
	public final void coordinateRandomSetAndSwapLevel1() {
		new Coordinator(new Settings("RandomEncoder", "SetAndSwapDecoder", 1, false, true)).start();
	}

	@Test
	public final void coordinateRandomSetAndSwapLevel2() {
		new Coordinator(new Settings("RandomEncoder", "IntelligentDecoder", 2, false, true)).start();
	}

	@Test
	public final void coordinateRandomSetAndSwapLevel3() {
		new Coordinator(new Settings("RandomEncoder", "SetAndSwapDecoder", 3, false, true)).start();
	}

	@Test
	public final void coordinateRandomSetAndSwapFullGame() {
		new Coordinator(new Settings("RandomEncoder", "SetAndSwapDecoder", 0, false, true)).start();
	}

	@Test
	public final void coordinateRandomRealLevel1() {
		new Coordinator(new Settings("RandomEncoder", null, 1, false, true)).start();
	}

	@Test
	public final void coordinateRandomRealLevel2() {
		new Coordinator(new Settings("RandomEncoder", null, 2, false, true)).start();
	}

	@Test
	public final void coordinateRandomRealLevel3() {
		new Coordinator(new Settings("RandomEncoder", null, 3, false, true)).start();
	}

	@Test
	public final void coordinateRandomRealFullGame() {
		new Coordinator(new Settings("RandomEncoder", null, 0, false, true)).start();
	}

	@Test
	public final void coordinateRealRealLevel1() {
		new Coordinator(new Settings(null, null, 1, false, true)).start();
	}
	
	@Test
	public final void coordinateRealRealFullGame() {
		new Coordinator(new Settings(null, null, 0, false, true)).start();
		
	}
	
	@Test
	public final void coordinateRealSetAndSwapLevel1() {
		new Coordinator(new Settings(null, "SetAndSwapDecoder", 1, false, true)).start();
	}
}