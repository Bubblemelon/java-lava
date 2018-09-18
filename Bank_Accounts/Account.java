public class Account {

    private String name;
    private int number;
    private int type;
    private double balance;
    
    public Account() {
    	
    }
    
    public Account(String name, int number, int type, double balance)
    {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
    
    // to check if account number is the same
    public boolean accountNumCheck(int num) {
    	
    	if(this.number == num) {
    		return true;
    	}
    
    	return false;
    }
    
    // to deposit money
    public boolean deposit(double fund)
    {
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        }
        else
        {
            balance += fund;
            System.out.println("Deposit: This is your updated balance: " + this.getBalance());
            return true;
        }
    }

    // to withdraw money
    public boolean withdrawal(double fund)
    {
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
        else 
        {
            balance -= fund;
            System.out.println("Withdrawal: This is your updated balance: " + this.getBalance());
            return true;
        }
    }

    /*getter and setter for account name attribute*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*getter and setter for account number attribute*/
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	/*getter and setter for account type attribute*/
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	/*getter and setter for account balance attribute*/
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}