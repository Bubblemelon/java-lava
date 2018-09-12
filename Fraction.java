public class Fraction {
	
	// private variables
	private int numerator, denominator;
	
	// creates a fraction
	// If both n and d are negative then fraction is positive
	// changes d to a positve if negative
	public Fraction(int n, int d) {
		
		if( d < 0 ) {
			this.denominator = (-1)*d;
			if(n < 0 ) {
				this.numerator = (-1)*n;
			}else {
				this.numerator = n;
			}
		}else {
			this.denominator = d;
			this.numerator = n;
		}	
	}
	
	// creates a default fraction
	public Fraction() {
		this.denominator = 1;
		this.numerator =0;
	}
	
	// step 5
	// Overrides the toString method for printing
	@Override
	public String toString() {
		String d, n;
		d = Integer.toString(this.denominator);
		n = Integer.toString(this.numerator);
				
		return "(" + n + "/" + d + ")";
	}
	
	// step 6
	// inverts d with n and n with d
	public void invert() {
		
		int tmp_d = denominator;
		int tmp_n = numerator;
 				
		if( this.denominator < 0 ) {
			
			this.numerator = (-1)*tmp_d;
			if(tmp_n < 0) {
				this.denominator = (-1)*tmp_n;
			}else {
				this.denominator = tmp_n;
			}
		}else {
			this.numerator  = tmp_d;
			this.denominator = tmp_n;
		}	
		
	}
	// step 7
	// negates only the numerator
	public void negate() {
		this.numerator = (-1)*this.numerator;
	}
	
	// step 8
	// checks if two fractions are equal
	// returns true if equals
	public boolean equals(Fraction f) {
		int left = f.numerator * this.denominator;
		int right = f.denominator * this.numerator;
		
		if( left == right)
		{	
			System.out.println("TRUE");
			return true;
		}
		System.out.println("FALSE");
		return false;
	}
	
	// step 8
	// returns the fraction value as a double
	public double toDouble()
	{	
		// https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
		return this.numerator *1.0 / this.denominator;
	}
	
	// step 9
	// add two fractions together and returns a new fraction as a result
	public Fraction add(Fraction f) {
		
		int sum_n;
		int sum_d;
		
		sum_n = (this.numerator*f.denominator) + (f.numerator*this.denominator);
		sum_d = f.denominator * this.denominator;
		
		Fraction sum = new Fraction(sum_n,sum_d);
		
		return sum;
	}
		
}
