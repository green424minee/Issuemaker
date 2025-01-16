package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SchoolMapper {
	
	@Insert("INSERT INTO school (userId, type, level, schoolName, schoolLevel, major, startDate, endDate)" +
			"VALUES ( #{userId}, #{type}, #{level}, #{schoolName}, #{schoolLevel}, #{major}, #{startDate}, #{endDate})")
	int insert(School school);
	
	 @Select("SELECT * FROM school WHERE userId = #{userId}")
	   School selectByUserId(@Param("userId") String userId);
	 

}
