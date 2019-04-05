package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.RembursmentService;

public class XBenefitsServlet extends HttpServlet {
	List <Reimbursement> allReimbforUserX = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getPathInfo();
		System.out.println(id.substring(11));
		allReimbforUserX = RembursmentService.getallReimbforUserX(Integer.valueOf(id.substring(11)));
		ObjectMapper om = new ObjectMapper();
		String reimbArray = om.writeValueAsString(allReimbforUserX);
		//resp.setContentType("application/json");
		System.out.println(reimbArray);
		response.getWriter().write(reimbArray);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
