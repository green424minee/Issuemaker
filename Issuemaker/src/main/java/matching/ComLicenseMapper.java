package matching;

import org.apache.ibatis.annotations.Insert;

public interface ComLicenseMapper {

		@Insert("INSERT INTO comlicense (comId, comLicense) VALUES (#{comId}, #{comLicense})")
		int insert(ComLicense comLicense);
}
