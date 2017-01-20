package ss.week4;

public class Polynomial implements Function, Integrandable {

	private LinearProduct[] arrayPoly;
	double[] theList;

	public Polynomial(double[] theList) {

		if (theList != null) {
			arrayPoly = new LinearProduct[theList.length];
			for (int i = 0; i < theList.length; i++) {
				arrayPoly[i] = new LinearProduct(new Exponent(i), new Constant(theList[i]));

			}
		}

	}

	@Override
	public double apply(double d) {
		if (theList != null) {

			return new Polynomial(theList).apply(d);
		}
		return d;

	}

	@Override
	public Function derivative() {
		LinearProduct derivativeArray;
		Function derivative = null;

		for (int i = 0; i < arrayPoly.length; i++) {
			derivativeArray = (LinearProduct) arrayPoly[i].derivative();
			if (derivative == null) {
				derivative = derivativeArray;
			} else {
				derivative = new Sum(derivativeArray, derivative);
			}
		}
		return derivative;
	}

	@Override
	public Function integrand() {
		Function primitive = null;
		LinearProduct primitiveArray;

		for (int i = 0; i < arrayPoly.length; i++) {
			primitiveArray = (LinearProduct) arrayPoly[i].integrand();
			if (primitive == null) {
				primitive = primitiveArray;
			} else {
				primitive = new Sum(primitiveArray, primitive);
			}
		}
		return primitive;
	}
}
