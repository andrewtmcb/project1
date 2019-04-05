package com.revature.doa;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public interface ReimbursementDOA {
	
	public List<Reimbursement> getAllReimbursments();

	public Reimbursement getReimbursement(String rembId);
	
	public List<Reimbursement> getAllReimbursementForUser(int userId);
	
	public void updateReimbursement(Reimbursement reimb);
	
	public void createReimbursement(Reimbursement reimb);
}