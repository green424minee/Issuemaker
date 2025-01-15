package myPage;

import org.apache.ibatis.annotations.Insert;

public interface WorkHistoryMapper {
	@Insert("INSERT INTO workHistory (userId, exCom, startDate, endDate, jobType)" +
			"VALUES ( #{userId}, #{exCom}, #{startDate}, #{endDate}, #{jobType})")
	int insert(WorkHistoryForInsert workHistory);
}
