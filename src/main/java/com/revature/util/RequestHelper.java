package com.revature.util;

import javax.servlet.http.HttpServlet;

import com.revature.servlets.BenefitsServlet;
import com.revature.servlets.HomeServlet;
import com.revature.servlets.LoginServlet;
import com.revature.servlets.LogoutServlet;
import com.revature.servlets.PageNotFoundServlet;
import com.revature.servlets.RedirectServlet;
import com.revature.servlets.UserServlet;
import com.revature.servlets.XUserServlet;

public class RequestHelper {
	
	private static HttpServlet benefitsServlet = new BenefitsServlet();
	private static HttpServlet xuserServlet  = new XUserServlet();
	private static HttpServlet homeServlet = new HomeServlet();
	private static HttpServlet userServlet = new UserServlet();
	private static HttpServlet loginServlet = new LoginServlet();
	private static HttpServlet redirectServlet = new RedirectServlet();
	private static HttpServlet pnfServlet = new PageNotFoundServlet();
	private static HttpServlet logoutServlet = new LogoutServlet();
	
	
	private static final String PREFIX = "/Project1/app/";
	
	
	public HttpServlet dispatchRequest(String path) {
		System.out.println(path);
		HttpServlet nextServlet = null;
		
		switch(path) {
		
		case PREFIX + "login":
			nextServlet = loginServlet;
			break;
			
		case PREFIX + "emphome":
			nextServlet = homeServlet;
			break;
			
		case PREFIX + "redirect-servlet":
			nextServlet = loginServlet;
			break;
			
		case PREFIX + "benefits":
			nextServlet = benefitsServlet;
			break;
			
		case PREFIX + "user":
			nextServlet = userServlet;
			break;
			
		case PREFIX + "logout":
			nextServlet = logoutServlet;
		break;
			
		default: 
			if (path.matches(PREFIX + "xuser/"+"[1-9][1-9]")||path.matches(PREFIX + "xuser/"+"[1-9]")) {
				nextServlet = xuserServlet;
				break;
            }
			if (path.matches(PREFIX + "benefits/"+"[1-9][1-9]")||path.matches(PREFIX + "benefits/"+"[1-9]*")) {
				nextServlet = benefitsServlet;
				break;
            }
			nextServlet = pnfServlet;
			break;
		}
		
		return nextServlet;
		
	}

}
