package com.revature.services;

import com.revature.doa.ReimbursementDOAImpl;
import com.revature.doa.UserDOAImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class RembursmentService {
	UserService us = new UserService();
	ReimbursementDOAImpl reimDOA = new ReimbursementDOAImpl();
	
	public String genRembId(int userId, int rawid) {
		User user = us.userX(userId);
		String rembId = String.valueOf(userId);
		if(userId%10 == 1) {
			if(userId == 51) {
				rembId += "5399";
			}else {
				rembId += String.valueOf(user.getSupId()) +String.valueOf(userId/10)+"3";
			}
		}else if(userId%10 == 2) {
			rembId += String.valueOf(user.getSupId())+"99";
		}else {
			rembId +="9999";
		}
		
		return rembId+String.valueOf(rawid);
	}
	
	public int calcBICid(int status,String rembId) {
		int userId = Integer.valueOf(rembId.substring(0,2));
		int supId = Integer.valueOf(rembId.substring(2,4));
		int dhId = Integer.valueOf(rembId.substring(4,6));
		int bcId;
		double r = Math.random();
		if(userId==97|| userId==98) {
			bcId=99;
		}else if(r<0.5) {
			bcId=97;
		}else {
			bcId=98;
		}
		if(status/10 == 1) {
			return userId;
		}else if(status/10==2) {
			if(supId == 99) {
				System.out.println("RedAlert");
				//log Red alert
				return supId;
			}
			return supId;
		}else if(status/10==3) {
			if(dhId==99) {
				System.out.println("redAlert");
				return bcId;
			}
			return dhId;
		}
		
		return bcId;
	}
	
	public void persistReimbursement(Reimbursement reimb) {
		reimDOA.createReimbursement(reimb);
	}
	
	public RembursmentService() {
		// TODO Auto-generated constructor stub
	}

}
