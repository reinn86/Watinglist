package application.model;

public class Order{
	private int orderNumber; //注文番号
	private int orderCount; //注文個数
	private boolean isCooked = false; //調理が完了しているか
	
	public Order(int orderNumber,int orderCount) {
		this.orderNumber = orderNumber;
		this.orderCount = orderCount;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int cNumber) {
		this.orderNumber = cNumber;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	public void compleateCoocked() {
		isCooked = true;
	}

	public boolean isCooked() {
		return isCooked;
	}
}
