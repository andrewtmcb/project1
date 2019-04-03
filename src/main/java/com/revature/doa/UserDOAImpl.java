package com.revature.doa;

import com.revature.pojos.User;
import com.revature.services.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDOAImpl implements UserDOA {

	
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		User user = null;
		String address = "";
		
		try(Connection conn = ConnectionFactory.getConnection())
		{
			
			String sql = "select * from proj1.employee_table";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next())
			{
				user = null;
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setPassword(rs.getString("password"));
				user.setEmpLevel(rs.getInt("emplevel"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				address = rs.getString("address")+";"+rs.getString("city")+","+rs.getString("state")+";"+String.valueOf(rs.getInt("zip"));
				user.setFullMailingAdress(address);
				user.setEmail(rs.getString("email"));
				user.setImgurl(rs.getString("imgurl"));
				user.setSupId(rs.getInt("supid"));
				allUsers.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allUsers;
	}


	@Override
	public User getUser(String email) {
		User user = null;
		String address = "";
		
		try(Connection conn = ConnectionFactory.getConnection())
		{
			
			String sql = "select * from proj1.employee_table where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs =  ps.executeQuery();
		
			if(rs.next())
			{
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setPassword(rs.getString("password"));
				user.setEmpLevel(rs.getInt("emplevel"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				address += rs.getString("address")+";"+rs.getString("")+","+rs.getString("state")+";"+String.valueOf(rs.getInt("zip"));
				user.setFullMailingAdress(address);
				user.setEmail(rs.getString("email"));
				user.setImgurl(rs.getString("imgurl"));
				user.setSupId(rs.getInt("supid"));
			}
			else
			{
				//System.out.println("null");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUser(int userId) {
		User user = null;
		String address = "";
		
		try(Connection conn = ConnectionFactory.getConnection())
		{
			
			String sql = "select * from proj1.employee_table where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(userId));
			ResultSet rs =  ps.executeQuery();
		
			if(rs.next())
			{
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setPassword(rs.getString("password"));
				user.setEmpLevel(rs.getInt("emplevel"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				address += rs.getString("address")+";"+rs.getString("")+","+rs.getString("state")+";"+String.valueOf(rs.getInt("zip"));
				user.setFullMailingAdress(address);
				user.setEmail(rs.getString("email"));
				user.setImgurl(rs.getString("imgurl"));
				user.setSupId(rs.getInt("supid"));
			}
			else
			{
				//System.out.println("null");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void updateUserPassword(String password) {
		// TODO Auto-generated method stub

	}
	
	public UserDOAImpl() {
		// TODO Auto-generated constructor stub
	}


}
