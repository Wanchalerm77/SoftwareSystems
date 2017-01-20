package ss.week7.threads;

public class TestConsole extends Thread {

	public TestConsole(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
	}

	@Override
	public void run() {
		sum();

	}

	private void sum() {
		int num1 = Console.readInt(currentThread().getName() + ": get number 1?");
		int num2 = Console.readInt(currentThread().getName() + ": get number 2?");
		int sum = num1 + num2;
		Console.println(currentThread().getName() + ":  " + num1 + " +  " + num2 + " = " + sum);

	}

	public static void main(String[] args) {
		Thread tc = new TestConsole("Thread A");
		tc.start();
		Thread tc2 = new TestConsole("Thread B");
		tc2.start();

	}

}
