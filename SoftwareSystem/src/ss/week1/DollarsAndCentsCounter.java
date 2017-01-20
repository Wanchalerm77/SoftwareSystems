package ss.week1;

public class DollarsAndCentsCounter {

	private int cents;

	public int cents() {

		return cents;
	}

	public int dollars() {

		return cents;
	}

	public void add(int dollars, int cents) {
		this.cents = dollars + cents;
	}

	public void reset() {
		cents = 0;
	}

	/**
	 * public void substract(int dollarminus, int centminus) { this.counter =
	 * counter - dollarminus - centminus;
	 **/

	/* With the method we can have negative results */

}
