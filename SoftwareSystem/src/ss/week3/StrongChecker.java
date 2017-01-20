package ss.week3;

public class StrongChecker extends BasicChecker implements Checker {
	@Override
	public boolean acceptable(String password) {
		return super.acceptable(password) && Character.isLetter(password.charAt(0))
				&& Character.isDigit(password.charAt(password.length() - 1));

	}

	public boolean additionCheck(String text) {
		return Character.isLetter(text.charAt(0)) && Character.isDigit(text.charAt(text.length() - 1));
	}

	@Override
	public String generatePassword() {
		return BasicChecker.INITPASS;

	}

}
