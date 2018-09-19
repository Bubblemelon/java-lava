public class ArrayBalance {
	

    /*
    * Given an array of int values,
    * is there a index in the array where the sum of values[0 ... index]
    * is equal to the sum of values[index+1 ... length-1]
    * 
    * Explanation and test cases in main method.
    */ 
	

    public static boolean arrayBalance(int[] a) {
    	
    	int l = 0;     // iterate starting from left
    	int lsum = 0;  // sum from the left
    	int r = a.length -1 ;     // iterate starting from right 
    	int rsum = 0;  // sum from the right
    	
    	// even offset
    	int even = 0;
    	
    	//find mid point  	
    	int limit= a.length / 2;
    	
    	// check for even or odd array
    	int remainder = a.length % 2;
    	
    	// even array
    	if(remainder == 0) {
    		even = 1;
    	}
    	
//    	System.out.println("limit -->" + limit);
    	
    	// gather sum from the left side of the array
		for(;l < (limit ); l++)
		{
			lsum += a[l];
		}
		
//		System.out.println("lsum " + lsum);
//		System.out.println("r " + r);
		
		// gather sum from the right side of the array
		for(; r > limit - even ; r--)
		{
			rsum += a[r];
		}
		
//		System.out.println("rsum " + rsum);

    	// odd array
    	if( remainder != 0)
    	{
		
    		if(rsum > lsum) {
    			
    			if(lsum + a[limit] == rsum) {
    				System.out.print("MATCH! --- ");
    				return true;
    			} else {
    				System.out.print("--- NO MATCH --- ");
    				return false;
    			}
    			
    			// lsum >= rsum
    		} else {
    			
    			if(rsum + a[limit] == lsum)
    			{
    				System.out.print("MATCH! --- ");
    				return true;
    			} else {
    				System.out.print("--- NO MATCH --- ");
    				return false;
    			}
    			
    		}
    		
    	// even number of elements
    	} else {
    		

    		//since both sides of array is even in the number of elements
    		
    		if(rsum == lsum )
    		{
    			System.out.print("MATCH! --- ");
				return true;
    		}
    		
    	}
    	
    	
    	System.out.print("--- NO MATCH --- ");
    	return false;

    }
    	
  	
    public static void main(String[] args) {
        
        boolean r;
        r = arrayBalance(new int[] {1, 1, 1, 2, 1});
        System.out.println("arrayBalance(new int[] {1, 1, 1, 2, 1}) - expected behavour true. Actual: "+r);
        
        /*  Explained:
         * 
         * 0 1 2 | 3 4   (indexes)
         * 1 1 1 | 2 1	 (elements)	
         *       |
         * 
         *   3     3
         * 
         * This returns true, index 2, will cause elements on both sides to be equal
         *   
         */
        
        r = arrayBalance(new int[] {2, 1, 1, 2, 1 });
        System.out.println("arrayBalance(new int[] {2, 1, 1, 2, 1 }) - expected behavour false. Actual: "+r);

        
        /*  Explained:
         * 
         * 0 1 2 | 3 4   (indexes)
         * 2 1 1 | 2 1	 (elements)	
         *       |
         * 
         *   4     3
         * 
         * This returns false, both sides are not equal
         *   
         */
        
        r = arrayBalance(new int[] {10, 10});
        System.out.println("arrayBalance(new int[] {10, 10}) - expected behavour true. Actual: "+r);
        
        r = arrayBalance(new int[] {10, 0, 1, -1, 10} );
        System.out.println("arrayBalance(new int[] {10, 0, 1, -1, 10}) - expected behavour true. Actual: "+r); 

        r = arrayBalance(new int[] { 1});
        System.out.println("arrayBalance(new int[] { 1}) - expected behavour false. Actual: "+r);
        
        r = arrayBalance(new int[] {2, 1, 1, 1, 1});
        System.out.println("arrayBalance(new int[] {2, 1, 1, 1, 1}) - expected behavour true. Actual: "+r);     

    }
    


}
