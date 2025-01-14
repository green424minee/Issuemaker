package myPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import matching.Apply;
import matching.Notice;
import util.DBUtil;

public class NoticeListService {
	private static final NoticeListService instance = new NoticeListService();
	private NoticeListService() {}
	public static NoticeListService getInstance() {
		return instance;
	}
	
	public List<Integer> selectResumeNo(String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			NoticeListMapper mapper = session.getMapper(NoticeListMapper.class);
			
			List<Integer> list = mapper.selectResumeNo(userId);
			
			return list;
		}
	}
	
	public List<Integer> selectApply(int resumeNo) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			NoticeListMapper mapper = session.getMapper(NoticeListMapper.class);
			
			List<Integer> list = mapper.selectApply(resumeNo);
			
			return list;
		}
	}
	
	public Notice selectNotice(int noticeNo) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			NoticeListMapper mapper = session.getMapper(NoticeListMapper.class);
			
			Notice notice = mapper.selectNotice(noticeNo);
			
			return notice;
		}
	}
	
	
}
