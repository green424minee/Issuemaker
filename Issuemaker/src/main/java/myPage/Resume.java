package myPage;

import java.time.LocalDate;
import java.util.Arrays;

public class Resume {
   
    private int no;              
    private String userId;           
    private byte[] userPhoto;     
    private String title;         
    private String jobType;       
    private byte[] coverLetter;   
    private byte[] portfolio;     
    private Integer salary;       
    private LocalDate postDate;
    private int agree;
    
    
    public Resume() { }
	public Resume(int no, String userId, byte[] userPhoto, String title, String jobType, byte[] coverLetter,
			byte[] portfolio, Integer salary, LocalDate postDate, int agree) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPhoto = userPhoto;
		this.title = title;
		this.jobType = jobType;
		this.coverLetter = coverLetter;
		this.portfolio = portfolio;
		this.salary = salary;
		this.postDate = postDate;
		this.agree = agree;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "Resume [no=" + no + ", userId=" + userId + ", userPhoto=" + Arrays.toString(userPhoto) + ", title="
				+ title + ", jobType=" + jobType + ", coverLetter=" + Arrays.toString(coverLetter) + ", portfolio="
				+ Arrays.toString(portfolio) + ", salary=" + salary + ", postDate=" + postDate + ", agree=" + agree
				+ "]\n";
	}
    

}
