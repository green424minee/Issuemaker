package myPage;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class ResumeService {
	private static final ResumeService instance = new ResumeService();
	
	public static ResumeService getInstance() {
		return instance;
	}
	private ResumeService() {}
	
	public int insert (Resume resume) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.insert(resume);
			
			session.commit();
			
			return row;
		}
	}
}
