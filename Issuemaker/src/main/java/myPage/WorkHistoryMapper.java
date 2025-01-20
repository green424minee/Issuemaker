package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WorkHistoryMapper {
	@Insert("INSERT INTO workHistory (userId, exCom, startDate, endDate, jobType)" +
			"VALUES ( #{userId}, #{exCom}, #{startDate}, #{endDate}, #{jobType})")
	int insert(WorkHistoryForInsert workHistory);
	
	@Select("SELECT * FROM workHistory WHERE userId = #{ userId }")
	WorkHistory selectByUserId(@Param("userId") String userId);
	
	@Update("UPDATE workHistory SET exCom = #{exCom}, startDate = #{startDate}, endDate = #{endDate}, jobType = #{jobType} WHERE userId = #{userId}")
		int update(WorkHistoryForInsert workHistory);
}
