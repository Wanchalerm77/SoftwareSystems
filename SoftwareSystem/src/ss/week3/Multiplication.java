package ss.week3;

public class Multiplication implements OperatorWithIdentity {

	@Override
	public int operate(int left, int right) {
		// TODO Auto-generated method stub
		return left * right;
	}

	@Override
	public int identity() {
		// TODO Auto-generated method stub
		return 1;
	}

	public static void main(String[] args) {
		OperatorWithIdentity test = new Multiplication();
		System.out.println(test.operate(3, 7));
		System.out.println("tewennyone");

	}

}
