package myPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import matching.Notice;

public interface NoticeListMapper {
	@Select("SELECT no FROM resume WHERE userId = #{userId}")
	List<Integer> selectResumeNo(@Param("userId") String userId);
	
	@Select("SELECT noticeNo FROM apply WHERE resumeNo = #{resumeNo}")
	List<Integer> selectApply(@Param("resumeNo") int resumeNo);
	
	@Select("SELECT * FROM notice WHERE no = #{no}")
	Notice selectNotice(@Param("no") int no);
	
	@Select("SELECT view FROM apply WHERE noticeNo = #{noticeNo} AND resumeNo = #{resumeNo}")
	int selectView(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
	
	@Select("SELECT result FROM apply WHERE noticeNo = #{noticeNo} AND resumeNo = #{resumeNo}")
	int selectResult(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
}
