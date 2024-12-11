import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bank {
	
	private Account[] acc;
	private String bankName;
	private int numOfAccounts;
	private boolean duplicateAccNum;
	
	private static NumberFormat formatter = new DecimalFormat(".##");
	
	
	// allocates 3 accounts per bank instance
	public Bank() {
		
		// default is 3
		this.numOfAccounts = 3;
		this.acc = new Account[numOfAccounts];
		
//		for(int i = 0; i < numOfAccounts; i++) {
//			this.acc[i] = new Account("", -1, -1, 0.0);
//		}
		
		this.duplicateAccNum = false;
	}
		
	// sets the name of the bank
	public void setbankName(String s) {
		this.bankName = s;
		// prints the bank's name
		System.out.println(this.bankName + " is now established!");
	}
	
	
	
  /* prompts user to enter, the following details
	 account holder's name
	 account number
	 account type
	 and initial balance*/
	
	public boolean openAccount() {
		
		Scanner s = new Scanner(System.in);
		String name;
		int number;
		int type;
		double balance;
		
		// return false if there's already more than 3 accounts in bank 
		if(numOfAccounts == 0 ) {
			System.out.println("Error: this bank cannot open more than three accounts!");
			
			return false;
		}
        
         while(true){
            try{
                System.out.print("Enter account holder's name: ");
                name = s.nextLine(); // this string can be any number of characters, just not zero.
                if(name.length() != 0)
                {   
                	
                	if(name.matches("[ ]+")){
                        throw new IllegalArgumentException("Cannot be just space characters!\n");
                    }
                	
                	this.acc[ this.acc.length - this.numOfAccounts ] = new Account();
                	this.acc[ this.acc.length - this.numOfAccounts ].setName(name);
                	

                    break; 
                }
            }catch(IllegalArgumentException e){
            	
                System.out.println(e.getMessage());
            }		
         } // to ask account holder name
         
       while(true){
	       try{
	           System.out.print("Enter your prefered number(s) to set your bank account: ");
	           number = s.nextInt(); //just numbers ! (cannot be spaces or other characters)
	          
	       		//return false if account number is taken
	           
	           // default is 3, if equals zero then no, accounts made yet
	           this.duplicateAccNum = false;
	           if( (3 - this.numOfAccounts) != 0) {
	        	   
	        	   for(int i = 0; i < this.acc.length- this.numOfAccounts ; i++) {
	        		   
	        		   if(this.acc[i].accountNumCheck(number)) {
	        			  this.duplicateAccNum = true;
	        			  break;
	        		   }
	        	   }
	        	   
	        	   if(this.duplicateAccNum) {
	        		   throw new IllegalArgumentException("Account number is already taken!\n");
	        	   }
	           }
	           
	           this.acc[ this.acc.length - this.numOfAccounts ].setNumber(number);
	           break;
	       }
	       catch(InputMismatchException e)
	       {
	           System.out.println("Must be numbers, no other characters are allowed!\n");
	           s.nextLine();
	       }
	       catch(IllegalArgumentException e){
           	
               System.out.println(e.getMessage());
	       }
       } // to ask for account number 
       
       
       while(true){
	       try{
	        
	           System.out.print("Enter your bank account type, a choice of 1 or 2: ");
	           type = s.nextInt();
	           
	           if( type == 1 || type == 2) {
		           this.acc[ this.acc.length - numOfAccounts].setType(type);
		           break; 
	           } else {
	        	   throw new IllegalArgumentException("Must be either 1 or 2\n");
	           }

           }
	       catch(IllegalArgumentException e){
           	
               System.out.println(e.getMessage());
           }
	       catch(InputMismatchException e)
	       {
	           System.out.println("Must be either 1 or 2, no other characters are allowed!\n");
	           s.nextLine();
	       }
       } // to ask for account type
       
       while(true){
	       try{
	           System.out.print("Enter your bank account balance, may include decimal: ");
	           balance = s.nextDouble(); //just numbers ! (cannot be spaces or other characters)
	          
	           this.acc[ this.acc.length - this.numOfAccounts ].setBalance(balance);
	           break; 
	       }catch(InputMismatchException e)
	       {
	           System.out.println("Must be numbers, no other characters are allowed. You may include decimal!\n");
	           s.nextLine();
	       }
       } // to ask for account balance
       
       this.numOfAccounts--; // reduce the number of possible accounts 
       
//       s.close();
       
        return true;

	}
	
	// takes a bank account number and closes it (by assigning null that slot as null). - returns true
	// returns false if account number does not exist
	public boolean closeAccount(int accNum) {
		
		
		// checks if there's any accounts in the bank instance
		if( (this.acc.length - this.numOfAccounts) != 0) {
     	   
     	   for(int i = 0; i < this.acc.length ; i++) {
     		   
     		   if(this.acc[i] != null) {
     			   
     			// account number does exist!
         		   if(this.acc[i].accountNumCheck(accNum)) {
         			   
         			   // delete
         			   this.acc[i] = null;
         			   
         			   System.out.println("Account number: #" + accNum + " is now closed.");
         			   
         			   this.numOfAccounts++;
         			   return true;
         		   }
         		   
     		   }
     	   }

     	  // no bank accounts to close!
        } else {
        	
        	System.out.println("There are no bank accounts to close! #" + accNum + " is invalid!");
        	return false;
        }
		
		// if does not exist!
		System.out.println("The account number #" + accNum + " is not a registered " + this.bankName +" account!\n");
		return false;
	}
	
	/*	
	
	
	add money to balance
	
	
	*/
	public boolean addMoney() {
		
		Scanner s = new Scanner(System.in);
		int input = 0;
		double cash = 0.0;
		boolean asking = true;
		boolean returnning = false;
		
		 while(asking){
		       try{
		    	   
		    	   System.out.println("What is your bank account? ");
		    	   input = s.nextInt();
		    	   
	
	        	   for(int i = 0; i < this.acc.length ; i++) {
	        		   
	        		   // if not null then compare with for account number
	        		   if( this.acc[i] != null ) {
	        			   
	        			   if(this.acc[i].accountNumCheck(input)) {
	        				   asking = false;
	        				   break;   
	        			   }
	        		  
	        		   }
	        	   }
			        if(asking) {
			        	throw new IllegalArgumentException("Your input: " + input + " does not match any accounts!\n");
			        }
		        	   
		       }
		       catch(InputMismatchException e)
		       {
		           System.out.println("Must be numbers, no other characters are allowed!\n");
		           s.nextLine();
		       }
		       catch(IllegalArgumentException e){
	           	
	               System.out.println(e.getMessage());
		       }
	       } // to ask for account number 
		 
		 
	       while(true){
		       try{
		           System.out.print("Enter the amount to add: ");
		           cash = s.nextDouble(); //just numbers ! (cannot be spaces or other characters)
		           
		           if(cash < 0.0) {
		        	   
		        	   throw new IllegalArgumentException("No negative values!");

		           }
		           
		           break; 
		       }catch(InputMismatchException e)
		       {
		           System.out.println("Must be numbers, no other characters are allowed. You may include decimal!\n");
		           s.nextLine();
		       }
		       catch(IllegalArgumentException e) {
		    	   System.out.println(e.getMessage());
		       }
	       } // to ask for funds to add
	       
		 
		 
		 // to add funds!
		 for(int i = 0; i < this.acc.length ; i++) {
	  		   
	  		   // if not null then compare with for account number
	  		   if( this.acc[i] != null ) {
	  			   
	  			   // found the account
	  			   if(this.acc[i].accountNumCheck(input)) {
	  				   
	  				   // make the deposit
	  				   if(this.acc[i].deposit(cash)) {
	  					   returnning = true;
	  					   break;   
	  				   }

	  			   }
	  		  
	  		   }
	  	   }
		 
		if(! returnning ) {
			System.out.println("Deposit is unsuccessful");
		}
		return returnning;
	}
	
	/*	
	
	
	to take money from balance
	
	
	*/
	public boolean takeMoney() {
		
		Scanner s = new Scanner(System.in);
		int input = 0;
		double cash = 0.0;
		boolean asking = true;
		boolean returnning = false;
		
		 while(asking){
		       try{
		    	   
		    	   System.out.println("What is your bank account? ");
		    	   input = s.nextInt();
		    	   
	
	        	   for(int i = 0; i < this.acc.length ; i++) {
	        		   
	        		   // if not null then compare with for account number
	        		   if( this.acc[i] != null ) {
	        			   
	        			   if(this.acc[i].accountNumCheck(input)) {
	        				   asking = false;
	        				   break;   
	        			   }
	        		  
	        		   }
	        	   }
			        if(asking) {
			        	throw new IllegalArgumentException("Your input: " + input + " does not match any accounts!\n");
			        }
		        	   
		       }
		       catch(InputMismatchException e)
		       {
		           System.out.println("Must be numbers, no other characters are allowed!\n");
		           s.nextLine();
		       }
		       catch(IllegalArgumentException e){
	           	
	               System.out.println(e.getMessage());
		       }
	       } // to ask for account number 
		 
		 
	       while(true){
		       try{
		           System.out.print("Enter the amount to take out: ");
		           cash = s.nextDouble(); //just numbers ! (cannot be spaces or other characters)
		           
		           if(cash < 0.0) {
		        	   
		        	   throw new IllegalArgumentException("No negative values!");

		           }
		           
		           break; 
		       }catch(InputMismatchException e)
		       {
		           System.out.println("Must be numbers, no other characters are allowed. You may include decimal!\n");
		           s.nextLine();
		       }
		       catch(IllegalArgumentException e) {
		    	   System.out.println(e.getMessage());
		       }
	       } // to ask for funds to add

	       
	       // to take funds out!
			 for(int i = 0; i < this.acc.length ; i++) {
		  		   
		  		   // if not null then compare with for account number
		  		   if( this.acc[i] != null ) {
		  			   
		  			   // found the account
		  			   if(this.acc[i].accountNumCheck(input)) {
		  				   
		  				   // make the deposit
		  				   if(this.acc[i].withdrawal(cash)) {
		  					   returnning = true;
		  					   break;   
		  				   }

		  			   }
		  		  
		  		   }
		  	   }
			 
			if(! returnning ) {
				System.out.println("Withdrawal is unsuccessful");
			}
			return returnning;
		
	}

	
	
	// prints all bank accounts of the bank class instance
	public void printAllAccounts() {
		
		if(this.acc.length - this.numOfAccounts == 0) {

			System.out.println(this.bankName + " has no accounts !");
			return;
		}
		
		for(int i = 0; i < this.acc.length - this.numOfAccounts; i++) {
					
			System.out.println(this.acc[i].getName() + "'s Account: #" + this.acc[i].getNumber() + " has a total of " 
			+ formatter.format(this.acc[i].getBalance()) + " & with account type of: " + this.acc[i].getType() );
		}
		
		System.out.println();
		
	}
	
}


