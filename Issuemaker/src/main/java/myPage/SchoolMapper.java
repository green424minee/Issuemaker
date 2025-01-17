package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SchoolMapper {
	
	@Insert("INSERT INTO school (userId, type, level, schoolName, schoolLevel, major, startDate, endDate)" +
			"VALUES ( #{userId}, #{type}, #{level}, #{schoolName}, #{schoolLevel}, #{major}, #{startDate}, #{endDate})")
	int insert(School school);
	
	 @Select("SELECT * FROM school WHERE userId = #{userId}")
	   School selectByUserId(@Param("userId") String userId);
	 
	 @Update("UPDATE school SET type = #{type}, level = #{level}, schoolName = #{schoolName}, schoolLevel = #{schoolLevel}, " +
	            "major = #{major}, startDate = #{startDate}, endDate = #{endDate} WHERE userId = #{userId}")
	    int update(School school);
	 

}
