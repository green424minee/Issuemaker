package myPage;

import java.time.LocalDate;

import member.User;

public class School {
<<<<<<< HEAD
   
   private String userId;
   private int type;
   private String level;
   private String schoolName;
   private int schoolLevel;
   private String major;
   private LocalDate startDate;  
=======
	
	private String userId;
	private int type;
	private String level;
	private String schoolName;
	private int schoolLevel;
	private String major;
	private LocalDate startDate;  
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git
    private LocalDate endDate;
    private String levelstr;  // 대학구분(석사, 박사, 2, 3년제, 4년제)
    
<<<<<<< HEAD
   public School(String userId, int type, String level, String schoolName, int schoolLevel, String major,
         LocalDate startDate, LocalDate endDate) {
      super();
      this.userId = userId;
      this.type = type;
      this.level = level;
      this.schoolName = schoolName;
      this.schoolLevel = schoolLevel;
      this.major = major;
      this.startDate = startDate;
      this.endDate = endDate;
      levelstr = levelStr(schoolLevel);
   }
=======
	public School(String userId, int type, String level, String schoolName, int schoolLevel, String major,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.userId = userId;
		this.type = type;
		this.level = level;
		this.schoolName = schoolName;
		this.schoolLevel = schoolLevel;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
		levelstr = levelStr(schoolLevel);
	}
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git

<<<<<<< HEAD
=======

	public String getLevelstr() {
		return levelstr;
	}
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git

<<<<<<< HEAD
   public String getLevelstr() {
      return levelstr;
   }
=======

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git


   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
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

<<<<<<< HEAD
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
      return levelstr + " " + schoolName + " " + major + " " + level;
   } 
=======
	@Override
	public String toString() {
		return levelstr + " " + schoolName + " " + major + " " + level;
	} 
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git
    
<<<<<<< HEAD
   // 대학구분(schoolLevel)
   public String levelStr(int schoolLevel) {
      String result = "";
      if (schoolLevel == 0) result = "석사";
      else if (schoolLevel == 1) result = "박사";
      else if (schoolLevel == 2) result = "2, 3년제";
      else result =  "4년제";
      
      return result;
   }
=======
	// 대학구분(schoolLevel)
	public String levelStr(int schoolLevel) {
		String result = "";
		if (schoolLevel == 0) result = "석사";
		else if (schoolLevel == 1) result = "박사";
		else if (schoolLevel == 2) result = "2, 3년제";
		else result =  "4년제";
		
		return result;
	}
>>>>>>> branch 'master' of https://github.com/000vin000/Issuemaker.git
}
