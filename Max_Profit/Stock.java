/**
 *
 * 	Each day the stock price fluctuates during the day.
 *  Given an array of stock prices,
 *  what would be the most efficient way to determine the best time
 *  to buy and sell to get the max profit.
 *  You must buy before you sell.

	Examples:

	maxProfit( [ 1, 3, 5, 4, 3, 5, 10, 9, 8, 4, 9]) ->  buy at 1, sell at 10

	maxProfit( [ 2 , 3, 1, 5, 6, 9, 10, 15, 14 ]) -> buy at 1, sell at 15

	maxProfit( [ 15, 12, 11, 9, 7, 5, 3, 1] ) -> no profit is possible
 *
 *
 * Version notes: This was my first attempt. Covers very few cases.
 *
 */

import java.util.*;

public class Stock {

	public Stock() {}

	private static void maxProfit( int[] array ) {

		// cannot compute if array only has one or less element
		if(array.length <= 1) {
			System.out.println("No profit possible!");
			return;
		}

		// save values from array to ArrayList
		ArrayList<Integer> a = new ArrayList<Integer>();

		System.out.print("Prices: ");
		for(int i=0; i < array.length; i++) {
			a.add(array[i]);
			System.out.print( array[i] + " ");
		}

		while(a.size() != 0)
		{
			// find the min (the smallest in the array)
			Object o = Collections.min(a);
			int min = (int)(o);

			// find the index of min
			int min_index = a.indexOf(min);

			// find the max (the larfer in the array)
			o = Collections.max(a);
			int max = (int)(o);

			// find the index of max
			int max_index = a.indexOf(max);

//			System.out.println(min);
//			System.out.println(min_index);
//
//			System.out.println(max);
//			System.out.println(max_index);

			// the index of max must be more than min
			// selling cannot be done before buying at min

			if(max_index > min_index) {
				System.out.println("\nBuy at: $" + min + "\nSell at: $" + max + "\nProfit: $" + (max-min) );
				return;
			}

			a.remove(min_index);
			a.remove(max_index);
		}

		System.out.println("\nNo profit possible!");

	}


	public static void main(String[] args) {

		int[] xx = {};
		int[] x = {1};

//		maxProfit(xx);
//		maxProfit(x);

		int[] a = {1, 3, 5, 4, 3, 5, 10, 9, 8, 4, 9};
		int[] b = {2 , 3, 1, 5, 6, 9, 10, 15, 14};
		int[] c = { 15, 12, 11, 9, 7, 5, 3, 1};


		maxProfit(c);


	}

}
