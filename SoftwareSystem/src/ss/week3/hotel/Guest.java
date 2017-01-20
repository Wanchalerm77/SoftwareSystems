package ss.week3.hotel;

/**
 * Class Guest with methods for GuestTest
 * 
 * 
 * @author Wanchalerm
 * 
 * 
 *
 */

public class Guest {
	private Room room;
	private String name;

	/* The constructor of the class */

	public Guest(String n) {
		name = n;
	}
	/* ----------Queries------------- */

	public boolean checkin(Room r) {
		if (r.getGuest() == null && room == null) {
			r.setGuest(this);
			room = r;

			return true;
		} else {
			return false;
		}
	}

	/**
	 * if room has been rented to this guest, else we return false
	 * 
	 * @return status of room, booked -> true
	 */

	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * true if this action succeeded; false if Guest does not have a Room when
	 * this method is called
	 * 
	 * @return
	 */

	public Room getRoom() {
		return room;
	}

	/**
	 * represents room rented by this guest, null if not the case
	 * 
	 * @return guest who rents room
	 */

	public String getName() {
		return name;
	}

	/**
	 * returns the name of the guest, null if not available
	 */

	@Override
	public String toString() {
		return "Name: " + name + "Room:" + room;

	}
}
