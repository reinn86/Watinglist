package application.model;

import java.util.ArrayList;

public class OutputSceneHtml {
	public String createCookingNowList(ArrayList<Order> orderList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < orderList.size(); i++) {
			if(!orderList.get(i).isCooked()) {
				sb.append("<tr class=\"wating_number_tr\">");
				sb.append("<th class=\"wating_number_th\">");
				sb.append(orderList.get(i).getOrderNumber());
				sb.append("</th>");
				sb.append("</tr>");	
				
			}
		}
		return sb.toString();
	}
	
	public String createFinishedCookingList(ArrayList<Order> cookingCompList) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cookingCompList.size(); i++) {
			if(cookingCompList.get(i).isCooked()) {
				sb.append("<tr class=\"cooked_number_tr\">");
				sb.append("<th class=\"cooked_number_th\">");
				sb.append(cookingCompList.get(i).getOrderNumber());
				sb.append("</th>");
				sb.append("</tr>");	
			}
		}
		return sb.toString();
	}
}
