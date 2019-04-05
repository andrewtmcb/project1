package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.ConnectionFactory;
import com.revature.services.RembursmentService;
import com.revature.services.UserService;

public class ReimbursementDOAImpl implements ReimbursementDOA {

	@Override
	public List<Reimbursement> getAllReimbursments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursement(String rembId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursementForUser(int userId) {
			Reimbursement reimb = null;
			List<Reimbursement> allReimb = new ArrayList<>();
			String eventTypeString = "";
			String gradingFormatString = "";
			Double rawCost;
			
			
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "select * from proj1.rembursment_table where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next())
			{
				reimb = null;
				reimb = new Reimbursement();
				reimb.setStatus(rs.getInt("status"));
				reimb.setUserId(rs.getInt("userid"));
				reimb.setEventDateTime(rs.getString("eventdatetime"));
				reimb.setCreatedDateTime(rs.getString("createddatetime"));
				eventTypeString = rs.getString("eventtype");
				reimb.setAddress(rs.getString("address"));
				reimb.setCity(rs.getString("city"));
				reimb.setState(rs.getString("state"));
				reimb.setZip(rs.getString("zip"));
				reimb.setDescription(rs.getString("description"));
				gradingFormatString = rs.getString("gradingformat");
				rawCost = (double) rs.getFloat("cost");
				reimb.setMissingWorkTime(rs.getBoolean("missingworktime"));
				reimb.setRembId(RembursmentService.genRembId(rs.getInt("userid"),rs.getInt("remid")));
				reimb.setBallInCourtId(RembursmentService.calcBICid(reimb.getStatus(), reimb.getRembId()));
				
				reimb.setEventType(RembursmentService.gradingFormatConverter(eventTypeString));
				reimb.setGradingformat(RembursmentService.gradingFormatConverter(gradingFormatString));
				reimb.setCost(Math.round(RembursmentService.calculateRefund(eventTypeString, rawCost)*100)/100);
				allReimb.add(reimb);
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allReimb;
	}

	@Override
	public void updateReimbursement(Reimbursement reimb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createReimbursement(Reimbursement reimb) {
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			String insertStatement =
			    "insert into proj1.rembursment_table(status ,userid ,eventdatetime ,address ,city ,state ,zip ,description ,gradingformat , \"cost\" , missingworktime, createddatetime, eventtype) " +
			     "values (? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(insertStatement);
			ps.setInt(1, reimb.getStatus());
			ps.setInt(2, reimb.getUserId());
			ps.setString(3, reimb.getEventDateTime());
			ps.setString(4, reimb.getAddress());
			ps.setString(5, reimb.getCity());
			ps.setString(6, reimb.getState());
			ps.setString(7, reimb.getZip());
			ps.setString(8, reimb.getDescription());
			ps.setString(9, reimb.getGradingformat());
			ps.setFloat(10, (float) reimb.getCost());
			ps.setBoolean(11, reimb.isMissingWorkTime());
			ps.setString(12, reimb.getCreatedDateTime());
			ps.setString(13, reimb.getEventType());
			ps.executeUpdate();
			conn.commit();
			conn.close();
	
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
	

	}

}
