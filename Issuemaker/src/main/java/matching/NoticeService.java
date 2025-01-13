package matching;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class NoticeService {
	private static final NoticeService instance = new NoticeService();
	private NoticeService() {}
	
	public static NoticeService getInstance() {
		return instance;
	}
	
	public int insert(Notice notice) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			
			int row = mapper.insert(notice);
			
			session.commit();
			
			return row;
		}
	}
}
