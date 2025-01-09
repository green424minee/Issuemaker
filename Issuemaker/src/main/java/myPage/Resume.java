package myPage;

import java.security.Timestamp;
import java.util.Arrays;

import member.User;

public class Resume {
	
    private int no;              
    private User user;           
    private byte[] userPhoto;     
    private String title;         
    private String jobType;       
    private byte[] coverLetter;   
    private byte[] portfolio;     
    private Integer salary;       
    private Timestamp postDate;
    
	public Resume(int no, User user, byte[] userPhoto, String title, String jobType, byte[] coverLetter,
			byte[] portfolio, Integer salary, Timestamp postDate) {
		super();
		this.no = no;
		this.user = user;
		this.userPhoto = userPhoto;
		this.title = title;
		this.jobType = jobType;
		this.coverLetter = coverLetter;
		this.portfolio = portfolio;
		this.salary = salary;
		this.postDate = postDate;
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

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public byte[] getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(byte[] coverLetter) {
		this.coverLetter = coverLetter;
	}

	public byte[] getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(byte[] portfolio) {
		this.portfolio = portfolio;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Resume [no=" + no + ", user=" + user + ", userPhoto=" + Arrays.toString(userPhoto) + ", title=" + title
				+ ", jobType=" + jobType + ", coverLetter=" + Arrays.toString(coverLetter) + ", portfolio="
				+ Arrays.toString(portfolio) + ", salary=" + salary + ", postDate=" + postDate + "]";
	} 
    
}
