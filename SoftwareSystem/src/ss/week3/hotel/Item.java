package ss.week3.hotel;

public class Item implements Bill.Item {
	private String description;
	private double amount;

	public Item(String text, double amount) {
		description = text;
		this.amount = amount;

	}

	@Override
	public double getAmount() {
		return amount;

	}

	@Override
	public String toString() {
		/**
		 * method return text description lol filling in stuff
		 */

		return description;
	}

	public static void main(String[] args) {
		Item item = new Item("Tree", 2222.3);
		System.out.println(item.getAmount());
	}
}
