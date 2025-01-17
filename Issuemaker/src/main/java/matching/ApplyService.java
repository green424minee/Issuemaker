package matching;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class ApplyService {
	private static final ApplyService instance = new ApplyService();
	private ApplyService() {}
	public static ApplyService getInstance() {
		return instance;
	}
	
	public int insertApply(int noticeNo, int resumeNo) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ApplyMapper mapper = session.getMapper(ApplyMapper.class);
			
			int row = mapper.insertApply(noticeNo, resumeNo);
			session.commit();
			
			return row;
		}
	}
}
