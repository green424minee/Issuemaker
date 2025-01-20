package matching;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApplyMapper {
	@Insert("INSERT INTO apply (noticeNo, resumeNo, view, result) VALUES (#{noticeNo}, #{resumeNo}, 0, 0)")
	int insertApply(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
	
	@Select("SELECT count(*) FROM apply WHERE noticeNo = #{noticeNo} AND resumeNo = #{resumeNo}")
	int isApplyExists(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
	
	@Select("SELECT count(*) FROM apply WHERE noticeNo = #{noticeNo} AND resumeNo IN (SELECT resumeNo FROM resume WHERE userId = #{userId})")
	int checkApply(@Param("noticeNo") int noticeNo, @Param("userId") String userId);
	
	@Delete("DELETE FROM apply WHERE noticeNo = #{noticeNo} AND resumeNo IN (SELECT resumeNo FROM resume WHERE userId = #{userId})")
	int deleteApply(@Param("noticeNo") int noticeNo, @Param("userId") String userId);
	
	// Apply.result = 1로 변경
	@Update("UPDATE apply SET result = 1 WHERE noticeNo = #{noticeNo} AND resumeNo = #{resumeNo}")
	int updateResult1(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
	
	// Apply.result = 2로 변경
	@Update("UPDATE apply SET result = 2 WHERE noticeNo = #{noticeNo} AND resumeNo = #{resumeNo}")
	int updateResult2(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
}
