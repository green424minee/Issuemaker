package myPage;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import member.CompanyMapper;
import search.Job;
import search.JobMapper;
import util.DBUtil;

@WebServlet("/writeResume")
@MultipartConfig
public class WriteResumeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try (SqlSession session = DBUtil.getSqlSession()) {
	            JobMapper jobmapper = session.getMapper(JobMapper.class);
	            List <Job> jobList = jobmapper.selectAll();
	            
	            req.setAttribute("jobList", jobList);
	            req.getRequestDispatcher("/WEB-INF/views/mypage/writeResume.jsp").forward(req, resp);
	        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이력서
		String userId = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if ("user".equals(c.getName())) {
				userId = c.getValue();
			}
		}
		String title = req.getParameter("title");
	    String jobType = req.getParameter("jobType");
	    String salaryStr = req.getParameter("salary");
	    int salary = (salaryStr == null || salaryStr.trim().isEmpty()) ? 0 : Integer.parseInt(salaryStr);

		int agree = Integer.parseInt(req.getParameter("agree")); 

	    // 파일 데이터 받기 (사진, 자기소개서, 포트폴리오)
        Part userPhotoPart = req.getPart("userPhoto");
        Part coverLetterPart = req.getPart("coverLetter");
        Part portfolioPart = req.getPart("portfolio");

        byte[] userPhoto = userPhotoPart != null ? userPhotoPart.getInputStream().readAllBytes() : null;
        byte[] coverLetter = coverLetterPart != null ? coverLetterPart.getInputStream().readAllBytes() : null;
        byte[] portfolio = portfolioPart != null ? portfolioPart.getInputStream().readAllBytes() : null;
        
        
	    ResumeService resumeservice = ResumeService.getInstance();
	    ResumeForInsert resume = new ResumeForInsert(userId, userPhoto, title, jobType, coverLetter, portfolio, salary, agree);
	    resumeservice.insert(resume);
	    
	   //학력  
	    int type = Integer.parseInt(req.getParameter("type"));
	    String level = req.getParameter("level");
	    String schoolName = req.getParameter("schoolName");
	    String schoolLevelStr = req.getParameter("schoolLevel"); 
	    int schoolLevel = (schoolLevelStr == null || schoolLevelStr.trim().isEmpty()) ? 0 : Integer.parseInt(schoolLevelStr);
	    String majorStr = req.getParameter("major");
	    String major = (majorStr == null || majorStr.trim().isEmpty()) ? null : majorStr;
	    LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
	    LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
	          
	    SchoolService schoolservice = SchoolService.getInstance();
	  	School school = new School(userId, type, level, schoolName, schoolLevel, major, startDate, endDate);
	  	schoolservice.insert(school);
	  	
	  	// 자격증
        int type1 = Integer.parseInt(req.getParameter("type1"));
        String license = req.getParameter("license");
        LocalDate acuisition = LocalDate.parse(req.getParameter("acuisition"));
        String scoreStr = req.getParameter("score");
        Integer score = (scoreStr == null || scoreStr.trim().isEmpty()) ? null : Integer.parseInt(scoreStr);
        
        LicenseService licenseservice = LicenseService.getInstance();
        LicenseForInsert license2 = new LicenseForInsert(userId, type1, license, acuisition, score);
        licenseservice.insert(license2);
	    
        //경력
        String exCom = req.getParameter("exCom");
        LocalDate startDate1 = LocalDate.parse(req.getParameter("startDate1"));
        LocalDate endDate1 = LocalDate.parse(req.getParameter("endDate1"));
        String jobType1 = req.getParameter("jobType1");
        
        WorkHistoryService workHistoryservice = WorkHistoryService.getInstance();
        WorkHistoryForInsert workHistory = new WorkHistoryForInsert(userId, exCom, startDate1, endDate1, jobType1);
        workHistoryservice.insert(workHistory);
	  
	    req.getRequestDispatcher("/WEB-INF/views/mypage/userPage.jsp").forward(req, resp);
	   
	}
//
}
