package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LicenseMapper {
	@Insert("INSERT INTO license (userId, type, license, acuisition, score)" +
			"VALUES ( #{userId}, #{type}, #{license}, #{acuisition}, #{score})")
	int insert(LicenseForInsert lisence);
	
	@Select("SELECT * FROM license WHERE no = #{ no }")
	License selectNo(@Param("no") int no);
}
