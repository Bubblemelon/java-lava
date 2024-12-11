import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;


public class Histogram {

	// save file inputs into a hashmap
	public Map<Character,Integer> file2Map(char[] fileInputs){

		Map<Character,Integer> m = new HashMap<Character,Integer>();

		int freqCounter = 1;

		// position counter for loop
		for(int i=0; i < fileInputs.length; i++)
		{
			// if key does not exists
			if( !m.containsKey(fileInputs[i]) )
			{
				// comparision for loop
				for(int j = i+1; j < fileInputs.length; j++ )
				{
					// do comparision
					if(fileInputs[i]==fileInputs[j]){
						freqCounter++;
					}
			
				}
			
				m.put(fileInputs[i], freqCounter);
			}
			freqCounter = 1;
		}

		// print hashmap
		// System.out.println("\t" + m); 

		return m;

	}

	// Prints the Key and Value of a HashMap	
	public void printOccurences(Map<Character,Integer> m){

		System.out.println();

		System.out.println("Char\tOccurence");


		/* Uncomment this to only list out A - Z characters
		 *
		 */
		// for(char c= 'A'; c <= 'Z'; c++)
		// {
		// 	if(m.containsKey(c)){
		//
		// 		System.out.println(" " + c + "\t    " + m.get(c));
		// 	}
		// }
		// System.out.println();



		Iterator entries = m.entrySet().iterator();

		while (entries.hasNext()) {
   			 Map.Entry entry = (Map.Entry) entries.next();
    		 Character key = (Character)entry.getKey();
   			 Integer value = (Integer)entry.getValue();
   			 System.out.println(" " + key + "\t    " + value);   
        }
		System.out.println();
	}

	// bubblesort the hashmap from lowest to highest freq (ascending)
	public List<Integer> bubbleSortMap(Map<Character,Integer> m){

		Boolean swapped;
		int temp = 0;

		// place hashmap values into an arraylist
		List<Integer> list = new ArrayList<Integer>(m.values());
	
		do{
			swapped = false;
 
			// for(int j=0; j < list.size() ; j++)
			// {
			// 	System.out.print(list.get(j));
			// }
			// System.out.println();

			for(int i=0; i < list.size() - 1 ; i++) {
			
				if( list.get(i) > list.get(i+1) ){

					// save larger
					temp = list.get(i);
					// put smaller in new position
					list.set(i, list.get(i+1));
					// put larger in new position
					list.set(i+1, temp);
					swapped = true;
				}
			}

		} while(swapped);

		return list;
	}
	// removes freq duplicates
	public List<Integer> removeDuplicateFreq(List<Integer> l){

		// prints list
		// for(int jj=0; jj < l.size(); jj++ )
		// {
		// 	System.out.print(l.get(jj));
		// }
		// System.out.println();

		for(int ii =0; ii < l.size(); ii++){

			for(int i = ii + 1; i < l.size(); i++){

				if( l.get(ii) == l.get(i) )
				{
					l.remove(i);
					i--;
				}
			}

		}

		// prints list
		// for(int j=0; j < l.size(); j++ )
		// {
		// 	System.out.print(l.get(j));
		// }
		// System.out.println();

		return l;
	}

	// returns the keys ( as an arraylist ) from a value of a hashmap
	// one to many (keys to values)
	// many to one (values to keys)
	public List<Character> getKeyValue(Map<Character,Integer> m, Integer value){

		// int count =0;
		List<Character> list = new ArrayList<Character>();

		for(Map.Entry<Character,Integer> e: m.entrySet()){
			
			if(value.equals(e.getValue())){

				// System.out.print(count);
				// System.out.println(e.getKey());
				list.add(e.getKey());
				// count++;
			}

			// System.out.printf("%t", list);
		}

		// prints list
		// System.out.print("HELLO");
		// for(int i=0; i < list.size(); i++){
		// 	System.out.print(list.get(i));
		// }

		return list;

	}
	// prints stars
	public void printStars(Map<Character,Integer> m, Integer maxFreq, List<Character> l, int spaceLength){

		Map<Integer,Integer> starMap = new HashMap<Integer,Integer>();

		Histogram h = new Histogram();

		int n =0; //number of spaces

		for(int i=maxFreq; 1 <= i; i--){

			int counter = 0;

			for(int j=0; j < l.size(); j++)
			{	
				if( m.get(l.get(j)) >= i)
				{						
					counter++;
				}

			}
			starMap.put(i,counter);
			// System.out.println(counter);

		}
		// print hashmap
		// System.out.println("\t" + starMap); 

			for(int kk=maxFreq; 1 <= kk; kk--){

				if( starMap.get(kk) > 1)
				{	
					// *3 for star and space taken into account
					n = spaceLength - (starMap.get(kk)*3) +1;
				}
				else{
					n = spaceLength - starMap.get(kk) -1;
				}


				System.out.print("|  "+ kk + " |");
				System.out.format("%"+n+"s", "");
				for(int kkk =0; kkk < starMap.get(kk); kkk++)
				{
					System.out.print(" *");
					System.out.print(" ");
				}
				System.out.println();
			}
		
	}


	// prints the histogram table
	public void printTable(Map<Character,Integer> m){
		
		//variables
		Histogram h = new Histogram();
		List<Integer> values = h.removeDuplicateFreq(bubbleSortMap(m));  // contains non-repeating freq numbers
		List<Character> row = new ArrayList<Character>(); // contains the entire alphabet row
		List<Character> keys; // just the letters with freq
		// MAX Freq number
		Integer maxFreq = Collections.max(values);
		// to store string length
		String spaceStr ="" ;
		/*
		 * generate alphabet row
		 */

		// letter row with freq numbers
		for(int i=0; i < values.size(); i++)
		{
			row.addAll(h.getKeyValue(m, values.get(i)));
		}
		// prints above row 
		// for(int ii=0; ii<row.size(); ii++)
		// {
		// 	System.out.print(row.get(ii));
		// }

		keys = new ArrayList<Character>(row);

		// letter row without freq numbers
		int remainingLetters = 11 - row.size(); // total A - K = 11 letters

		int j = 0;
		while(j < remainingLetters)
		{
			for(Character c= 'A'; c <= 'K'; c++){

				if(!row.contains(c))
				{
					row.add(j,c);
					j++; // cannot do this with a for loop, otherwise make another list (l.add(c)) then combine usiing addAll.
				}
				
			}
		}
		for(int jjj=0; jjj<row.size(); jjj++)
		{
			spaceStr += row.get(jjj) + "  ";
		}

		System.out.println(m.size() + " Total Characters"); 

		// // horizontal bar
		h.horizonBar(m);

		// CALLL method here!!!
		h.printStars(m, maxFreq, keys, spaceStr.length());

		// // horizontal bar
		h.horizonBar(m);
		System.out.print("| NO |  "); //8 character string

		for(int jj=0; jj<row.size(); jj++)
		{
			System.out.print(row.get(jj) + "  ");
		}

		System.out.println();

		h.horizonBar(m);

	}
	public void horizonBar(Map m){

		int itLength = (m.size()*3)+ 5; // including | NO | && minus 3 spaces in the end

		for(int i=0; i <= itLength; i++)
		{
			System.out.print("=");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// variables
		Histogram h = new Histogram();
		// int lineCount = 0;
		String contents = "";
		

		try {
			System.out.println("Input filename: "); // /home/cherylfong/tmp.uZGuK44EF4/t1.txt
			
			// Scanner object //System.in
			Scanner input = new Scanner("/home/cherylfong/tmp.uZGuK44EF4/t3.txt");
			// Scanner input = new Scanner(System.in);

			// File object
			File file = new File(input.nextLine());
			
			// Take all contents from File object
			input = new Scanner(file);
			
			// save the number of lines
			while(input.hasNextLine()) {

				contents += input.nextLine();
				// number of line
				// lineCount++;
			}
			// convert String contents to char Array

			char c_arr[] = contents.toCharArray();
			
			Map<Character,Integer> testMap = h.file2Map(c_arr);
			h.printOccurences(testMap);

			//printTable
			h.printTable(testMap);

			// close Scanner object
			input.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}

}



