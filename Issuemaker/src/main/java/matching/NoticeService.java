package matching;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import member.Company;
import member.CompanyMapper;
import myPage.Resume;
import util.DBUtil;

public class NoticeService {
	private static final NoticeService instance = new NoticeService();
	private NoticeService() {}
	
	public static NoticeService getInstance() {
		return instance;
	}
	
	public int insert(NoticeForInsert notice) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			
			int row = mapper.insert(notice);
			
			session.commit();
			
			return row;
		}
	}
	
	 public int update(Notice notice) {
	        try (SqlSession session = DBUtil.getSqlSession()) {
	            NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	            int row = mapper.update(notice); 
	            session.commit();
	            return row;
	        }
	    }
	    
	 public Notice getNoticeByNo(String no) {
		 try (SqlSession session = DBUtil.getSqlSession()) {
			 NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	         return mapper.getNoticeByNo(no);
	     }
	 }
	    
	public int getType(String comId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
				NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	            return mapper.getType(comId);
		}
	}	
	    
	public Company selectCom(String comId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
				NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	            return mapper.selectCom(comId);
		}
	}

	public Notice getNoticeById(String comId) {
			try(SqlSession session = DBUtil.getSqlSession()){
	    	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	    	return mapper.getNoticeById(comId);
	    }

	}

	public String selectComName(String comId) {
		try(SqlSession session = DBUtil.getSqlSession()){
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			return mapper.selectComName(comId);
		}
	}

	public String selectComAddress(String comId) {
		try(SqlSession session = DBUtil.getSqlSession()){
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			return mapper.selectComAddress(comId);
		}
	}
	
	public List<String> getComLicenseByNoticeComId(String comId) {
	    try (SqlSession session = DBUtil.getSqlSession()) {
	        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	        return mapper.getComLicenseByNoticeComId(comId);
	    }
	}

	public List<Notice> getNotices(String comId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	        return mapper.getNotices(comId);
	    }
	}

	public List<Apply> getResumeByNotice(String comId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	        return mapper.getResumeByNotice(comId);
	    }
	}
	
	public Notice getNotice(int no) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	        return mapper.getNotice(no);
	    }
	}
	
	public Resume getResume(int no) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	        return mapper.getResume(no);
	    }
	}
}
