package ss.week1.test;

public class Score {

	private static int score = 80;

	public boolean student() {

		return score >= 70;

	}

	public static void main(String[] args) {

		Score test = new Score();
		test.student();
		System.out.println(test.student());
	}
}
