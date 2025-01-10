package member;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class Guest0Service {
private static final Guest0Service instance = new Guest0Service();
	
	public static Guest0Service getInstance() {
		return instance;
	}
	
	private Guest0Service() {}
	
	public int insert (String id, String pw) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			Guest0Mapper mapper = session.getMapper(Guest0Mapper.class);
			
			int row = mapper.insert(id, pw);
		
			
			session.commit();
				
			return row;
		}
	}
}
