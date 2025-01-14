package myPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface myPageMapper {
	@Select("SELECT * FROM resume where userId = #{user}")
	List<Resume> selectResume(@Param("user") String user);
}
