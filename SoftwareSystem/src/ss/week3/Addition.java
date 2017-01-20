package ss.week3;

public class Addition implements OperatorWithIdentity {

	@Override
	public int operate(int left, int right) {
		// TODO Auto-generated method stub
		return left + right;
	}

	@Override
	public int identity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		OperatorWithIdentity op = new Addition();
		System.out.println(op.operate(9, 10));
	}

}
