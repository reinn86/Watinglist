package application.model;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order>{
	private static OrderList orderList = new OrderList();
	private static int compCount = 0; 
	
	private OrderList() {}
	public int complate(int num) {
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).getOrderNumber() == num) {
				this.get(i).compleateCoocked();
				return 0;
			}
		}
		return -1;
	}
	
	public int cancel(int num) {
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).getOrderNumber() == num) {
				this.remove(i);
				return 0;
			}
		}
		return -1;
	}
	
	public int receiptComplete(int num) {
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).getOrderNumber() == num && this.get(i).isCooked()) {
				compCount = compCount +  this.get(i).getOrderCount();
				this.remove(i);
				return 0;
			}
		}
		return -1;
	}
	
	public int countCook(boolean isFinished) {
		int c = 0;
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).isCooked() == isFinished) {
				c++;
			}
		}
		return c;
	}

	public static OrderList getInstanse() {
		return orderList;
	}
	
	public static int getCompCount() {
		return compCount;
	}
}
