
public class ULUL {

	public static void main(String[] args) {

		Thread a = new Thread(new Countdown());
		Thread b = new Thread(new Countdown());

		a.start();
		b.start();

	}

}

class Countdown implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}

	}

}
