package member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class UserService {
	private static final UserService instance = new UserService();
	
	public static UserService getInstance() {
		return instance;
	}
	
	private UserService() {}
	
	public int insert (User user) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.insert(user);
		
			
			session.commit();
				
			return row;
		}
	}
	
	public int updateInfo(User user) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.updateInfo(user);
			session.commit();
				
			return row;
		}
	}
	

}

