package search;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import matching.MatchingAreasAndCompanies;

public interface AreaMapper {
    @Select("SELECT areaName FROM area ")
    List<String> getAreaByAll();
    
    @Select("""
            SELECT a.areaName, c.comAddress
            FROM area a
            JOIN Notice n ON a.areaId = n.areaId
            JOIN company c ON n.comId = c.comId
            WHERE SUBSTRING(c.comAddress, 1, 2) = SUBSTRING(a.areaName, 1, 2)
        """)
        List<MatchingAreasAndCompanies> findMatchingAreasAndCompanies();
    
    
}
