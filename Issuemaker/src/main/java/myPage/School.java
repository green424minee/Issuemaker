package myPage;

import java.time.LocalDate;

import member.User;

public class School {
	
	private User user;
	private int type;
	private String level;
	private String schoolName;
	private int schoolLevel;
	private String major;
	private LocalDate startDate;  
    private LocalDate endDate;
    
	public School(User user, int type, String level, String schoolName, int schoolLevel, String major,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.user = user;
		this.type = type;
		this.level = level;
		this.schoolName = schoolName;
		this.schoolLevel = schoolLevel;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
		
		
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getSchoolLevel() {
		return schoolLevel;
	}

	public void setSchoolLevel(int schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "School [user=" + user + ", type=" + type + ", level=" + level + ", schoolName=" + schoolName
				+ ", schoolLevel=" + schoolLevel + ", major=" + major + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	} 
    
	
    
}
