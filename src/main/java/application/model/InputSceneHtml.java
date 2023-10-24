package application.model;

public class InputSceneHtml {
	public String createTable(OrderList orderList) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < orderList.size(); i++) {
			if(i%2 ==0) {
				sb.append("<tr style=\"background-color:gray;\">");	
			} else {
				sb.append("<tr>");
			}
			sb.append("<td>");
			sb.append(orderList.get(i).getOrderNumber());
			sb.append("</td><td>");
			sb.append(orderList.get(i).getOrderCount());
			sb.append("</td><td>");
			if(orderList.get(i).isCooked()) {
				sb.append("完了");
			}
			else {
				sb.append("　　");
			}
			sb.append("</td>");
			sb.append("</tr>");
		}
		return sb.toString();
	}
}
