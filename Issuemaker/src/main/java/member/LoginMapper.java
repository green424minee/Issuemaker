package member;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
	@Select("SELECT id FROM guest")
	List<String> selectId();
	
	@Select("SELECT pw FROM guest")
	List<String> selectPw();
	
	@Select("SELECT type FROM guest WHERE id = #{ id }")
	int selectType(@Param("id") String id);
}
