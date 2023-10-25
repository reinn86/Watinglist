package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.Order;
import application.model.OrderList;
import application.model.OutputSceneHtml;

@WebServlet("/output")
public class OutputSceneContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String viewName = "/WEB-INF/view/output/output.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		OrderList orderList = OrderList.getInstanse();
		ArrayList<Order> cookingNowList = new ArrayList<Order>();
		ArrayList<Order> cookingCompList = new ArrayList<Order>();

		/*
		 * リストの作成
		 */
		for(int i = 0; i < orderList.size(); i++) {
			if(!orderList.get(i).isCooked()) {
				cookingNowList.add(orderList.get(i));
			}
		}
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).isCooked() && cookingCompList.size() <= 10) {
				cookingCompList.add(orderList.get(i));
			}
		}
		
		/*
		 * ページ表示
		 */
		//TODO 番号が一定の件数になったときに折り返す機能の追加
		sc.setAttribute("orderCount", orderList.countCook(false));
		
		if(orderList.size() <= 10) {
			sc.setAttribute("cookingNowList1",new OutputSceneHtml().createCookingNowList(orderList));
			sc.setAttribute("cookingNowList2","");
		}
		else {
			ArrayList<Order> orderList1 = new ArrayList<Order>();
			ArrayList<Order> orderList2 = new ArrayList<Order>();
			
			for(int i = 0; i < 10; i++) {
				orderList1.add(cookingNowList.get(i));
			}
			for(int i = 10; i < cookingNowList.size() && i < 20; i++) {
				orderList2.add(cookingNowList.get(i));
			}
			sc.setAttribute("cookingNowList1",new OutputSceneHtml().createCookingNowList(orderList1));
			sc.setAttribute("cookingNowList2",new OutputSceneHtml().createCookingNowList(orderList2));
		}
		sc.setAttribute("finishedCookingList",new OutputSceneHtml().createFinishedCookingList(orderList));
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
