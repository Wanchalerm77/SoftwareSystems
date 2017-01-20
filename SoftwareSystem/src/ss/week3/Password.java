package ss.week3;

public class Password extends java.lang.Object {
	public static final String INITIAL = "martwatch";
	private String password;
	private Checker checker;
	private String factoryPassword;

	// public Password() {
	// password = INITIAL;

	// }

	public Password(Checker checker) {
		factoryPassword = checker.generatePassword();
		this.checker = checker;

	}

	public Password() {
		this(new BasicChecker());
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

	public Checker getChecker() {
		return checker;
	}

	public String getFP() {
		return factoryPassword;
	}
}
