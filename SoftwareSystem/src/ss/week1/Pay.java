package ss.week1;

public class Pay {
	private int hours = 45;
	private double rate = 1.4;
	private double money;

	public void pay() {
		if (hours <= 40)
			money = hours * rate;
		if (hours > 40)
			money = hours * (rate * 1.5);
	}

	public double status() {
		return money;
	}

	public static void main(String[] args) {
		Pay End = new Pay();
		End.pay();
		System.out.println(End.status());
	}
}
