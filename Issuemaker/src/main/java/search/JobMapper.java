package search;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface JobMapper {
	@Select("SELECT * FROM job")
	List<Job> selectAll();
}
