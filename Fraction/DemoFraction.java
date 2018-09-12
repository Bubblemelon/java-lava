// this class extends the Fraction class
public class DemoFraction extends Fraction{
	
	public static void main(String[] args) {
			
			Fraction f = new Fraction(-4,-5);
			System.out.println(f.toString());
			
			// step 5
			f.invert();
			System.out.println(f.toString());
			
			//step 6
			f.negate();
			System.out.println(f.toString());
			
			// step 7
			Fraction f2 = new Fraction(-5,4);
			f2.equals(f); //true
			
			// step 9 and 7
			Fraction f3 = new Fraction(2,3); 
			f3.equals(f); //false
			
			double d = f3.toDouble();
			System.out.println(d);
			
			//step 9
			Fraction f4 = new Fraction(3,5);
			Fraction f5 = f3.add(f4); 
			System.out.println(f5.toString());
			
		}

}
