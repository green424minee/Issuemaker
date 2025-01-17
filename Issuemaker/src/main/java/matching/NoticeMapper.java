package matching;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import member.Company;
import myPage.Resume;



public interface NoticeMapper {
	@Insert("INSERT INTO notice (comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major) " +
            "VALUES (#{comId}, #{title}, #{context}, #{postDate}, #{deadLine}, #{salary}, #{jobType}, #{exTerm}, #{workday}, #{type}, #{schoolLevel}, #{major})")
	int insert(NoticeForInsert notice);

	 @Update("UPDATE notice SET context = #{context}, deadLine = #{deadLine}" +
				"WHERE no = #{no}")
	 int update(Notice notice);

	 @Select("SELECT * FROM notice WHERE no = #{no}")
	 Notice getNoticeByNo(String no);
	 
	 @Select("SELECT type FROM guest WHERE id = #{id}")
	 int getType(String id);
	 
	 @Select("SELECT * FROM company WHERE comId = #{comId}")
	 Company selectCom(String comId);

	 @Select("SELECT * FROM notice WHERE comId = #{comId}")
	 Notice getNoticeById(String comId);
	 

}
