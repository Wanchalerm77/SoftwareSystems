package ss.week1;

/**
 * Exercises 1.4-1.7
 * 
 * @author Wanchalerm
 *
 */

public class Lamp {

	private int value;
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MED = 2;
	public static final int HIGH = 3;
	public static final int MOD = 4;

	public Lamp() {
		value = OFF;
	}

	public int currentValue() {
		return value;
	}

	public void incrValue() {
		value = (value + 1) % MOD;
	}

	public static void main(String[] args) { // TODO Auto-generated method stub
		Lamp Mode = new Lamp();
		Mode.incrValue();
		System.out.println(Mode.currentValue());
		Mode.incrValue();
		System.out.println(Mode.currentValue());
		Mode.incrValue();
		System.out.println(Mode.currentValue());
		Mode.incrValue();
		System.out.println(Mode.currentValue());
	}

}
