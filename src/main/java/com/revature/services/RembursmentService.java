package com.revature.services;

import com.revature.pojos.User;

public class RembursmentService {
	
	
	
	public String genRembId(User user) {
		String rembId = String.valueOf(user.getUserId());
		if(user.getUserId()%10 == 1) {
			if(user.getUserId()== 51) {
				rembId += "5399";
			}else {
				rembId += user.getSupId() +String.valueOf(user.getUserId()/10)+"3";
			}
		}else if(user.getUserId()%10 == 2) {
			rembId += user.getSupId()+"99";
		}else {
			rembId +="9999";
		}
		
		return rembId;
	}
	
	
	public RembursmentService() {
		// TODO Auto-generated constructor stub
	}

}
