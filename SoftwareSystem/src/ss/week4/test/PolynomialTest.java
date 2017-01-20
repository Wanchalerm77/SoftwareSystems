package ss.week4.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week4.Polynomial;

public class PolynomialTest {
	private Polynomial poly;
	private double[] list = { 1, 2, 1, 3, 1, 3 };

	@Before
	public void setUp() throws Exception {
		poly = new Polynomial(list);

	}

	@Test
	public void test() {
		assertEquals("Check apply method", 1, poly.apply(1), 0.01);
		assertEquals("Test for integrand method", 32, poly.derivative().apply(1), 0.01);
		assertEquals("Test for integrand method", 92, poly.derivative().derivative().apply(1), 0.01);
		assertEquals("Test for integrand method", 494.85, poly.integrand().apply(3), 0.01);

	}

}
