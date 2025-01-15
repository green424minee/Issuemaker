package myPage;

import org.apache.ibatis.annotations.Insert;

public interface LicenseMapper {
	@Insert("INSERT INTO license (userId, type, license, acuisition, score)" +
			"VALUES ( #{userId}, #{type}, #{license}, #{acuisition}, #{score})")
	int insert(LicenseForInsert lisence);
}
