package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	private double price;

	public PricedRoom(int roomNumber, double roomPrice, double safePrice) {
		super(roomNumber, new PricedSafe(safePrice));
		this.price = roomPrice;

	}

	@Override
	public String toString() {
		return "Price per night" + "    " + Double.toString(price);

	}

	@Override
	public double getAmount() {
		return price;

	}

	public static void main(String[] args) {
		Room price = new PricedRoom(11, 112, 22);
		System.out.println(price.toString());
	}

}
