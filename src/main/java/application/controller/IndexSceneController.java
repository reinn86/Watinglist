package application.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class IndexSceneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String homePage = "/WEB-INF/view/index.jsp";
	private String inputPage = "/WEB-INF/view/input/input.html";
	private String outputPage = "/WEB-INF/view/output/output.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		RequestDispatcher dispatch = request.getRequestDispatcher(homePage);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		//リクエストごとの処理
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement().toString();
			System.out.println(paramName);
			switch(paramName) {
				case "input" -> {
					dispatch = request.getRequestDispatcher(inputPage);				
				}
				case "output" -> {
					dispatch = request.getRequestDispatcher(outputPage);			
				}
			}
		}
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
