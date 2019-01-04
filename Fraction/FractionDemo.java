// this class extends the Fraction class
public class FractionDemo extends Fraction{

	public static void main(String[] args) {

			Fraction f = new Fraction(-4,-5);
			System.out.println(f.toString());

			f.invert();
			System.out.println(f.toString());

			f.negate();
			System.out.println(f.toString());

			Fraction f2 = new Fraction(-5,4);
			f2.equals(f); //true

			Fraction f3 = new Fraction(2,3);
			f3.equals(f); //false

			double d = f3.toDouble();
			System.out.println(d);
			
			Fraction f4 = new Fraction(3,5);
			Fraction f5 = f3.add(f4);
			System.out.println(f5.toString());

		}

}
