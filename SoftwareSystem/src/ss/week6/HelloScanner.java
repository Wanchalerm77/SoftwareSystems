package ss.week6;

import java.util.Scanner;

public class HelloScanner {

	public static void main(String[] args) {

		boolean breakIt = false;

		System.out.println("ya name plz");
		try (Scanner in = new Scanner(System.in)) {

			while (breakIt == false) {

				if (in.hasNextLine()) {
					breakIt = processInput(in.nextLine());
				}
			}
		}

	}

	/*
	 * Before: We needed 2 Enters to print the sentence and one for termination
	 * Method enables that we only need 1 enter after input
	 */

	private static boolean processInput(String input) { // TODO
		// Auto-generated method stub
		if (input.equals("")) {
			return true;
		} else {
			System.out.println("Hello," + " " + input);
			return false;
		}

	}

}