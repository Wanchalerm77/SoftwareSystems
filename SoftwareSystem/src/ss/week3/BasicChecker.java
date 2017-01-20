package ss.week3;

public class BasicChecker implements Checker {
	public static final String INITPASS = "smartphone";
	private String password;

	public BasicChecker() {
		password = INITPASS;
	}

	@Override
	public boolean acceptable(String password) {

		return password.length() >= 6 && !password.contains(" ");
	}

	@Override
	public String generatePassword() {
		return password;

	}

}
