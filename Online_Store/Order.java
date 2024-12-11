import java.util.Arrays;

// Order class
// Can only have up to 10 product items maximum (per order)
public class Order {

	private int orderNum; // similar to element index
	private double totalPrice = 0.0;
	private Product items[]; // can only have up to 10 items;
	
	public Order() {
		
		this.orderNum = -1;
		this.totalPrice = 0.0;
		items = new Product[10];
		
		for(int i = 0; i < items.length; i++) {
			items[i] = null;
		}
	}
	
//	public Order(int num, double p) {
//		this.orderNum = num;
//		this.totalPrice = p;
//
//				
//	}
	
	// setter and getter for orderNum
	public void setOrderNum(int o)
	{
		this.orderNum = o;
	}
	public int getOrderNum() {
		return this.orderNum;
	}
	
	// setter and getter for totalPrice
	public void setTotalPrice(double p) {
		this.totalPrice = p;
	}
	public double getTotalPrice() {
		return this.totalPrice;
	}
	// add a price to the total;
	public double add2TotalPrice(double p) {
		this.totalPrice += p;
		return this.totalPrice;
	}
	
	// setter and getter for items array
	public void setItems(Product[] i) {
		if(i.length > 10) {
			throw new IllegalArgumentException("Number of items cannot exceed more than 10!");
		}
		else {
		this.items = Arrays.copyOf(i, i.length);
		}
	}
	public Product[] getItems() {
		return Arrays.copyOf(this.items, this.items.length);
	}
	//get one item from Items array
	public Product getAnItem(int index) {
		return items[index];
	}
	
	// initialize a product in the items array
	public void initializeAnItem(int index){
		items[index] = new Product();
	}
	// add a product item to Items array
	public void addItem(int index, Product p) throws ArrayIndexOutOfBoundsException {
		items[index] = p;
	}
	// returns items array's length
	public int itemsLength() {
		return items.length;
	}
	
	// check if all elements of items[] array is null (returns true)
	public boolean isItemsNull (){
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				return false;
			} 
		}
		return true;
	}
	public void printItems() {
		for(int i =0; i< itemsLength(); i++) {
			if( getAnItem(i) != null ) {
				System.out.print( getAnItem(i) + " ");
			} else {
				System.out.print("null" + " ");
			}
			
		}
	}
}
