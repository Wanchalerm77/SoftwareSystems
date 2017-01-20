package ss.week3;

/**
 * Assignement 3,6
 * 
 * @author Wanchalerm
 *
 */

public class TimedPassword extends Password {
	long validTime = 1000;
	long startTime;
	long endTime;

	public TimedPassword(int expTime) {
		super();
		startTime = System.currentTimeMillis();
		validTime = expTime;

	}

	public TimedPassword() {
		this(1);
	}

	public boolean isExpired() {
		endTime = System.currentTimeMillis();
		return ((endTime - startTime) >= validTime);
	}

	public boolean setPassword(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass) == true) {
			startTime = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 3.7 If the method always returns false, the password will never expire.
	 */

}