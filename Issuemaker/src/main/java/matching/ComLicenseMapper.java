package matching;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import member.Company;

public interface ComLicenseMapper {

		@Insert("INSERT INTO comlicense (comId, comLicense) VALUES (#{comId}, #{comLicense})")
		int insert(ComLicense comLicense);
		
		 @Select("SELECT * FROM comlicense WHERE comId = #{comId}")
		 ComLicense getComLicenseById(String comId);
}
