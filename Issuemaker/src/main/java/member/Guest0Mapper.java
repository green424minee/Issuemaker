package member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface Guest0Mapper {
	
	@Insert("INSERT INTO guest (id, pw, type) "
			+ "VALUES (#{ id }, #{ pw }, 0 )")
	int insert(@Param("id") String id
			, @Param("pw") String pw);
	
	@Update("UPDATE guest SET pw = #{pw} WHERE id = #{id};")
	int updateInfo(String id, String pw);

	
}
