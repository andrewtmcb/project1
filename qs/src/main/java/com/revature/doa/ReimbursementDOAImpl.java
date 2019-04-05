package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.services.ConnectionFactory;

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
		// TODO Auto-generated method stub
		return null;
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
