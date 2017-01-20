package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	int s1, s2;

	public ArgumentLengthsDifferException(int i, int j) {
		// TODO Auto-generated constructor stub
		super();
		this.s1 = i;
		this.s2 = j;

	}

	public String getMessage() {
		return "error: length of command line arguments " + "differs (" + s1 + ", " + s2 + ")";
	}

}
