package member;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class Guest1Service {
	private static final Guest1Service instance = new Guest1Service();
	private Guest1Service() {}
	
	public static Guest1Service getInstance() {
		
		return instance;
	}
	
	public int insert(String id, String pw) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			Guest1Mapper mapper = session.getMapper(Guest1Mapper.class);
			
			int row = mapper.insert(id,pw);
			
			session.commit();
			
			return row;
		}
	}
	
	public int updateInfo(String id, String pw) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			Guest1Mapper mapper = session.getMapper(Guest1Mapper.class);
			
			int row = mapper.updateInfo(id,pw);
			
			session.commit();
			
			return row;
		}
	}
}
