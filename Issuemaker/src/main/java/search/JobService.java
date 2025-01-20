package search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import matching.Notice;
import util.DBUtil;

public class JobService {
	private static final JobService instance = new JobService();
	private JobService() {}
	
	public static JobService getInstance() {
		return instance;
	}
	
	public List<String> selectAll(){
		try(SqlSession session = DBUtil.getSqlSession()){
			JobMapper mapper  = session.getMapper(JobMapper.class);
			
			return mapper.selectAll();
		}
	}
	
	public List<Notice> getNotice(String jobType) {
		try(SqlSession session = DBUtil.getSqlSession()){
			JobMapper mapper  = session.getMapper(JobMapper.class);
			
			return mapper.getNotice(jobType);	
		}
	}
	
	public String getArea(String comId) {
		try(SqlSession session = DBUtil.getSqlSession()){
			JobMapper mapper  = session.getMapper(JobMapper.class);
			
			return mapper.getArea(comId);	
		}
	}
	public List<Notice> getJobType(String jobType) {
		try(SqlSession session = DBUtil.getSqlSession()){
			JobMapper mapper  = session.getMapper(JobMapper.class);
			
			return mapper.getJobType(jobType);	
		}
	}

}
