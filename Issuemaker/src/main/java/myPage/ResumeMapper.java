package myPage;

import org.apache.ibatis.annotations.Insert;

public interface ResumeMapper {
	
	@Insert("INSERT INTO resume (userId, userPhoto, title, jobType, coverLetter, portfolio, agree) " +
            "VALUES ( #{userId}, #{userPhoto}, #{title}, #{jobType}, #{coverLetter}, #{portfolio}, #{agree})")
    int insert(Resume resume);
}
