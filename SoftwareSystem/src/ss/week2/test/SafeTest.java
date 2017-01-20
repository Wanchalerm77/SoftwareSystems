package ss.week2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Safe;

public class SafeTest {
	public Safe safe;

	@Before
	public void setUp() {

		safe = new Safe("Smartwatch");

	}

	@Test
	public void testActivate() {
		safe.activate("Smartwatch");
		assertTrue(safe.isActive());

	}

	@Test

	public void testActivateWrong() {
		safe.activate("wrong");
		assertFalse(safe.isActive());

	}

	@Test

	public void testDeactivate() {
		safe.close();
		assertFalse(safe.isActive());
	}

	@Test

	public void testOpen() {
		safe.activate("Smartwatch");
		safe.open("Smartwatch");
		assertTrue(safe.isOpen());

	}

	@Test

	public void testOpenWrong() {
		safe.open("wrong");
		assertFalse(safe.isOpen());
	}

	@Test
	public void testClose() {
		assertFalse(safe.isOpen());
	}

	/**
	 * @Test public void testgetPassword() { assertTrue("Smartwatch" ==
	 *       safe.getPassword()); }
	 */

	@Test
	public void testisActive() {
		safe.activate("Smartwatch");
		assertTrue(safe.isActive());
	}

	@Test
	public void testIsActiveWrong() {
		safe.activate("wrong");
		assertFalse(safe.isActive());
	}

	@Test
	public void testIsOpen() {
		safe.activate("Smartwatch");
		safe.open("Smartwatch");
		assertTrue(safe.isOpen());

	}

	@Test
	public void testIsOpenWrong() {
		safe.open("wrong");
		assertFalse(safe.isOpen());
	}
}
