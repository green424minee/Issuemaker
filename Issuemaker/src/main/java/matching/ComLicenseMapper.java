package matching;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import member.Company;

public interface ComLicenseMapper {

		@Insert("INSERT INTO comlicense (comId, comLicense) VALUES (#{comId}, #{comLicense})")
		int insert(ComLicense comLicense);
		
		 @Select("SELECT comLicense FROM comlicense WHERE comId = #{comId}")
		 List<String> getComLicenseById(String comId);
}
