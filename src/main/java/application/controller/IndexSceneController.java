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
	private String inputServ = "./input";
	private String outputServ = "./output";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(homePage);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		Enumeration<String> parameterNames = request.getParameterNames();
		if(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			
			switch(paramName) {
				case "input" -> {
					response.sendRedirect(inputServ);
				}
				case "output" -> {
					response.sendRedirect(outputServ);
				}
			}
		}
		else {
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
