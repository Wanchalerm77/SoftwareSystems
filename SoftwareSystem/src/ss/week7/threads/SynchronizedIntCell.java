package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {

	private boolean empty = true;
	private int value = 0;

	public synchronized void setValue(int valueArg) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.value = valueArg;
		empty = false;
		notifyAll();

	}

	public synchronized int getValue() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		return value;
	}
}
