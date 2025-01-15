package myPage;

import org.apache.ibatis.annotations.Insert;

public interface SchoolMapper {
	
	@Insert("INSERT INTO school (userId, type, level, schoolName, schoolLevel, major, startDate, endDate)" +
			"VALUES ( #{userId}, #{type}, #{level}, #{schoolName}, #{schoolLevel}, #{major}, #{startDate}, #{endDate})")
	int insert(School school);

}
