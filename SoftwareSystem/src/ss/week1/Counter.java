/**
 * 
 */
package ss.week1;

/**
 * @author Wanchalerm
 *
 */
public class Counter {

	private int count;

	public Counter() {
		count = 0;
	}

	public int currentCount() {
		return count;
	}

	public void incrementCount() {
		count = count + 1;
	}

	public void reset() {
		count = 0;
	}

}
