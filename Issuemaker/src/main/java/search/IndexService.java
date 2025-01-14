package search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import matching.Notice;
import matching.NoticeForInsert;
import util.DBUtil;

public class IndexService {
	private static final IndexService instance = new IndexService();
	private IndexService() {}
	public static IndexService getInseance() {
		return instance;
	}
	
	public Notice getNoticeByNo(String no){
		try (SqlSession session = DBUtil.getSqlSession()){
		IndexMapper mapper = session.getMapper(IndexMapper.class);
		
		Notice list = mapper.getNoticeByNo(no);
		
		return list;
		
		}		
	}
	
	public List<Notice> getNoticeByAll() {
		try(SqlSession session = DBUtil.getSqlSession()){
		IndexMapper mapper = session.getMapper(IndexMapper.class);
		
		List<Notice> all = mapper.getNoticeByAll();
		
		return all;
		
		
		}
	}

	
}
