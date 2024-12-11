import java.util.InputMismatchException;
import java.util.Scanner;

// This class demos the relationship between the
// OnlineStore class, Product and Order classes.

public class OnlineStoreDemo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		OnlineStore oS = new OnlineStore("My Store");
		int option = 0;
		boolean asking = true;
		
		System.out.println("Welcome to " + oS.getName() + " !");
		
		do {
			
			System.out.println("Select your choice: ");
			System.out.println("\t1. Add Product to Online Store");
			System.out.println("\t2. All Product Information in Store");
			System.out.println("\t3. Make an Order");
			System.out.println("\t4. Exit");
			
			try {
				option = sc.nextInt();
			} 
			catch(InputMismatchException e)
		    {
		           System.out.println("Must be numbers, no other characters are allowed!\n");
		           sc.nextLine();
		    }
			
			switch (option) {
			
			case 1:
				oS.addProduct();
				break;
			
			case 2:
				oS.productInfo();
				break;
			
			case 3:
				oS.makeOrder();
				break;
				
			case 4:
				System.out.println("Bye! Come again!");
				asking = false;
				break;
				
			default:
				System.out.println("Your selection can only be between numbers 1 to 4 !");
			}
			
		}while(asking);
	}

	
}
