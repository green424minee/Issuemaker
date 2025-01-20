package search;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import matching.Notice;

public interface JobMapper {
	@Select("SELECT * FROM job")
	List<String> selectAll();
	
	@Select("SELECT * FROM notice WHERE jobType = #{jobType}")
	List<Notice> getNotice(String jobType);
	
	@Select ("SELECT LEFT(comAddress, LOCATE(' ', comAddress) - 1) FROM company"
				+ "WHERE comId = #{comId}")
	String getArea(String comId);
	
}
