package ss.week2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	private Rectangle rectangle;

	@Before
	public void setValues() {
		rectangle = new Rectangle(10, 20);
	}

	@Test
	public void testLength() {
		assertEquals(10, rectangle.length());
	}

	@Test
	public void testWidth() {
		assertEquals(20, rectangle.width());
	}

	@Test
	public void testArea() {
		assertEquals("WHAT de fuck m8", 200, rectangle.area());
	}

	@Test
	public void testPerimeter() {
		assertEquals(60, rectangle.perimeter());
	}
}
