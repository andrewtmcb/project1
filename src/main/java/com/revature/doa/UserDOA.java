package com.revature.doa;
import java.util.List;
import com.revature.pojos.User;

public interface UserDOA {
	
	public List<User> getAllUsers();

	public User getUser(String email);
	
	public User getUser(int userId);
	
	public void updateUserPassword(String password);
	
	
	
}
