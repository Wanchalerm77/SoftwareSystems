package ss.week2.hotel;

public class Hotel {

	private Room room1;
	private Room room2;
	private String name;
	private Password password;

	// @ requires hotelName != null
	// @ ensures getHotel() == hotelName
	public Hotel(String hotelName) {
		password = new Password();

		name = hotelName;
		room1 = new Room(100, "cokacola");
		room2 = new Room(200, "laptop");

	}
	// @ requires testPassword != null && guestName != null

	// @ ensures (password.testWord(testPassword) && getRoom(guestName) == null)
	// ==> \result == getRoom(guestName)

	public Room checkIn(String testPassword, String guestName) {
		Room r = null;
		assert (testPassword != null && guestName != null) : "Preconditions are not met";

		if (password.testWord(testPassword) && getFreeRoom() != null && getRoom(guestName) == null) {

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

	// @requires nameG != null && getRoom(nameG) != null
	// @ensures getRoom(nameG) == null

	public void checkOut(String nameG) {
		assert (nameG != null) : "Preconditions are not met";

		Room r = getRoom(nameG);

		if (r != null) {
			r.getGuest().checkout();
		}

	}

	// @ requires g != null

	// @ ensure \result == null || \result.getGuest().getName() == g

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
	// @ \result == null || \result.getGuest() == null

	public Room getFreeRoom() {

		if (room1.getGuest() == null) {
			return room1;

		} else if (room2.getGuest() == null) {

			return room2;
		}
		return null;

	}
	// @ pure
	// @ ensures \result != null

	public Password getPassword() {
		return password;
	}
	// @ensures \result != null

	@Override
	public String toString() {
		String output = "";
		if (room1.getGuest() != null) {
			output = room1.getGuest().getName();
			return output;

		} else if (room2.getGuest() != null) {
			output = room2.getGuest().getName();
			return output;

		}
		return output;

	}

}
