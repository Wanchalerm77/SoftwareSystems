package ss.week3;

public class Format {

	public static String printLn(String text, double amount) {
		return String.format("%1$-20s   %2$10.2f" + "", text, amount);

	}

	public static void main(String[] args) {
		System.out.println(printLn("text1", 1.00));
		System.out.println(printLn("other text", -12.12));
		System.out.println(printLn("something", 0.20));
	}

}
