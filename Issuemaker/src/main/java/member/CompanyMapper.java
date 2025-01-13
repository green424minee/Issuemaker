package member;

import org.apache.ibatis.annotations.Insert;

public interface CompanyMapper {
	 
	 @Insert("INSERT INTO company (comId, comName, comNo, comPhone, comCeo, managerEmail, comAddress, comBirth, comSize, comWeb) " +
	            "VALUES (#{comId}, #{comName}, #{comNo}, #{comPhone}, #{comCeo}, #{managerEmail}, #{comAddress}, #{comBirth}, #{comSize}, #{comWeb})")
	 int insert(Company company);


}
