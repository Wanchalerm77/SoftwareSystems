import java.util.Scanner;

public class MoreTest {
	public static void main(String[] args) {
		int x = 44;
		int y = 0;
		int s = getIntB();
		boolean fool = true;
		System.out.println(s);
		System.out.println(lolOK());

		System.out.println(testIf());
	}

	static int getInt() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}

	private static int getIntB() {
		// TODO Auto-generated method stub
		Scanner d = new Scanner(System.in);
		boolean isValid = true;
		System.out.println("Enter a number plz");
		String input = d.next();
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i)))
				;
			isValid = false;
			break;
		}

		if (isValid) {
			return Integer.parseInt(input);
		}
		return 0;
	}

	private static int lolOK() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter something");
		try {
			return s.nextInt();
		} catch (Exception e) {
			System.out.println("Ok");
			;
		}
		return 0;
	}

	static String testIf() {
		boolean fool = true;
		if (fool) {
			return "yeah";
		}
		if (fool == false) {
			return "LOL";
		}
		return null;
	}

}
