package ss.week4;

public class Product implements Function {
	protected Function c;
	protected Function d;

	public Product(Function c, Function d) {
		this.c = c;
		this.d = d;
	}

	@Override
	public double apply(double d) {
		return c.apply(d) * this.d.apply(d);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(c.derivative(), d), new Product(c, d.derivative()));
	}

	@Override
	public String toString() {
		return " " + this.c + " " + this.d;
	}

}
