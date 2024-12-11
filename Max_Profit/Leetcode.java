/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 *
 * Question source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
 *
 * Version notes: Covers all cases, but very bad runtime!
 */

import java.util.*;



public class Leetcode {

	private class Report {

		private int min;
		private int max;
		private int profit;

		public Report(int min, int max) {
			this.min = min;
			this.max = max;
			this.profit = max - min;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public int getProfit() {
			return profit;
		}
		public void setProfit(int profit) {
			this.profit = profit;
		}

		// use indexOf to return index of element

	}

	private int maxProfit( int[] array ) {


		// to check arraylist a's sublist's next elements
		Iterator<Integer> it;

		List<Report> reports = new ArrayList<Report>();

        // cannot compute if array only has one or less element
		if(array.length <= 1) {
			// System.out.println("No profit possible!");
			return 0;
		}

		// save values from array to ArrayList
		List<Integer> a = new ArrayList<Integer>();

		// System.out.print("Prices: ");
		for(int i=0; i < array.length; i++) {
			a.add(array[i]);
			// System.out.print( array[i] + " ");
		}

		while(a.size() != 0)
		{
			// find the min (the smallest in the array)
			Object o = Collections.min(a);
			int min = (int)(o);

			// System.out.println("min: " + min);


			// find the index of min
			int min_index = a.indexOf(min);

			// System.out.println("min index: " + min_index);

			// find the max (the larger in the array)

			// System.out.println("size: " + (a.size()-1));
//			if( min_index == (a.size()-1) ) {
//				return 0;
//			}

			it = a.subList(min_index, a.size()).iterator();


			// hasNext is true when iterator has 1 or more elements
			if(it.hasNext() && a.subList(min_index, a.size()).size() != 1) {


				o = Collections.max(a.subList(min_index, a.size()));
				int max = (int)(o);

				// save as a report
				reports.add( new Report(min, max) );

			}

//				System.out.println("POP");
				a.remove(min_index);



		}

		// find reports highest profit
		if(! reports.isEmpty()) {

			if(reports.size() == 1) {
				return reports.get(0).getProfit();
			}

			int max_return = reports.get(0).getProfit();

			for(int i=0; i < reports.size()-1; i++) {

				if( reports.get(i+1).getProfit() > max_return ) {
					max_return = reports.get(i+1).getProfit();
				}

			}
			return max_return;
		}


		// System.out.println("\nNo profit possible!");
        return 0;

    }




	public static void main(String[] args) {

		Leetcode oo = new Leetcode();

		int[] xx = {};
		int[] x = {1};

		// from Stock.java
		int[] a = {1, 3, 5, 4, 3, 5, 10, 9, 8, 4, 9}; // returns 9;
		int[] b = {2 , 3, 1, 5, 6, 9, 10, 15, 14}; // returns 14
		int[] c = {15, 12, 11, 9, 7, 5, 3, 1}; // return 0

		// Leetcode
		int[] d = {7, 1, 5, 3, 6, 4}; //return 5
		int[] e = {7, 6, 4, 3, 1}; //returns 0
		int[] f = {1, 2}; // returns 1
		int[] g = {2, 4, 1}; // returns 2
		int[] h = {3, 2, 6, 5, 0, 3}; // returns 4

		System.out.println(oo.maxProfit(d));

	}

}
