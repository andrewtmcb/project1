package com.revature.pojos;

import com.revature.services.RembursmentService;

public class Reimbursement {

	//formula UserId,SupId,
	private String rembId;
	
	//1x flagged by manager for resubmission //2x supervision approval pending
	//3x dh approval pending //4x bc approval pending
	//x1 preaproval phase //x2 graded //x3 Redacted
	private int status;
	private int userId;
	private String eventDateTime;
	private String createdDateTime;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String eventType;
	private String description;
	private String gradingformat;
	private double cost;
	private boolean isMissingWorkTime;
	private int ballInCourtId;
	
	public String getRembId() {
		return rembId;
	}
	
	public void setRembId(String rembId) {
		this.rembId = rembId;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getEventDateTime() {
		return eventDateTime;
	}
	
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(int eventTypeId) {
		this.eventType = RembursmentService.eventTypeConverter(eventTypeId);
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGradingformat() {
		return gradingformat;
	}
	
	public void setGradingformat(int gradingformatId) {
		this.gradingformat = RembursmentService.gradingFormatConverter(gradingformatId);
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public boolean isMissingWorkTime() {
		return isMissingWorkTime;
	}
	
	public void setMissingWorkTime(boolean isMissingWorkTime) {
		this.isMissingWorkTime = isMissingWorkTime;
	}
	
	public int getBallInCourtId() {
		return ballInCourtId;
	}
	
	public void setBallInCourtId(int ballInCourtId) {
		this.ballInCourtId = ballInCourtId;
	
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reimbursement [rembId=" + rembId + ", status=" + status + ", userId=" + userId + ", eventDateTime="
				+ eventDateTime + ", createdDateTime=" + createdDateTime + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", eventType=" + eventType + ", description=" + description
				+ ", gradingformat=" + gradingformat + ", cost=" + cost + ", isMissingWorkTime=" + isMissingWorkTime
				+ ", ballInCourtId=" + ballInCourtId + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ballInCourtId;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((createdDateTime == null) ? 0 : createdDateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventDateTime == null) ? 0 : eventDateTime.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((gradingformat == null) ? 0 : gradingformat.hashCode());
		result = prime * result + (isMissingWorkTime ? 1231 : 1237);
		result = prime * result + ((rembId == null) ? 0 : rembId.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + status;
		result = prime * result + userId;
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventDateTime == null) {
			if (other.eventDateTime != null)
				return false;
		} else if (!eventDateTime.equals(other.eventDateTime))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (gradingformat == null) {
			if (other.gradingformat != null)
				return false;
		} else if (!gradingformat.equals(other.gradingformat))
			return false;
		if (isMissingWorkTime != other.isMissingWorkTime)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (status != other.status)
			return false;
		if (userId != other.userId)
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	
	public Reimbursement(String rembId, int status, int userId, String eventDateTime, String createdDateTime,
			String address, String city, String state, String zip, String eventType, String description,
			String gradingformat, double cost, boolean isMissingWorkTime, int ballInCourtId) {
		super();
		this.rembId = rembId;
		this.status = status;
		this.userId = userId;
		this.eventDateTime = eventDateTime;
		this.createdDateTime = createdDateTime;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.eventType = eventType;
		this.description = description;
		this.gradingformat = gradingformat;
		this.cost = Math.round(cost*100)/100;
		this.isMissingWorkTime = isMissingWorkTime;
		this.ballInCourtId = ballInCourtId;
	}
	
	
	
	
}
