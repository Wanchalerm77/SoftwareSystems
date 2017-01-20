package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	private double price;

	public PricedSafe(double safePrice) {
		super();
		price = safePrice;

	}

	@Override
	public String toString() {
		return "Price of safe" + "    " + getAmount();
	}

	@Override
	public double getAmount() {
		return price;
	}

	/**
	 * public static void main(String[] args) { PricedSafe safe = new
	 * PricedSafe(2333); System.out.println(safe.toString()); }
	 */

}
