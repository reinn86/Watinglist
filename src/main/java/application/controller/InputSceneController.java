package application.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.InputSceneHtml;
import application.model.Order;
import application.model.OrderList;
import application.service.InputMonitor;

@WebServlet("/input")
public class InputSceneController extends HttpServlet {
	/*
	 * サーブレット関連
	 */
	private static final long serialVersionUID = 1L;
	private String inputPage = "/WEB-INF/view/input/input.jsp"; //入力ページ
	private String homeServ = "./home"; //画面選択コントローラのアドレス
	
	/*
	 * 注文関連
	 */
	private OrderList orderList = OrderList.getInstanse(); //注文詳細を格納するリスト
	private int orderNum = 1; //注文番号
	
	/*
	 * 入力関連
	 */
	private String orderListHtml = "";
	private InputMonitor im = new InputMonitor(); //入力の条件
	//TODO アプリが落ちたとき用にログ機能の追加
	//TODO エラーページの追加
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		/*
		 * リクエスト判定
		 */
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			
			switch(paramName) {
				case "append" -> {
					System.out.println("append:" + request.getParameter("append"));
					
					String inputStr = request.getParameter("append");
					/*
					 * 入力された文字列が1文字以上かつ数字の時にリストに追加する
					 */
					if(!im.isEmpty(inputStr) && im.isInteger(inputStr)) {
						int orderCount = Integer.parseInt(inputStr); //注文個数
						orderList.add(new Order(orderNum,orderCount)); 
						orderNum++;
					} else {
						//TODO 赤文字で値が不正の旨を伝える
					}
				}
				case "complate" -> {
					System.out.println("complate:" + request.getParameter("complate"));
					
					String inputStr = request.getParameter("complate");
					
					if(!im.isEmpty(inputStr) && im.isInteger(inputStr)) {
						int compOrderNum = Integer.parseInt(inputStr); //調理完了注文番号
						
						orderList.complate(compOrderNum);
					} else {
						//TODO 赤文字で値が不正の旨を伝える
					}
				}
				case "receiptComplete" -> {
					System.out.println("receiptComplete:" + request.getParameter("receiptComplete"));
					
					String inputStr = request.getParameter("receiptComplete");
					if(!im.isEmpty(inputStr) && im.isInteger(inputStr)) {
						int cancelOrderNum = Integer.parseInt(inputStr); //キャンセル注文番号
						
						orderList.receiptComplete(cancelOrderNum);
					} else {
						//TODO 赤文字で値が不正の旨を伝える
						//TODO 存在しない注文番号が入力されたときにその旨を伝える
					}
				}
				case "cancel" -> {
					System.out.println("cancel:" + request.getParameter("cancel"));
					
					String inputStr = request.getParameter("cancel");
					if(!im.isEmpty(inputStr) && im.isInteger(inputStr)) {
						int cancelOrderNum = Integer.parseInt(inputStr); //キャンセル注文番号
						
						orderList.cancel(cancelOrderNum);
					} else {
						//TODO 赤文字で値が不正の旨を伝える
						//TODO 存在しない注文番号が入力されたときにその旨を伝える
					}
				}
				case "home" -> {
					response.sendRedirect(homeServ);
					return;
				}
			}
		}
		
		/*
		 * ページ表示
		 */
		orderListHtml = new InputSceneHtml().createTable(orderList);
		sc.setAttribute("orderListHtml", orderListHtml);
		sc.setAttribute("unitSales", String.valueOf(OrderList.getCompCount()));
		sc.setAttribute("priceSum", String.valueOf(OrderList.getCompCount() * 350));
		RequestDispatcher dispatch = request.getRequestDispatcher(inputPage);
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
