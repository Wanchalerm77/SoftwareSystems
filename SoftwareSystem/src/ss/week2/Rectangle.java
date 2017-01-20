package ss.week2;

public class Rectangle {
	private int length;
	private int width;

	// @ private invariant length > 0;
	// @ private invariant width > 0;

	/**
	 * Create a new Rectangle with the specified length and width.
	 */
	/*
	 * @ requires theLength >= 0; requires theWidth >= 0; ensures this.length()
	 * * == theLength; ensures width() == theWidth;
	 */
	public Rectangle(int theLength, int theWidth) {
		length = theLength;
		width = theWidth;
	}

	/**
	 * The length of this Rectangle.
	 */
	// @ ensures \result > 0;
	public int length() {
		return length;
	}

	/**
	 * The width of this Rectangle.
	 */
	// @ ensures \result >= 0;
	// @ pure
	public int width() {
		return width;
	}

	/**
	 * The area of this Rectangle.
	 */
	// @ ensures \result >= 0;
	// @ ensures \result == length() * width();
	public int area() {
		assert length >= 0 && width >= 0;
		return length * width;
	}

	/**
	 * The perimeter of this Rectangle.
	 */
	public int perimeter() {
		int result = (length + width) * 2;
		assert result > 0;
		return result;

	}
}
