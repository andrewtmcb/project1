package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;



public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		User u = (User) req.getSession(false).getAttribute("user");
		ObjectMapper om = new ObjectMapper();
		String userString = om.writeValueAsString(u);
		//resp.setContentType("application/json");
		System.out.println(userString);
		resp.getWriter().write(userString);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		this.doGet(req,resp);
	}


	
	

}
