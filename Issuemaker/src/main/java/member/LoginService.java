package member;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class LoginService {
    private static LoginService instance;
    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }
    private LoginService() {}
	
	public List<String> selectId() {
		try (SqlSession session = DBUtil.getSqlSession()) {
			LoginMapper mapper = session.getMapper(LoginMapper.class);
			List<String> list = mapper.selectId();
			
			return list;
		}
	}
	
	public List<String> selectPw() {
		try (SqlSession session = DBUtil.getSqlSession()) {
			LoginMapper mapper = session.getMapper(LoginMapper.class);
			List<String> list = mapper.selectPw();
			
			return list;
		}
	}
	
	public int selectType(String id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			LoginMapper mapper = session.getMapper(LoginMapper.class);
			
			return mapper.selectType(id);
		}
	}
}
