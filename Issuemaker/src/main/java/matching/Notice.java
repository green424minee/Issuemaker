package matching;

import java.time.LocalDate;
import java.util.List;

import member.Company;
import search.AreaService;
import search.JobService;

public class Notice {

	private int no;
	private String comId;     
	private String title;       
	private String context;      
	private LocalDate postDate;      
	private LocalDate deadLine;       
	private Integer salary;      
	private String jobType;      
	private Integer exTerm;      
	private String workday;      
	private Integer type;        
	private Integer schoolLevel; 
	private String major;
	private String comLicense;
	
	
	
	
	public Notice(int no, String comId, String title, String context, LocalDate postDate, LocalDate deadLine,
				Integer salary, String jobType, Integer exTerm, String workday, Integer type, Integer schoolLevel, String major,
				String comLicense) {
			super();
			this.no = no;
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
	
	
	public String getExTermStr() {
		return strExTerm(exTerm);
	}
	public String getSalaryStr() {
		return strSalary(salary);
	}
	public String getSchoolLevelStr() {
		return strSchoolLevel(type, schoolLevel);
	}
	
	public String getComName() {
		NoticeService ser = NoticeService.getInstance();
		return ser.selectComName(comId);
	}

	public String getArea() {
		NoticeService ser = NoticeService.getInstance();
		String area =  ser.selectComAddress(comId);
		int index = area.indexOf(' ');
		return area.substring(0, index);
	}
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getSchoolLevel() {
		return schoolLevel;
	}


	public void setSchoolLevel(Integer schoolLevel) {
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
		return "Notice [no=" + no + ", comId=" + comId + ", title=" + title + ", context=" + context + ", postDate="
				+ postDate + ", deadLine=" + deadLine + ", salary=" + salary + ", jobType=" + jobType + ", exTerm=" + exTerm
				+ ", workday=" + workday + ", type=" + type + ", schoolLevel=" + schoolLevel + ", major=" + major
				+ ", comLicense=" + comLicense + "]";
	}
	
	
	
	public String strExTerm(Integer exTerm) {
	   String info = "신입";
	   if (exTerm != null) {
		   if (exTerm == 0)  info = "무관"; 
		   else info = exTerm + "년 이상";
	   }
	   
	   return info;
   }

   public String strSalary(Integer salary) {
	   String info = "협의 후 결정";
	   if (salary != null) {
		   int result = salary / 10000; 
		   info =  "연봉 " + result + "만원";
	   }
	   return info;
   }
   
   
   
   public String strSchoolLevel(Integer type, Integer schoolLevel) {
	   if (type == 2) {
		   if (schoolLevel == 0) return "석사";
		   else if (schoolLevel == 1) return "박사";
		   else if (schoolLevel == 2) return "2, 3년제 대학 이상(예정자가능)";
		   else return "4년제 대학 이상(예정자가능)";
	   } else if (type == 1){
		   return "고졸 이상";
	   } else {
		   return "무관";
	   }
   }
   
   public String getComName(String comId) {
	   NoticeService ser = NoticeService.getInstance();
	   return ser.selectComName(comId);
   }
   
   public String getArea(String comId) {
	   NoticeService ser = NoticeService.getInstance();
	   String area = ser.selectComAddress(comId);
	   int index = area.indexOf(' '); 
       return area.substring(0, index);
   }
}
