package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {

	private Lock lock = new ReentrantLock();
	private int num1, num2, sum2;

	public TestSyncConsole(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
	}

	@Override
	public void run() {
		sum2();

	}

	private synchronized void sum() {

		int num1 = SyncConsole.readInt(currentThread().getName() + ": get number 1?");
		int num2 = SyncConsole.readInt(currentThread().getName() + ": get number 2?");
		int sum = num1 + num2;
		SyncConsole.println(currentThread().getName() + ":  " + num1 + " +  " + num2 + " = " + sum);

	}

	private void sum2() {
		lock.lock();
		try {
			num1 = SyncConsole.readInt(currentThread().getName() + ":  get number 1?!");
			num2 = SyncConsole.readInt(currentThread().getName() + ":  get number 2?!");
			sum2 = num1 + num2;
			SyncConsole.println(currentThread().getName() + ":  " + num1 + " +  " + num2 + " = " + sum2);

		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		Thread tc = new TestSyncConsole("Thread A");
		tc.start();
		Thread tc2 = new TestSyncConsole("Thread B");
		tc2.start();

	}

}
