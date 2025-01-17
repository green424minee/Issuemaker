package myPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface myPageMapper {
	@Select("SELECT * FROM resume WHERE userId = #{userId}")
	List<Resume> selectResume(@Param("userId") String userId);
}
