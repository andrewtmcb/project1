package com.revature.pojos;

public class User {
	

	int userId;
	
	int empLevel;
	
	String password;
	
	String firstname;
	
	String lastname;
	
	String email;
	
	String fullMailingAdress;
	
	String imgurl;
	
	int supId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getEmpLevel() {
		return empLevel;
	}
	
	
	//x1 standard employee //x2 supervisor //x3 department head
	//1 sales //2 marketing //3 engineering //4 human resources //5 benefits coordinator 
	public void setEmpLevel(int empLevel) {
		this.empLevel = empLevel;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullMailingAdress() {
		return fullMailingAdress;
	}

	public void setFullMailingAdress(String fullMailingAdress) {
		this.fullMailingAdress = fullMailingAdress;
	}
	

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", empLevel=" + empLevel + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", fullMailingAdress=" + fullMailingAdress
				+ ", imgurl=" + imgurl + ", supId=" + supId + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empLevel;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((fullMailingAdress == null) ? 0 : fullMailingAdress.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + supId;
		result = prime * result + userId;
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empLevel != other.empLevel)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (fullMailingAdress == null) {
			if (other.fullMailingAdress != null)
				return false;
		} else if (!fullMailingAdress.equals(other.fullMailingAdress))
			return false;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (supId != other.supId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public User(int userId, int empLevel, String password, String firstname, String lastname, String email,
			String fullMailingAdress, String imgurl, int supId) {
		super();
		this.userId = userId;
		this.empLevel = empLevel;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.fullMailingAdress = fullMailingAdress;
		this.imgurl = imgurl;
		this.supId = supId;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	
}