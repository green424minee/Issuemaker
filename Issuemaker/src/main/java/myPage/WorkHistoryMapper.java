package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WorkHistoryMapper {
	@Insert("INSERT INTO workHistory (userId, exCom, startDate, endDate, jobType)" +
			"VALUES ( #{userId}, #{exCom}, #{startDate}, #{endDate}, #{jobType})")
	int insert(WorkHistoryForInsert workHistory);
	
	@Select("SELECT * FROM workHistory WHERE no = #{ no }")
	WorkHistory selectNo(@Param("no") int no);
}
