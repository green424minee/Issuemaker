package myPage;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class WorkHistoryService {
	private static final WorkHistoryService instance = new WorkHistoryService();
	
	public static WorkHistoryService getInstance() {
		return instance;
	}
	private WorkHistoryService() {}
	
	public int insert (WorkHistoryForInsert workHistory) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			WorkHistoryMapper mapper = session.getMapper(WorkHistoryMapper.class);
			
			int row = mapper.insert(workHistory);
			
			session.commit();
			
			return row;
		}
	}
	public WorkHistory selectByUserId(String userId) {
		 try (SqlSession session = DBUtil.getSqlSession()) {
	         WorkHistoryMapper mapper = session.getMapper(WorkHistoryMapper.class);
	         
	         return mapper.selectByUserId(userId);
	      }
	}
	public int update(WorkHistoryForInsert workHistory) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			WorkHistoryMapper mapper = session.getMapper(WorkHistoryMapper.class);
			
			int rowUpdated = mapper.update(workHistory);
			session.commit();
			
			return rowUpdated;
		}
	}

}
