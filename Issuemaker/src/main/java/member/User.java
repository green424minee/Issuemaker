package member;

import java.sql.Date;

public class User {
	
	private String userID;
	private String userName;
	private Date userBirth;
	private String userPhone;
	private String userEmail;
	private String userAddress;
	
	public User(String userID, String userName, Date userBirth, String userPhone, String userEmail,
			String userAddress) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userBirth=" + userBirth + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userAddress=" + userAddress + "]";
	}
	
	
	
}
