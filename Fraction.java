public class Fraction {
	
	// step 1
	private int numerator, denominator;
	
	// step 2
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
	
	// step 3
	public Fraction() {
		this.denominator = 1;
		this.numerator =0;
	}
	
	// step 4
	@Override
	public String toString() {
		String d, n;
		d = Integer.toString(this.denominator);
		n = Integer.toString(this.numerator);
				
		return "(" + n + "/" + d + ")";
	}
	
	//step 5
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
	//step 6
	public void negate() {
		this.numerator = (-1)*this.numerator;
	}
	
	//step 7
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
	
	//step 8
	public double toDouble()
	{	
		// https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
		return this.numerator *1.0 / this.denominator;
	}
	
	//step 9
	public Fraction add(Fraction f) {
		
		int sum_n;
		int sum_d;
		
		sum_n = (this.numerator*f.denominator) + (f.numerator*this.denominator);
		sum_d = f.denominator * this.denominator;
		
		Fraction sum = new Fraction(sum_n,sum_d);
		
		return sum;
	}
		
}
