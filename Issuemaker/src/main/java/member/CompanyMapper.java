package member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CompanyMapper {
	 
	 @Insert("INSERT INTO company (comId, comName, comNo, comPhone, comCeo, managerEmail, comAddress, comBirth, comSize, comWeb) " +
	            "VALUES (#{comId}, #{comName}, #{comNo}, #{comPhone}, #{comCeo}, #{managerEmail}, #{comAddress}, #{comBirth}, #{comSize}, #{comWeb})")
	 int insert(Company company);

	 @Update("UPDATE company SET comPhone = #{comPhone}, managerEmail = #{managerEmail}, comAddress = #{comAddress}, comSize = #{comSize}, comWeb = #{comWeb} " +
				"WHERE comId = #{comId}")
	 int update(Company company);

	 @Select("SELECT * FROM company WHERE comId = #{comId}")
	 Company getCompanyBycomId(String comId);
}
