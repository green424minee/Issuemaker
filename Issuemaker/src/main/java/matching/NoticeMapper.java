package matching;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import member.Company;
import myPage.Resume;



public interface NoticeMapper {
	@Insert("INSERT INTO notice (comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major, comLicense) " +
            "VALUES (#{comId}, #{title}, #{context}, #{postDate}, #{deadLine}, #{salary}, #{jobType}, #{exTerm}, #{workday}, #{type}, #{schoolLevel}, #{major}, #{comLicense})")
	int insert(NoticeForInsert notice);

	 @Update("UPDATE notice SET context = #{context}, deadLine = #{deadLine}" +
				"WHERE no = #{no}")
	 int update(Notice notice);

	 @Select("SELECT * FROM notice WHERE no = #{no}")
	 Notice getNoticeByNo(String no);
	 
	 @Select("SELECT type FROM guest WHERE id = #{id}")
	 int getType(String id);
	 
	 @Select("SELECT * FROM company WHERE comId = #{comId}")
	 Company selectCom(String comId);

	 @Select("SELECT * FROM notice WHERE comId = #{comId}")
	 Notice getNoticeById(String comId);


	 // 기업 이름 받아오기
	 @Select("SELECT comName FROM company WHERE comId = #{comId}")
	 String selectComName(@Param("comId") String comId);
	 
	 // 기업 지역 받아오기
	 @Select("SELECT comAddress FROM company WHERE comId = #{comId}")
	 String selectComAddress(@Param("comId") String comId);
	 
	 @Select("SELECT comLicense FROM notice WHERE comId = #{comId}")
	 List<String> getComLicenseByNoticeComId(String comId);

	 // 기업의 공고들 정보 받아오기
	 @Select("SELECT * FROM notice WHERE comId = #{comId}")
	 List<Notice> getNotices(String comId);
	 
	 // 기업에 지원한 이력서 받아오기
	 @Select("SELECT * FROM apply WHERE noticeNo IN (SELECT no FROM notice WHERE comId = #{comId}) ORDER BY noticeNo")
	 List<Apply> getResumeByNotice(String comId);
	 
	 // 공고 받아오기
	 @Select("SELECT * FROM notice WHERE no = #{no}")
	 Notice getNotice(int no);
	 
	 // 이력서 받아오기
	 @Select("SELECT * FROM resume WHERE no = #{no}")
	 Resume getResume(int no);
}
