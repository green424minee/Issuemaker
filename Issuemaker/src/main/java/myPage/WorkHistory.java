package myPage;

import java.time.LocalDate;

import member.User;

public class WorkHistory {
	private int no;
	private User user;
	private String exCom;
	private LocalDate startDate;
	private LocalDate endDate;
	private String jobType;
	
	public WorkHistory(int no, String userId, String exCom, LocalDate startDate, LocalDate endDate, String jobType) {
		super();
		this.no = no;
		this.user = user;
		this.exCom = exCom;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobType = jobType;
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
	public String getExCom() {
		return exCom;
	}
	public void setExCom(String exCom) {
		this.exCom = exCom;
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Override
	public String toString() {
		return "WorkHistory [no=" + no + ", user=" + user + ", exCom=" + exCom + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", jobType=" + jobType + "]";
	}
}
