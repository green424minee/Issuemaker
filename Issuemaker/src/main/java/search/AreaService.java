package search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import matching.MatchingAreasAndCompanies;
import util.DBUtil;

public class AreaService {
	private static final AreaService instance = new AreaService();
	private AreaService() {}
	
	public static AreaService getInstance() {
		return instance;
	}
	
	public List<String> getAreaByAll(){
		try(SqlSession session = DBUtil.getSqlSession()){
			AreaMapper mapper  = session.getMapper(AreaMapper.class);
			
			return mapper.getAreaByAll();
			
			
		}
	}
	
	 public List<MatchingAreasAndCompanies> getMatchingAreasAndCompanies() {
	        try(SqlSession session = DBUtil.getSqlSession()){
	        	AreaMapper mapper = session.getMapper(AreaMapper.class);
	        	
	        	return mapper.findMatchingAreasAndCompanies();
	        }
	    }
}
