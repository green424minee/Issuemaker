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
import java.util.Arrays;
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
import util.GetCookie;

@WebServlet("/writeResume")
@MultipartConfig
public class WriteResumeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try (SqlSession session = DBUtil.getSqlSession()) {
	            JobMapper jobmapper = session.getMapper(JobMapper.class);
	            List <String> jobList = jobmapper.selectAll();
	            
	            
	            GetCookie co = new GetCookie();
	            String userId = co.getCookieUserId(req);
	            
	            SchoolService schoolservice = SchoolService.getInstance();
	            School school = schoolservice.selectByUserId(userId);
	            
	            WorkHistoryService workHistoryService = WorkHistoryService.getInstance();
	            WorkHistory workHistory = workHistoryService.selectByUserId(userId);
	            
	            req.setAttribute("jobList", jobList);
	            req.setAttribute("school", school);
	            req.setAttribute("workHistory", workHistory);
	            req.getRequestDispatcher("/WEB-INF/views/mypage/writeResume.jsp").forward(req, resp);
	        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이력서
		try {
				GetCookie co = new GetCookie();
				String userId = co.getCookieUserId(req);
				if (userId == null || userId.trim().isEmpty()) {
					throw new ServletException("유효한 userId가 아닙니다.");
				}
			try {
					String title = req.getParameter("title");
					String jobType = req.getParameter("jobType");
					String salaryStr = req.getParameter("salary");
					int salary = (salaryStr == null || salaryStr.trim().isEmpty()) ? 0 : Integer.parseInt(salaryStr);

					int agree = 0;
					

					// 파일 데이터 받기 (사진, 자기소개서, 포트폴리오)
					Part userPhotoPart = req.getPart("userPhoto");
					Part coverLetterPart = req.getPart("coverLetter");
					Part portfolioPart = req.getPart("portfolio");

					byte[] userPhoto = userPhotoPart != null ? userPhotoPart.getInputStream().readAllBytes() : null;
			        byte[] coverLetter = coverLetterPart != null ? coverLetterPart.getInputStream().readAllBytes() : null;
			        byte[] portfolio = portfolioPart != null ? portfolioPart.getInputStream().readAllBytes() : null;
			        
					ResumeService resumeservice = ResumeService.getInstance();
					ResumeForInsert resume = new ResumeForInsert(userId, userPhoto, title, jobType, coverLetter, portfolio, salary, agree);
					//System.out.println("Inserting : " + resume);
					resumeservice.insert(resume);

				} catch (Exception e) {
					System.err.println("Error processing resume data: " + e.getMessage());
			}
	    
	    
	   //학력  
			try {
				int type = Integer.parseInt(req.getParameter("type"));
				String level = req.getParameter("level");
				String schoolName = req.getParameter("schoolName");
				String schoolLevelStr = req.getParameter("schoolLevel");
				int schoolLevel = (schoolLevelStr == null || schoolLevelStr.trim().isEmpty()) ? 0 : Integer.parseInt(schoolLevelStr);
				String majorStr = req.getParameter("major");
				String major = (majorStr == null || majorStr.trim().isEmpty()) ? null : majorStr;
				LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
				LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));

				SchoolService schoolService = SchoolService.getInstance();
				School school = new School(userId, type, level, schoolName, schoolLevel, major, startDate, endDate);
				//System.out.println("Inserting : " + school);
				schoolService.insert(school);
			} catch (Exception e) {
				System.err.println("Error processing school data: " + e.getMessage());
				throw new ServletException("학력 처리 중 오류가 발생했습니다.", e);
			}
	  	
	  	
	  	// 자격증
		// LicenseService 객체 생성
			  	LicenseService licenseService = LicenseService.getInstance();

			  	// 동적으로 입력된 자격증 항목 처리
			  	int licenseCount = Integer.parseInt(req.getParameter("licenseCount")); // 추가된 자격증의 개수를 가져옵니다.

			  	for (int i = 0; i < licenseCount; i++) {
			  	    // 각 자격증에 대한 값들을 개별적으로 가져옵니다.
			  	    String license = req.getParameter("license" + i);
			  	    String acquisitionDate = req.getParameter("acquisition" + i);
			  	    String score = req.getParameter("score" + i);
			  	    String type1 = req.getParameter("licenseType" + i);

			  	    // 값 확인을 위한 로그
			  	    //System.out.println("License " + i + ": " + license + ", " + acquisitionDate + ", " + score + ", " + type1);

			  	   // if (license == null || acquisitionDate == null || type1 == null) {
			  	        // 필수 항목이 누락된 경우 처리 (디버깅용)
			  	       // System.out.println("Missing value for license " + i);
			  	       // continue;
			  	   // }

			  	    // 취득일을 LocalDate로 변환
			  	    LocalDate acquisition = LocalDate.parse(acquisitionDate); // 취득일
			  	    Integer scoreValue = (score == null || score.trim().isEmpty()) ? null : Integer.parseInt(score); // 점수
			  	    int typeValue = Integer.parseInt(type1); // 자격증 구분 값

			  	    // LicenseForInsert 객체 생성 및 데이터베이스 삽입
			  	    LicenseForInsert licenseForInsert = new LicenseForInsert(userId, typeValue, license, acquisition, scoreValue);
			  	    //System.out.println("Inserting License: " + licenseForInsert);
			  	   
			  	    licenseService.insert(licenseForInsert); // 데이터베이스에 삽입
			  	}
			  	


        //경력
			try {
				String exCom = req.getParameter("exCom");
				LocalDate startDate1 = LocalDate.parse(req.getParameter("startDate1"));
				LocalDate endDate1 = LocalDate.parse(req.getParameter("endDate1"));
				String jobType1 = req.getParameter("jobType1");

				WorkHistoryService workHistoryService = WorkHistoryService.getInstance();
				WorkHistoryForInsert workHistory = new WorkHistoryForInsert(userId, exCom, startDate1, endDate1, jobType1);
				//System.out.println("Inserting : " + workHistory);
				workHistoryService.insert(workHistory);
				
				
			} catch (Exception e) {
				System.err.println("Error processing work history data: " + e.getMessage());
				throw new ServletException("경력 처리 중 오류가 발생했습니다.", e);
			}
			req.getRequestDispatcher("/WEB-INF/views/mypage/userPage.jsp").forward(req, resp);
		} catch (Exception e) {
			System.err.println("Error during form submission: " + e.getMessage());
			e.printStackTrace();
			req.setAttribute("errorMessage", "데이터 처리 중 오류가 발생했습니다: " + e.getMessage());
		}
	}

//
}
