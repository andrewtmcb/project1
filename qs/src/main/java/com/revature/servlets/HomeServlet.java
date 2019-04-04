package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.User;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/qa/homepage.html");
		
		/*
		 * For Testing and Future functionality
		 * 
		 * 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("username " + email + " password " + password);
		String name = ((User)request.getSession().getAttribute("user")).getFirstname();
		String title = "Front controller website";//getServletContext().getInitParameter("websiteTitle");
		String roles = "some roles";//getServletConfig().getInitParameter("roles");
		*
		response.getWriter().append("<div>Welcome to your homepage " + name + " on " + title + " where you can access " + roles 
		*		+ "<a href=logout>logout</a></div>");
		*		
		*		
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
