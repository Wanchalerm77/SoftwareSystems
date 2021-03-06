package ss.week6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week6.ArgumentLengthsDifferException;
import ss.week6.TooFewArgumentsException;
import ss.week6.Zipper;

/**
 * Testprogram for Zipper. Lab Exercise SoftwareSystems
 * 
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class ZipperTest {

	/** Testvariabele for a <tt>DollarsAndCentsCounter</tt> object. */
	private Zipper zipper;

	@Before
	public void setUp() {
		zipper = new Zipper();
	}

	/**
	 * Test for zipping with too few arguments
	 * 
	 * @throws Exception
	 */
	@Test(expected = TooFewArgumentsException.class)
	public void testFirstArgumentNull() throws Exception {
		zipper.zip2(null, "Hello World!");
	}

	/**
	 * Test for zipping with too few arguments
	 * 
	 * @throws Exception
	 */
	@Test(expected = TooFewArgumentsException.class)
	public void testSecondArgumentNull() throws Exception {
		zipper.zip2("Hello World!", null);
	}

	/**
	 * Test for zipping with arguments of different length
	 * 
	 * @throws Exception
	 */
	@Test(expected = ArgumentLengthsDifferException.class)
	public void testDifferentArgumentLengths() throws Exception {
		zipper.zip2("Hello World!", "Hello World");
	}

	@Test
	public void testCorrectInput() throws Exception {
		assertEquals("HelloWorld", zipper.zip2("Hlool", "elWrd"));
	}

}
