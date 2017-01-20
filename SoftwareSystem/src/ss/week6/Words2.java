package ss.week6;

import java.util.Scanner;

public class Words2 {

	private static Scanner input;
	/*
	 * Question: Why does my method print on a new Line although its just
	 * print() and not println() ?
	 */

	public static void main(String[] args) {
		boolean breakIt = false;
		instructions();
		input = new Scanner(System.in);
		Scanner enteredLine;

		while ((enteredLine = new Scanner(input.nextLine())) != null) {
			String constructWord;
			int count = 1;
			while (enteredLine.hasNext()) {
				constructWord = enteredLine.next(); // split Line in each
													// word
				if (constructWord.equals("end")) {
					breakIt = true;
					break;
				}
				System.out.println("Word " + count + ": " + constructWord);
				count++;
			}
			instructions(); // if there is no input we just ask again

			if (breakIt == true) { // exit while loop if "end" is the input
				break;
			}

		}
		enteredLine.close();

	}

	public static void instructions() {
		System.out.print("Line (or  \"end\" ): ");
	}

}