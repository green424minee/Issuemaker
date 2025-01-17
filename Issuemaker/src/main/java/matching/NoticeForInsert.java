package matching;

import java.time.LocalDate;
import java.util.List;

public class NoticeForInsert {
		   private String comId;     
		   private String title;       
		   private String context;      
		   private LocalDate postDate;      
		   private LocalDate deadLine;       
		   private Integer salary;      
		   private String jobType;      
		   private Integer exTerm;      
		   private String workday;      
		   private int type;        
		   private int schoolLevel; 
		   private String major;   
		   private String comLicense;
		   
		   
		   
		   
		   public NoticeForInsert(String comId, String title, String context, LocalDate postDate, LocalDate deadLine,
					Integer salary, String jobType, Integer exTerm, String workday, int type, int schoolLevel, String major,
					String comLicense) {
				super();
				this.comId = comId;
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
				this.comLicense = comLicense;
			}
			public String getComId() {
				return comId;
			}
			public void setComId(String comId) {
				this.comId = comId;
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
			public LocalDate getPostDate() {
				return postDate;
			}
			public void setPostDate(LocalDate postDate) {
				this.postDate = postDate;
			}
			public LocalDate getDeadLine() {
				return deadLine;
			}
			public void setDeadLine(LocalDate deadLine) {
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
			public String getComLicense() {
				return comLicense;
			}
			public void setComLicense(String comLicense) {
				this.comLicense = comLicense;
			}
			@Override
			public String toString() {
				return "NoticeForInsert [comId=" + comId + ", title=" + title + ", context=" + context + ", postDate="
						+ postDate + ", deadLine=" + deadLine + ", salary=" + salary + ", jobType=" + jobType + ", exTerm="
						+ exTerm + ", workday=" + workday + ", type=" + type + ", schoolLevel=" + schoolLevel + ", major="
						+ major + ", comLicense=" + comLicense + "]";
			}
			

		          
		   
 
			

}
