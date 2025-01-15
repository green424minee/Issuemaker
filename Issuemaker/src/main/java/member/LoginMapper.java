package member;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
	@Select("SELECT * FROM guest WHERE id = #{id}")
	Guest selectGuest(String id);
	
	@Select("SELECT pw FROM guest")
	List<String> selectPw();
	
	@Select("SELECT type FROM guest WHERE id = #{ id }")
	int selectType(@Param("id") String id);
}
