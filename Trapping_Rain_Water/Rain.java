// Reference for Rain Water Trapped challenge:
// https://leetcode.com/problems/trapping-rain-water/description/
// https://www.geeksforgeeks.org/trapping-rain-water/
// https://www.hackerrank.com/contests/knitopencontest/challenges/rain-harvester

public class Rain {

	public int waterTrapped(int[] heights) {

        int n = heights.length;

        int unitWater = 0;

        if(n != 0 ){

        	// to store the highest encountered height from left to right (ascending -->)
            int left[] = new int[n];

            // // to store the highest encountered height from right to left (<-- ascending)
            int right[] = new int[n];


            // first element of left takes the first element of heights
            left[0] = heights[0];


            for (int i = 1; i < n; i++) {

            	// compare current left element with next height from heights
                left[i] = Math.max(left[i-1], heights[i]);
            }

            /* for case a
             *
             * left array:
             *
             		              x x x
            		      x x x x x x x
            		_ x x x x x x x x x

            *
            */


            // last element of right takes the last element of heights
            right[n-1] = heights[n-1];


            for (int i = (n)-2; i >= 0; i--) {

            	// compare current right element with next height from heights (backwards)
            	 right[i] = Math.max(right[i+1], heights[i]);
            }

            /* for case a
             *
             * left array:
             *
             		x x x x x x x x
            		x x x x x x x x x
            		x x x x x x x x x x

            *
            */

            for (int i = 0; i < n; i++)
            {
            	// 1. Overlay the left and right elements over each other on the same index
            	//
            	// 2. Find the min at each current index between elements of left and right
            	// 	   e.g. i = 1, min(l,r) == min(1,3) = 1
            	//
            	// 3. To find where water is collected use that min and minus by the height of heights at that current index
            	//    e.g. i = 1, heights[i] = 1, min = 1, unitWater collected at i = 0 ... since, water must be bounded in order to be collected!
            	//
            	// 4. Note: no water is collected on the sides e.g. at index 0 and index n-1 of an array
            	unitWater += Math.min(left[i],right[i]) - heights[i];
            }

        }

		return unitWater;

    }

	public static void main(String[] args) {

	   Rain r = new Rain();

		int[] xx = {}; //0
		int[] x = {1}; //0




/* for case int[] a :
 *
 		              x
		      x       x x
		_ x _ x x _ x x x x x


 		              x
		      x 0 0 0 x x
		_ x 0 x x 0 x x x x x

	   zero '0' == where water is collected

*
*/
		int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1 }; // 5


		int[] b = {4, 2, 5, 3, 0, 4, 3, 2, 1, 3}; // 10
		int[] c = {2, 0, 0, 1, 0, 3, 0, 4}; // 10
		int[] d = {3, 1, 4}; // 2
		int[] e = {3, 4, 1}; // 0

    // geeksforgeeks cases
    int[] f = {2, 0, 2}; // 2
    int[] g = {3, 0, 0, 2, 0, 4}; // 10
    int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6

    // hackerrank
    int[] i = {0, 4, 0, 2, 0, 1}; // 3
    int[] j = {0, 1, 0, 1, 0, 5, 0, 4, 0, 3, 0, 2 }; // 11
    int[] k = {0, 2, 0, 3, 0, 2, 0, 1, 0, 1}; // 6

		System.out.println("Unit Water Collected: " + r.waterTrapped(k));

	}

}
