package myPage;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import member.User;

public interface ResumeMapper {
   @Select("SELECT * FROM resume WHERE no = #{ no }")
   Resume selectResume(@Param("no") int no);
   
   @Select("SELECT userName FROM user WHERE userId = #{userId}")
   String selectUserName(@Param("userId") String userId);
   
   @Select("SELECT * FROM workhistory WHERE userId = #{userId}")
   List<WorkHistory> selectWork(@Param("userId") String userId);
   
   @Select("SELECT * FROM school WHERE userId = #{userId}")
   School selectSchool(@Param("userId") String userId);
   
   @Select("SELECT * FROM license WHERE userId = #{userId}")
   List<License> selectLicense(@Param("userId") String userId);

   @Delete("DELETE FROM resume WHERE no = #{no}")
   int deleteResume(@Param("no") int no);
   
   @Select("SELECT * FROM user WHERE userId = #{userId}")
   User selectUser(String userId);
   
   @Insert("INSERT INTO resume (userId, userPhoto, title, jobType, coverLetter, portfolio, agree) " +
            "VALUES (#{userId}, #{userPhoto}, #{title}, #{jobType}, #{coverLetter}, #{portfolio}, #{agree})")
    int insert(ResumeForInsert resume);

}
