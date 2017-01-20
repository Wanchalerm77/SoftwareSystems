package ss.week6;

import java.util.Scanner;

public class Words {

	/*
	 * Question: Why does my method print on a new Line although its just
	 * print() and not println() ?
	 */

	public static void main(String[] args) {
		instructions();
		int count = 1;
		Scanner enteredLine;

		try (Scanner input = new Scanner(System.in)) {
			while ((enteredLine = new Scanner(input.nextLine())) != null) {
				String constructWord;
				count = 1;

				while (enteredLine.hasNext()) {
					constructWord = enteredLine.next(); // split Line in each
														// word
					if (constructWord.equals("end")) {
						System.exit(0);
					}

					System.out.println("Word " + count + ": " + constructWord);
					count++;

				}
				instructions();
			}
		}

	}

	public static void instructions() {
		System.out.print("Line (or  \"end\" ): ");
	}

}
