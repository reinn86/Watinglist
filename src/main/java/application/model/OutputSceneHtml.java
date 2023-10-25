package application.model;

public class OutputSceneHtml {
	public String createCookingNowList(OrderList orderList) {
		StringBuilder sb = new StringBuilder();
		int c = 0;
		for(int i = 0; i < orderList.size(); i++) {
			if(!orderList.get(i).isCooked()) {
				c++;
				if(c % 10 != 0) {
					sb.append("<tr  style=\"width: 33%;\">");
				} else {
					sb.append("<tr  style=\"width: 33%;\"float=\"right\">");
				}
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
