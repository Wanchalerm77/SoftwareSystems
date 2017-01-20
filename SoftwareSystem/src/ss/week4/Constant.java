package ss.week4;

public class Constant implements Function, Integrandable {
	private double d;

	public Constant(double x) {
		d = x;
	}

	@Override
	public double apply(double value) {
		return d;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}

	@Override
	public String toString() {
		return Double.toString(d);
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Exponent(1), new Constant(d));
	}

}
