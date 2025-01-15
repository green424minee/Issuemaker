package matching;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SuggestMapper {
	@Select("SELECT * FROM suggest WHERE userId = #{userId}")
	List<Suggest> selectSuggest(String userId);
	
	@Select("SELECT comName FROM company WHERE comId = #{comId}")
	String selectComName(String comId);
	
}
