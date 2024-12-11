// Product class
public class Product {
	
	private int productNum;
	private String name;
	private double unitPrice;
	
	public Product() {
		this.productNum = -1;
		this.name = "";
		this.unitPrice = 0.0;
	}
	
	public Product(int num, String n, double p) {
		this.productNum = num;
		this.name = n;
		this.unitPrice = p;
	}
	
	// setter and getter for productNum
	public void setProductNum(int n) {
		this.productNum = n;
	}
	public int getProductNum() {
		return this.productNum;
	}
	
	// setter and getter for name
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	
	// setter and getter for unitPrice
	public void setUnitPrice(double p) {
		this.unitPrice = p;
	}
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	// override toString
	@Override
	public String toString() {
		return this.getProductNum() + " " + this.getName() + " " + this.getUnitPrice();
	}
	
}
