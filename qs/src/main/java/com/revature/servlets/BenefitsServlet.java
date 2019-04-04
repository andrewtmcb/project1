package com.revature.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.RembursmentService;

public class BenefitsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RembursmentService reimbServ = new RembursmentService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getPathInfo();
		System.out.println(name.substring(1));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	   
		
		
		HttpSession sess = request.getSession(false);
		User user = (User) sess.getAttribute("user");
		int userId = Integer.valueOf(request.getParameter("userId"));
		if (userId != user.getUserId()) {
			response.getWriter().write("<h1>HTTP 500</h1><br><h3>YOU CAN NOT FILL OUT A REIMBURSEMENT REQUEST FOR OTHER USERS</h3>");
		}
		//writing out parameters from post
		String eventType = request.getParameter("eventType");
		String gradingformat = request.getParameter("gradingformat");
		String eventdisc = request.getParameter("eventdisc");
		String eventdatetime = request.getParameter("eventdatetime");
		String eventaddress = request.getParameter("eventaddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Double cost = Double.valueOf(request.getParameter("cost"));
		String workjst = request.getParameter("workjst");
		Boolean ismissingwork = Boolean.valueOf(request.getParameter("ismissingwork"));
		Reimbursement reimb = new Reimbursement("", 1, userId, request.getParameter("eventdatetime"),strDate ,
		eventaddress, city, state, zip, eventType, eventdisc,
		gradingformat, cost, ismissingwork, 2);
		System.out.println(reimb.toString());
		//reimbServ.persistReimbursement(reimb);
		response.getWriter().write("<h1>Eureka, your request has been submitted</h1><br><a href=\"https://localhost:8080/qa/app/emphome\">Home Page</a>");
	}
	
	
	
	

}