package ss.week4;

public class Sum implements Function, Integrandable {
	private Function a;
	private Function b;

	public Sum(Function f1, Function f2) {
		a = f1;
		b = f2;

	}

	@Override
	public double apply(double d) {
		return a.apply(d) + b.apply(d);

	}

	@Override
	public Sum derivative() {
		return new Sum(a.derivative(), b.derivative());
	}

	@Override
	public Function integrand() {
		// TODO Auto-generated method stub
		if (a instanceof Integrandable && b instanceof Integrandable) {
			if (a != null && b != null) {
				return new Sum(((Integrandable) a).integrand(), ((Integrandable) b).integrand());
			}

		}
		return null;

	}
}
