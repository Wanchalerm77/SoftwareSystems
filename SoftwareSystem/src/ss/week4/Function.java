package ss.week4;

public interface Function {

	double apply(double value);

	Function derivative();

	@Override
	String toString();

}
