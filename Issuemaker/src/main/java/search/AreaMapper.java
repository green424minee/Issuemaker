package search;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import matching.Notice;

public interface AreaMapper {
    @Select("SELECT areaName FROM area ")
    List<String> getAreaByAll();
    
    @Select("SELECT * FROM notice WHERE comId IN (SELECT comId FROM company"
    		+ " WHERE LEFT(comAddress, LOCATE(' ', comAddress) - 1) = #{area})")
    List<Notice> getComId(@Param("area") String area);
    
    @Select("SELECT * FROM notice WHERE comId IN ("
            + "SELECT comId FROM company WHERE comAddress LIKE CONCAT('%', #{area}, '%'))")
    List<Notice> getArea(String area);
    

}
