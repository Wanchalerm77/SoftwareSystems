package ss.week2;

/**
 * Exercises 1.4-1.7
 * 
 * @author Wanchalerm the KING
 *
 */

public class Lamp {
	public enum States {
		OFF, LOW, MED, HIGH;
	}

	private static States state;

	public Lamp(States state) {
		state = States.OFF;

	}

	/**
	 * Method returns the current state of the value
	 * 
	 * @return State of current value
	 */

	// @ ensures value >= 0 && value <= 3;
	public States currentValue() {
		return state;
	}
	// @ ensure \old(currenValue()) == OFF ==> currentValue() == LOW
	// @ ensure \old(currentValue()) == LOW ==> currentValue() == MED
	// @ ensure \old(currentValue()) == MED ==> currenrValue() == HIGH
	// @ ensure \old(currentValue()) == HIGH ==> currentValue() == OFF

	public States incrValue() {
		switch (state) {
		case OFF:
			return States.LOW;
		case LOW:
			return States.MED;
		case MED:
			return States.HIGH;

		case HIGH:
			return States.OFF;

		}
		return state;
	}

}
/**
 * Method increased the inserted value by one
 * 
 */

// @ ensures currentValue() == \old((currentValue()) + 1) % MOD;

/*
 * public void incrValue() { state = (state + 1) % MOD; }
 */

/**
 * Main method which prints out the current value
 * 
 * @param args
 */
