package application.model;

import java.util.ArrayList;

public class OutputSceneHtml {
	public String createCookingNowList(ArrayList<Order> orderList) {
		StringBuilder sb = new StringBuilder();
		int c = 0;
		for(int i = 0; i < orderList.size(); i++) {
			if(!orderList.get(i).isCooked()) {
				c++;
				sb.append("<tr class=\"wating_number_tr\">");
				sb.append("<th class=\"wating_number_th\">");
				sb.append(orderList.get(i).getOrderNumber());
				sb.append("</th>");
				sb.append("</tr>");	
			}
		}
		return sb.toString();
	}
	
	public String createFinishedCookingList(OrderList orderList) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).isCooked()) {
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(orderList.get(i).getOrderNumber());
				sb.append("</td>");
				sb.append("</tr>");	
			}
		}
		return sb.toString();
	}
}
