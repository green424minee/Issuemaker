package myPage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class myPageService {
	private static final myPageService instance = new myPageService();
	private myPageService() {}
	public static myPageService getInstance() {
		return instance;
	}
	
	public List<Resume> selectResume(String user) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			myPageMapper mapper = session.getMapper(myPageMapper.class);
			
			List<Resume> list = mapper.selectResume(user);
			
			return list;
		}
	}
}


