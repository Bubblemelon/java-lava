import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// Online Store Class
//
// can only have up to 10 maximum products
// & only 10 orders
public class OnlineStore {
	
	private String name;
	private Product products[]; // only 10 products
	private Order orders[]; // 10 orders only
	

	static int pNum = 10; //max number of products
	static int oNum = 10; //max number of orders
	
	
	Scanner s = new Scanner(System.in);
	
//	public OnlineStore() {}
	
	public OnlineStore(String name) {
		this.name = name;
		orders = new Order[oNum];
		products = new Product[pNum];
	}
	
	//setter and getter for name
	public void setName(String s) {
		this.name = s;
	}
	public String getName() {
		return this.name;
	}
	
	// setter and getter for products
	public void setProducts(Product[] p) {
		if(p.length > 10) {
			throw new IllegalArgumentException("Products cannot exceed more than 10!");
		}
		else {
			this.products = Arrays.copyOf(p, p.length);
		}
		
	}
	public Product[] getProducts() {
		return Arrays.copyOf(this.products, this.products.length);
	}
	
	// setter and getter for orders
	public void setOrders(Order[] o) {
		if(o.length > 10) {
			throw new IllegalArgumentException("Orders cannot exceed more than 10!");
		}
		else {
		this.orders = Arrays.copyOf(o, o.length);
		}
	}
	public Order[] getOrders() {
		return Arrays.copyOf(this.orders, this.orders.length);
	}
	
	//
	// adds a product to product array
	//
	public void addProduct() {
		int num;
		String name = null;
		double price;
		Product p;
		
		// ask for product number
		while(true) {
			try {
				System.out.print("Product Number: ");
				num = s.nextInt();
				if( productNumCheck(num) ) { // meaning that number is already stored (already exist in products array)
					throw new IllegalArgumentException("Input Error: Product " + num + " already exists!");
				}
				break;
			} catch(InputMismatchException e){
                System.out.println("Only numbers");
                s.nextLine();
            } catch (IllegalArgumentException e) {
            	System.out.println(e.getMessage());
            	s.nextLine();
            }		
		}
		
		// to stop asking Product name twice 
		// (will ask again because buffer contains value from first ask)
		// since cannot clear java scanner buffer!
		s.nextLine();  
		
		// ask for product name
		while(true) {
			try {
				System.out.print("Product Name: ");
				name = s.nextLine();
	            if(name.length() != 0)
	            {   
                	if(name.matches("[ ]+")){
                        throw new IllegalArgumentException("Cannot be just space characters!\n");
                    }
                	break;
	             }
			} catch(IllegalArgumentException e){
				 System.out.println(e.getMessage());
				 s.nextLine();
            }		
		}
		
		// ask for product price
		while(true)
		{
			try {
				
				System.out.print("Product Price: ");
				price = s.nextDouble();
				if( price <= 0.0 )
				{
					throw new IllegalArgumentException("Cannot be less than or equal to $0.0 or negative value!\n");
				}
				break;
				
			}catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				s.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Must only be numbers e.g. $1.00");
				s.nextLine();
			}
		}
		
		// create the new product
		p = new Product(num, name, price);
		
		// try adding the product to the products array
		// going backwards in the array
		try {
			products[pNum -1] = p;
			pNum--;	// decrement!
			System.out.println("Product Added - " + name + ", Number: " + num + ", Price: " + price + "\n");
		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("Unable to add product to products array!");
			System.out.println("Reached maximum number of products to add!");
		}
		
		
	}
	
	// checks if product id is already in products array
	// compares the given id with the ones already stored
	private boolean productNumCheck(int n) {
		
		for(int i=0; i < products.length; i++) {
			// return true if product id matches the parameter/given id
			if(products[i] != null) {
				if(products[i].getProductNum() == n) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// returns the product from the given product number
	private Product retriveProductStored(int n) {
		
		for(int i=0; i < products.length; i++) {
			// return true if product id matches the parameter/given id
			if(products[i] != null) {
				if(products[i].getProductNum() == n) {
					return products[i];
				}
			}
		}
		return null;
	}
	
	// prints the products stored
	public void productInfo() {
		int counter = 1;
		for(int i=products.length -1; i >= 0; i--) {
			
			if(products[i] != null) {
				System.out.println( counter + ". " + products[i].getName() + " (No. " + products[i].getProductNum() + "):"
						+ " $" + products[i].getUnitPrice());
				counter++;
				}
		}
	}
	
	// returns the number of existing orders in the orders array
	private int orderNumber() {
		int counter = 0;
		
		for(int i=orders.length -1; i >= 0; i--) {
			
			// increment counter whenever a non-null element is encountered
			if(orders[i] != null) {
				counter++;
				}
		}
		
		return counter;
		
	}

	// checkout the product or products mentioned 
	// one checkout == 1 order
	// max 10 orders
	public void makeOrder() {
		
		int num; // product number
		
		int currOrderProductNum = 0; // current order's number of products
		
		Order o = new Order(); 
		Product p = new Product();
		
		// if order number == 1, then there were no orders before this
		// generate an order number (from only 1 to 10)
		System.out.println("Your Order Number: " + (orderNumber() + 1)); // this is the new order number
		
		
		// ask for product number
		while(true) {
			try {
				System.out.print("What's the product number to order? (Type 0 zero to complete) ");
				num = s.nextInt();
				if (num != 0) {
					
					if( !productNumCheck(num) ) { // meaning that number is already stored (already exist in products array)
						throw new IllegalArgumentException("Error: Product " + num + " does not exist in your cart.");
					}
					
					// if number does exist, proceed with the following:
					
					// Retrieve the product with user specified product number
					if(retriveProductStored(num)!= null ) {
						p = retriveProductStored(num);
					}
					
					// add product number and details to order.items 

					o.setOrderNum( (orderNumber() + 1) );
					o.setTotalPrice( o.add2TotalPrice( p.getUnitPrice()) );
					
					// add the product to the items array of an order
					try {
						
						o.initializeAnItem(currOrderProductNum);
						o.addItem(currOrderProductNum, p);
						currOrderProductNum++; // increment in preparation for the next item to add
//						o.printItems();
					
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Could not add product to order item array!");
					}
					
					
				}else {
					
					// if num == 0
					// complete order transaction!
					
					if( o.isItemsNull() ) {
						System.out.println("Your current order for this transaction is empty!");
						break;
					}
					System.out.println("Order Info - Order Number: " + o.getOrderNum());
										
					// add this order to orders array
					try {
						orders[oNum -1] = o;
						
						// print out current order details
						for(int j = 0; j < orders[oNum -1].itemsLength(); j++) {
							
							if(orders[oNum -1].getAnItem(j) != null) {
								System.out.println("\tItem " + (j+1) + ": " + orders[oNum -1].getAnItem(j).getName() + "(No. " 
							+ orders[oNum -1].getAnItem(j).getProductNum() + "): $" + orders[oNum -1].getAnItem(j).getUnitPrice());
							}
							
						}
						System.out.println("\tTotal Price: $" + orders[oNum -1].getTotalPrice());
						oNum--;
					} catch (ArrayIndexOutOfBoundsException e) {
//						System.out.println("Unable to add product to products array!");
						System.out.println("Reached maximum number of orders to conduct transaction !");
					}
					
					break;
				}

				
			} catch(InputMismatchException e){
                System.out.println("Your input should only have numbers");
                s.nextLine();
            } catch (IllegalArgumentException e) {
            	System.out.println(e.getMessage());
            	s.nextLine();
            }		
		}
		
	}
}
