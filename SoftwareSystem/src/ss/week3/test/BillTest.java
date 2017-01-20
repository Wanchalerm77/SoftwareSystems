package ss.week3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Item;

public class BillTest {
	private Bill bill;

	@Before
	public void setUp() throws Exception {
		bill = new Bill(System.out);

	}

	@Test
	public void test() {
		assertEquals("Startsum", 0, bill.getSum(), 0.01);
		bill.newItem(new Item("Tree", 1));
		assertEquals("Bill with only Tree", 1, bill.getSum(), 0.01);
		bill.newItem(new Item("Orange", 2));
		assertEquals("Bill with Tree & Orange", 3, bill.getSum(), 0.01);
		// bill.close();

	}

}
