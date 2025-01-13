package member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface Guest1Mapper {
	@Insert("INSERT INTO guest (id, pw, type) "
			+ "VALUES (#{ id }, #{ pw }, 1 )")
	int insert(@Param("id") String id, @Param("pw") String pw);

}
