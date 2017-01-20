package ss.week4;

public class LinearProduct extends Product implements Function, Integrandable {

	public LinearProduct(Function a, Constant constant) {
		super(a, constant);

	}

	@Override
	public double apply(double d) {
		return super.apply(d);

	}

	@Override
	public Function derivative() {
		return new LinearProduct(c.derivative(), (Constant) d);

	}

	@Override
	public Function integrand() {
		// TODO Auto-generated method stub
		if (c instanceof Integrandable && d instanceof Constant) {
			return new LinearProduct(((Integrandable) c).integrand(), (Constant) d);
		}
		return null;

	}

	@Override
	public String toString() {
		return "" + (super.c) + " * " + super.d;
	}
}
