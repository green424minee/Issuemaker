package member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	
	@Insert("INSERT INTO user (userId, userName, userBirth, userPhone, userEmail, userAddress) "
			+ "VALUES (#{ userId }, #{ userName }, #{ userBirth }, #{ userPhone }, #{ userEmail }, #{ userAddress })")
	int insert(User user);

	@Update("UPDATE user Set userName = #{userName}, userBirth = #{userBirth}, userPhone = #{userPhone}"
				+ ", userEmail = #{userEmail}, userAddress = #{userAddress} WHERE userId = #{userId}")
	int updateInfo(User user);
	
	// 유저 정보 가져오기
	@Select("SELECT * FROM user WHERE userId = #{userId}")
	User selectUser(@Param("userId") String userId);
}
