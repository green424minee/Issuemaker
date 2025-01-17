package myPage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LicenseMapper {
	@Insert("INSERT INTO license (userId, type, license, acuisition, score)" +
			"VALUES ( #{userId}, #{type}, #{license}, #{acuisition}, #{score})")
	int insert(LicenseForInsert lisence);
	
	@Select("SELECT * FROM license WHERE no = #{ no }")
	License selectNo(@Param("no") int no);
	
	@Update("UPDATE license SET type = #{type}, acuisition = #{acuisition}, score = #{score} WHERE userId = #{userId} AND license = #{license}")
	int update(LicenseForInsert licenseForInsert);
	 
	@Select("SELECT * FROM license WHERE userId = #{userId} AND license = #{license}")
	License selectByUserIdAndName(@Param("userId") String userId, @Param("license") String license);
}
