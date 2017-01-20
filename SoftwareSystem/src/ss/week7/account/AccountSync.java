package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		Account account = new Account();
		Thread t1 = new Thread(new MyThread(50.0, 2, account));
		Thread t2 = new Thread(new MyThread(-50.0, 2, account));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			System.out.println("");

			/*
			 * Since both threads share the same resource "balance" one could
			 * change the balance while the other is retrieving to perform the
			 * transaction
			 */

		}
		System.out.println(account.getBalance());

	}
}
