package txn.frauddetection.data;

public class ShoppingProfile {
	
	double minTransAmount;
	double maxTransAmount;
	int numTransPerHr;
	int shoppingRadius;
	
	public ShoppingProfile(){}
	
	public ShoppingProfile(double minTransAmt,double maxTransAmt,int transPerHr,int radius){
		this.minTransAmount = minTransAmt;
		this.maxTransAmount = maxTransAmt;
		this.numTransPerHr = transPerHr;
		this.shoppingRadius = radius;
	}
	
	public double getMinTransAmount() {
		return minTransAmount;
	}
	public void setMinTransAmount(double minTransAmount) {
		this.minTransAmount = minTransAmount;
	}
	public double getMaxTransAmount() {
		return maxTransAmount;
	}
	public void setMaxTransAmount(double maxTransAmount) {
		this.maxTransAmount = maxTransAmount;
	}
	public int getNumTransPerHr() {
		return numTransPerHr;
	}
	public void setNumTransPerHr(int numTransPerHr) {
		this.numTransPerHr = numTransPerHr;
	}
	public int getShoppingRadius() {
		return shoppingRadius;
	}
	public void setShoppingRadius(int shoppingRadius) {
		this.shoppingRadius = shoppingRadius;
	}
}
