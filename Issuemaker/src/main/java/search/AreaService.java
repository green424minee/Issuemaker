package search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class AreaService {
	private static final AreaService instance = new AreaService();
	private AreaService() {}
	public static AreaService getInstance() {
		return instance;
	}
	
	public List<Area> getAreaByAll(){
		try(SqlSession session = DBUtil.getSqlSession()){
			AreaMapper mapper  = session.getMapper(AreaMapper.class);
			
			List<Area> all = mapper.getAreaByAll();
			
			return all;
		}
	}
}
