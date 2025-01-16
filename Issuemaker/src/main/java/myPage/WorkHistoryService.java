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
	public WorkHistory selectNo(int historyNo) {
		 try (SqlSession session = DBUtil.getSqlSession()) {
	         WorkHistoryMapper mapper = session.getMapper(WorkHistoryMapper.class);
	         
	         WorkHistory workHistory = mapper.selectNo(historyNo);
	         
	         return workHistory;
	      }
	}

}
