package ss.week3.hotel;

import java.io.PrintStream;

public class Hotel implements Bill.Item {

	private Room room1;
	private Room room2;
	private String name;
	private double amount;

	Password password = new Password();

	public Hotel(String hotelName) {

		name = hotelName;
		room1 = new Room(100, new Safe());
		room2 = new Room(200, new Safe());

	}
	// @ requires testPassword != null && password != null
	// @ requires guestName != null
	// @ ensures return r

	public Room checkIn(String testPassword, String guestName) {
		Room r = null;
		assert (testPassword != null && guestName != null) : "Preconditions are not met";

		if (password.testWord(testPassword) == true && getFreeRoom() != null && getRoom(guestName) == null) {

			Guest guest1 = new Guest(guestName);
			guest1.checkin(getFreeRoom());
			r = guest1.getRoom();

		}

		return r;

	}
	// @ pure

	public String getHotel() {
		return this.name;
	}

	// @requires Room r != null && nameG != null
	// @ensures r.getGuest().checkout()

	public void checkOut(String nameG) {
		assert (nameG != null) : "Preconditions are not met";

		Room r = getRoom(nameG);

		if (r != null) {
			r.getGuest().checkout();
		}

	}
	// @ requires room1.getGuest() != null && room2.getGuest() != null
	// @ requires g != null

	// @ ensure return room1 || return room2

	public Room getRoom(String g) {
		assert (g != null) : " Preconditions are not met";

		if (room1.getGuest() != null && room1.getGuest().getName() == g) {

			return room1;

		} else if (room2.getGuest() != null && room2.getGuest().getName() == g) {
			return room2;

		} else {
			return null;
		}

	}
	// @ pure

	public Room getFreeRoom() {
		// assert room1.getGuest() != null : "Preconditions are not met";
		if (room1.getGuest() == null) {
			return room1;

		} else if (room2.getGuest() == null) {

			return room2;
		}
		return null;

	}
	// @ pure

	public Password getPassword() {
		return password;
	}
	// @pure

	@Override
	public String toString() {
		String output = null;
		if (room1.getGuest() != null) {
			output = room1.getGuest().getName();
			return output;

		} else if (room2.getGuest() != null) {
			output = room2.getGuest().getName();
			return output;

		}
		return output;

	}

	@Override
	public double getAmount() {
		return amount;
	}

	public Bill getBill(String guestName, int nightNumber, PrintStream stream) {
		assert guestName != null;
		Room r = getRoom(guestName);
		Safe s = r.getSafe();
		Bill bill = new Bill(stream);
		if (r instanceof PricedRoom) {
			for (int i = 0; i == nightNumber; i++) {
				Bill.Item room = (PricedRoom) r;
				bill.newItem(room);
			}
			if (s instanceof PricedSafe) {
				Bill.Item safe = (PricedSafe) s;
				bill.newItem(safe);

			} else {
				return null;
			}
			bill.close();

		}

		return bill;
	}
}
