package myPage;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class SchoolService {
	private static final SchoolService instance = new SchoolService();
	
	public static SchoolService getInstance() {
		return instance;
	}
	private SchoolService() {}
	
	public int insert (School school) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			
			int row = mapper.insert(school);
			
			session.commit();
			
			return row;
		}
	}
}
