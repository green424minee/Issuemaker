package myPage;

import java.time.LocalDate;

public class LicenseForInsert {
   private String userId;
   private int type;
   private String license;
   private LocalDate acuisition;
   private Integer score;
   
   public LicenseForInsert(String userId, int type, String license, LocalDate acuisition, Integer score) {
      super();
      this.userId = userId;
      this.type = type;
      this.license = license;
      this.acuisition = acuisition;
      this.score = score;
   }

   public String getUserId() {
      return userId;
   }

   public void setUser(String userId) {
      this.userId = userId;
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
      if (this.type == 0) return license;
      else return license + " " + score + "점";
   }
}
