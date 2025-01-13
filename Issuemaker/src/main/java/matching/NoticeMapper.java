package matching;

import org.apache.ibatis.annotations.Insert;


public interface NoticeMapper {
	@Insert("INSERT INTO notice (comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major) " +
            "VALUES (#{comId}, #{title}, #{context}, #{postDate}, #{deadLine}, #{salary}, #{jobType}, #{exTerm}, #{workday}, #{type}, #{schoolLevel}, #{major})")
 
	int insert(Notice notice);
}
