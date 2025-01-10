package member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Insert("INSERT INTO user (userId, userName, userBirth, userPhone, userEmail, userAddress) "
			+ "VALUES (#{ userId }, #{ userName }, #{ userBirth }, #{ userPhone }, #{ userEmail }, #{ userAddress })")
	int insert(User user);

}
