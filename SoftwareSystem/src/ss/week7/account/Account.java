package ss.week7.account;

public class Account {
	protected double balance = 0.0;

	public synchronized void transaction(double amount) {
		while (balance + amount < -1000) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
		balance = balance + amount;
		notifyAll();
	}

	public double getBalance() {
		return balance;

	}
}
