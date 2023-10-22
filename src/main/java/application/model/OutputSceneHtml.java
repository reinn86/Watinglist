package application.model;

public class OutputSceneHtml {
	public String createCookingNowList(OrderList orderList) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < orderList.size(); i++) {
			if(!orderList.get(i).isCooked()) {
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(orderList.get(i).getOrderNumber());
				sb.append("</td>");
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
