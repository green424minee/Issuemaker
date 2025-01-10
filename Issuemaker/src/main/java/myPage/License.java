package myPage;

import java.time.LocalDate;

import member.User;

public class License {
	private int no;
	private User user;
	private int type;
	private String license;
	private LocalDate acuisition;
	private Integer score;
	
	public License(int no, User user, int type, String license, LocalDate acuisition, Integer score) {
		super();
		this.no = no;
		this.user = user;
		this.type = type;
		this.license = license;
		this.acuisition = acuisition;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public LocalDate getAcuisition() {
		return acuisition;
	}

	public void setAcuisition(LocalDate acuisition) {
		this.acuisition = acuisition;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "License [no=" + no + ", user=" + user + ", type=" + type + ", license=" + license + ", acuisition="
				+ acuisition + ", score=" + score + "]";
	}
}
