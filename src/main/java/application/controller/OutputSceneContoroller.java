package application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*
		 * ページ表示
		 */
		sc.setAttribute("orderCount", orderList.countCook(false));
		sc.setAttribute("cookingNowList",new OutputSceneHtml().createCookingNowList(orderList));
		sc.setAttribute("finishedCookingList",new OutputSceneHtml().createFinishedCookingList(orderList));
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
