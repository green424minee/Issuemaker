package search;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AreaMapper {
    @Select("SELECT * FROM area")
    List<Area> getAreaByAll();
}
