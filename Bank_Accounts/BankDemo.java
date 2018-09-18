public class BankDemo {
	
	public static void main(String[] args) {
		
		Bank b = new Bank();
		
		System.out.println("TEST 1: verfiy openAccount and closeAccount functions:\n");
		b.setbankName("Cheryl's Bank");
		
		
		System.out.println("Enter bank details, as follows, Water, 888, 1, 1000000.05");
		System.out.println("b.openAccount() returns " + b.openAccount()); // returns as true
		System.out.println();
		
		// test deposit money and withdraw money
		System.out.println("b.addMoney() returns " + b.addMoney()); // returns as true
		System.out.println("b.takeMoney() returns " + b.takeMoney()); // returns as true
		System.out.println();
		
		// tests if function catches duplicate account number
		System.out.println("Enter bank details, as follows, Melon, 888 (use 8 as alternative), 1, 789.90");
		System.out.println("b.openAccount() returns " + b.openAccount()); // returns as true
		System.out.println();
		
		System.out.println("Enter bank details, as follows, Eater, 88, 2, 1223789.90");
		System.out.println("b.openAccount() returns " + b.openAccount()); // returns as true
		
		System.out.println();
		System.out.println("---- PRINT ALL 3 BANK ACCOUNTS ----\n");
	
		b.printAllAccounts();
		
		System.out.println();
		
		// the bank class only allows for 3 bank accounts
		System.out.println("TEST 2: The bank class does not allow or more than 3 accounts: \n");
		System.out.println("---- An error will occur after invoking the 4th openAccount function! ---- ");
		System.out.println("b.openAccount() returns " + b.openAccount()); // returns as false

		System.out.println();
		
		// closing an account verification
		System.out.println("TEST 4: Accounts 8, 88, 888 should be deleted/closed: \n");
		System.out.println("b.closeAccount() returns " + b.closeAccount(88)); // returns as true
		System.out.println();
		System.out.println("b.closeAccount() returns " + b.closeAccount(888)); // returns as false
		System.out.println();
		System.out.println("b.closeAccount() returns " + b.closeAccount(8)); // returns as false
		System.out.println();
		
		// No accounts to close verification
		System.out.println("TEST 5: There should be no accounts to close: \n");
		System.out.println("b.closeAccount() returns " + b.closeAccount(88)); // returns as false
		
		System.out.println();
		System.out.println("TEST 6: No accounts to print: \n");
		b.printAllAccounts();
		System.out.println();
		
		System.out.println("TEST 7: Attempt to open a new account: \n");
		System.out.println("b.openAccount() returns " + b.openAccount()); // returns as true
		// prints above account
		b.printAllAccounts();
		
	
	}
}