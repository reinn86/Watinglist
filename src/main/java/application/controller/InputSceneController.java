package application.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputSceneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String inputPage = "/WEB-INF/view/input/input.jsp";
	private String homeServ = "./home";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(inputPage);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		Enumeration<String> parameterNames = request.getParameterNames();
		if(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			
			switch(paramName) {
				case "home" -> {
					response.sendRedirect(homeServ);
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
