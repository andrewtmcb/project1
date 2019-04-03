package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.services.UserService;

public class XUserServlet extends HttpServlet {
	UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getPathInfo();
		System.out.println(id.substring(7));
		User user = userService.userX(Integer.valueOf(id.substring(7)));
		ObjectMapper om = new ObjectMapper();
		String userString = om.writeValueAsString(user);
		//resp.setContentType("application/json");
		System.out.println(userString);
		response.getWriter().write(userString);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//post stuff
	}

}
