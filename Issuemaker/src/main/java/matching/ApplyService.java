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
	
	public boolean isApplyExists(int noticeNo, int resumeNo) {
	    try (SqlSession session = DBUtil.getSqlSession()) {
	        ApplyMapper mapper = session.getMapper(ApplyMapper.class);
	        
	        // 해당 이력서가 이미 지원된 경우
	        int row = mapper.isApplyExists(noticeNo, resumeNo);
	        
	        // row가 0보다 크면 이미 존재하는 것이므로 true 반환
	        return row > 0; // 존재하면 true, 존재하지 않으면 false
	    }
	}
	
	public boolean checkApply(int noticeNo, String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        ApplyMapper mapper = session.getMapper(ApplyMapper.class);
	        
	        // 해당 이력서가 이미 지원된 경우
	        int row = mapper.checkApply(noticeNo, userId);
	        
	        // row가 0보다 크면 이미 존재하는 것이므로 true 반환
	        return row > 0; // 존재하면 true, 존재하지 않으면 false
	    }
	}
	
	public boolean deleteApply(int noticeNo, String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        ApplyMapper mapper = session.getMapper(ApplyMapper.class);
	        
	        int row = mapper.deleteApply(noticeNo, userId);
	        session.commit();
	        
	        return row > 0; 
	    }
	}
	
	public boolean updateResult1(int noticeNo, int resumeNo) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        ApplyMapper mapper = session.getMapper(ApplyMapper.class);
	        
	        int row = mapper.updateResult1(noticeNo, resumeNo);
	        session.commit();
	        
	        return row > 0; 
	    }
	}
	
	public boolean updateResult2(int noticeNo, int resumeNo) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        ApplyMapper mapper = session.getMapper(ApplyMapper.class);
	        
	        int row = mapper.updateResult2(noticeNo, resumeNo);
	        session.commit();
	        
	        return row > 0; 
	    }
	}
}
