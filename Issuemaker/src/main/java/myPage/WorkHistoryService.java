package myPage;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class WorkHistoryService {
	private static final WorkHistoryService instance = new WorkHistoryService();
	
	public static WorkHistoryService getInstance() {
		return instance;
	}
	private WorkHistoryService() {}
	
	public int insert (WorkHistory workHistory) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			WorkHistoryMapper mapper = session.getMapper(WorkHistoryMapper.class);
			
			int row = mapper.insert(workHistory);
			
			session.commit();
			
			return row;
		}
	}

}
