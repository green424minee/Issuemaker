package member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CompanyMapper {
	 
	 @Insert("INSERT INTO company (comId, comName, comNo, comPhone, comCeo, managerEmail, comAddress, otherAddress, comBirth, comSize, comWeb) " +
	            "VALUES (#{comId}, #{comName}, #{comNo}, #{comPhone}, #{comCeo}, #{managerEmail}, #{comAddress}, #{otherAddress}, #{comBirth}, #{comSize}, #{comWeb})")
	 int insert(Company company);

	 @Update("UPDATE company SET comNo = #{comNo}, comPhone = #{comPhone}, managerEmail = #{managerEmail}, comAddress = #{comAddress}, otherAddress = #{otherAddress}, comSize = #{comSize}, comWeb = #{comWeb} " +
				"WHERE comId = #{comId}")
	 int update(Company company);

	 @Select("SELECT * FROM company WHERE comId = #{comId}")
	 Company getCompanyBycomId(String comId);


}
