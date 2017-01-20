package ss.week2.hotel;

public class Password extends java.lang.Object {
	public static final String INITIAL = "martwatch";
	private String password;

	public Password() {
		password = INITIAL;

	}

	public boolean acceptable(String suggestion) {
		return suggestion.length() >= 6 && !suggestion.contains(" ");
	}

	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass)) {
			if (acceptable(newpass)) {
				password = newpass;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean testWord(String test) {
		return test.equals(password);

	}

}
