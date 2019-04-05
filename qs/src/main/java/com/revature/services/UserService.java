package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.doa.UserDOAImpl;
import com.revature.pojos.User;

public class UserService {
	
	UserDOAImpl userDOA = new UserDOAImpl();
	List<User> allUsers = userDOA.getAllUsers();
	User user = null;
	
	public User loginUser(String email, String password){
		
		System.out.println("email " + email);
		System.out.println("password " + password);
		
		
		
		for (User check : allUsers){
			if(check.getEmail().equals(email) && check.getPassword().equals(password)){
				user = check;
				break;
			}
		}
		return user;
		
	}
	
	public User userX(int userId){
		
		
		for (User check : allUsers){
			if(check.getUserId() == userId){
				user = check;
				break;
			}
		}
		return user;
		
	}
	

	public UserService() {
		super();
	}
	
	

}
