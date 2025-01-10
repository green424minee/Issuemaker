package matching;

import java.sql.Date;

import member.Company;

public class Notice {
	
	 	private int no;              
	    private Company company;     
	    private String title;       
	    private String context;      
	    private Date postDate;      
	    private Date deadLine;       
	    private Integer salary;      
	    private String jobType;      
	    private Integer exTerm;      
	    private String workday;      
	    private int type;        
	    private int schoolLevel; 
	    private String major;        
	    private String level;        
	    private String license;
	    
	    
		public Notice(int no, Company company, String title, String context, Date postDate, Date deadLine,
				Integer salary, String jobType, Integer exTerm, String workday, int type, int schoolLevel, String major,
				String level, String license) {
			super();
			this.no = no;
			this.company = company;
			this.title = title;
			this.context = context;
			this.postDate = postDate;
			this.deadLine = deadLine;
			this.salary = salary;
			this.jobType = jobType;
			this.exTerm = exTerm;
			this.workday = workday;
			this.type = type;
			this.schoolLevel = schoolLevel;
			this.major = major;
			this.level = level;
			this.license = license;
		}


		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getContext() {
			return context;
		}


		public void setContext(String context) {
			this.context = context;
		}


		public Date getPostDate() {
			return postDate;
		}


		public void setPostDate(Date postDate) {
			this.postDate = postDate;
		}


		public Date getDeadLine() {
			return deadLine;
		}


		public void setDeadLine(Date deadLine) {
			this.deadLine = deadLine;
		}


		public Integer getSalary() {
			return salary;
		}


		public void setSalary(Integer salary) {
			this.salary = salary;
		}


		public String getJobType() {
			return jobType;
		}


		public void setJobType(String jobType) {
			this.jobType = jobType;
		}


		public Integer getExTerm() {
			return exTerm;
		}


		public void setExTerm(Integer exTerm) {
			this.exTerm = exTerm;
		}


		public String getWorkday() {
			return workday;
		}


		public void setWorkday(String workday) {
			this.workday = workday;
		}


		public int getType() {
			return type;
		}


		public void setType(int type) {
			this.type = type;
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


		public String getLevel() {
			return level;
		}


		public void setLevel(String level) {
			this.level = level;
		}


		public String getLicense() {
			return license;
		}


		public void setLicense(String license) {
			this.license = license;
		}


		@Override
		public String toString() {
			return "Notice [no=" + no + ", company=" + company + ", title=" + title + ", context=" + context
					+ ", postDate=" + postDate + ", deadLine=" + deadLine + ", salary=" + salary + ", jobType="
					+ jobType + ", exTerm=" + exTerm + ", workday=" + workday + ", type=" + type + ", schoolLevel="
					+ schoolLevel + ", major=" + major + ", level=" + level + ", license=" + license + "]";
		}      
	    
	    
		
}
