package ss.week6;

public class WrongArgumentException extends Exception {

	public String getMessage() {
		return "error: arguments have to be of type String";
	}

}
