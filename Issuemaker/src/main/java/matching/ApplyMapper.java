package matching;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
	@Insert("INSERT INTO apply (noticeNo, resumeNo, view, result) VALUES (#{noticeNo}, #{resumeNo}, 0, 0)")
	int insertApply(@Param("noticeNo") int noticeNo, @Param("resumeNo") int resumeNo);
}
