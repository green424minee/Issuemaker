package search;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import matching.Notice;
import matching.NoticeForInsert;
import member.Company;

public interface IndexMapper {
    @Select("SELECT * FROM company WHERE comName = #{comName}")
    List<Company> getCompanyByComName(String comName);

    @Select("SELECT * FROM notice WHERE no = #{no}")
    Notice getNoticeByNo(String no);
    
    @Select("SELECT * FROM notice")
    List<Notice> getNoticeByAll();
}
