package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bill {

	private PrintStream stream;
	private double price;

	public Bill(PrintStream theOutStream) {
		stream = theOutStream;
	}

	public interface Item {

		@Override
		public String toString();

		public double getAmount();

	}

	private ArrayList<Item> itemList = new ArrayList<Item>();

	public void close() {
		if (stream != null) {
			stream.println("Sum of the bill" + "    " + getSum());
		}
	}

	public double getSum() {
		for (Item itemList : itemList) {
			price += itemList.getAmount();

		}
		return price;

	}

	public void newItem(Bill.Item item) {
		if (item != null) {
			itemList.add(item);
			stream.println("Item" + item.getAmount() + item.toString());
		}
	}

}
