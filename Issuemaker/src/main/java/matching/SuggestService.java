package matching;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class SuggestService {
	private static final SuggestService instance = new SuggestService();
	private SuggestService() {}
	
	public static SuggestService getInstance() {
		return instance;
	}
	
	public List<Suggest> selectSuggest(String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			SuggestMapper mapper = session.getMapper(SuggestMapper.class);
			
			List<Suggest> list = mapper.selectSuggest(userId);
            return list;
        }
	}
	
	public String selectComName(String comId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			SuggestMapper mapper = session.getMapper(SuggestMapper.class);
			
			return mapper.selectComName(comId);
        }
	}
}
