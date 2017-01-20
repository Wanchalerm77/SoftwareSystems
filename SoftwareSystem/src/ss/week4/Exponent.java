package ss.week4;

public class Exponent implements Function, Integrandable {
	private double n;

	public Exponent(double n) {
		this.n = n;

	}

	@Override
	public double apply(double d) {
		return Math.pow(d, n);
	}

	@Override
	public Function derivative() {

		return new LinearProduct(new Exponent(n - 1), new Constant(n));
	}

	/** 1/(n+1) can be written as (n+1)^-1 */
	@Override
	public Function integrand() {
		return new LinearProduct(new Exponent(n + 1), new Constant(1.0 / (n + 1)));
	}

	@Override
	public String toString() {
		return " x^" + this.n;
	}

}
