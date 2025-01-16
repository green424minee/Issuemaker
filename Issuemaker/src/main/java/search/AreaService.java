package search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import matching.MatchingAreasAndCompanies;
import matching.Notice;
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
	
	public List<Notice> getComId(@Param("area") String area) {
		try(SqlSession session = DBUtil.getSqlSession()){
			AreaMapper mapper  = session.getMapper(AreaMapper.class);
			
			return mapper.getComId(area);	
		}
	}
	

}
