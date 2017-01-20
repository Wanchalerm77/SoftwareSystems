package ss.week3;

public class Safe {
	final Password password = new Password();

	public enum Activity {
		ACTIVATE, DEACTIVATE
	}

	public enum State {
		OPEN, CLOSED
	}

	private static State state;
	private static Activity activity;

	public Safe(String pass) {
		state = State.CLOSED;
		activity = Activity.DEACTIVATE;
		password.setWord(Password.INITIAL, pass);

	}

	// @ requires String text != null
	// @ ensures activity = Activity.ACTIVATE || activity = Activity.DEACTIVATE

	public void activate(String text) {
		assert text != null : "text (" + text + ") does not match requirements";
		if (password.testWord(text) == true) {
			activity = Activity.ACTIVATE;

		}

	}

	// @ pure

	public void deactivate() {
		close();
		activity = Activity.DEACTIVATE;

	}

	/** safe needs to be open and have entered the right password to be open */

	// @ requires String text != null
	// @ ensures state = State.OPEN || state = State.CLOSED

	public void open(String text) {
		assert text != null : "text (" + text + ") does not match requirements";
		if (password.testWord(text) == true && isActive() == true) {
			state = State.OPEN;
		}

	}

	/** closes safe without changing its activity status */
	// @ pure

	public void close() {

		state = State.CLOSED;

	}
	// @ pure

	public boolean isActive() {
		return activity == Activity.ACTIVATE;

	}
	// @ pure

	public boolean isOpen() {
		return state == State.OPEN;
	}
	// @ pure

	public Password getPassword() {

		return password;
	}

	public static void main(String[] args) {
		Safe safe = new Safe("phones");
		safe.activate(null);

	}

}
