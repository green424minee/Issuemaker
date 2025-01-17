package myPage;

import java.time.LocalDate;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class SchoolService {
	private static final SchoolService instance = new SchoolService();
	
	public static SchoolService getInstance() {
		return instance;
	}
	private SchoolService() {}
	
	public int insert (School school) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			
			int row = mapper.insert(school);
			
			session.commit();
			
			return row;
		}
	}
	public School selectByUserId(String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
	         SchoolMapper mapper = session.getMapper(SchoolMapper.class);
	      
	         return mapper.selectByUserId(userId);
	      }
		
	}
	 public int update(School school) {
	        try (SqlSession session = DBUtil.getSqlSession()) {
	            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
	            
	            return mapper.update(school); 
	        }
	    }
	
}
