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
import java.time.format.DateTimeParseException;
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
	        List<String> jobList = jobmapper.selectAll();

	        GetCookie co = new GetCookie();
	        String userId = co.getCookieUserId(req);

	        if (userId == null || userId.trim().isEmpty()) {
	            resp.sendRedirect(req.getContextPath() + "/login");
	            return;
	        }

	        SchoolService schoolservice = SchoolService.getInstance();
	        School school = schoolservice.selectByUserId(userId);

	        WorkHistoryService workHistoryService = WorkHistoryService.getInstance();
	        WorkHistory workHistory = workHistoryService.selectByUserId(userId);

	        req.setAttribute("jobList", jobList);
	        req.setAttribute("school", school);
	        req.setAttribute("workHistory", workHistory);

	        req.getRequestDispatcher("/WEB-INF/views/mypage/writeResume.jsp").forward(req, resp);

	    } catch (Exception e) {
	        req.setAttribute("errorMessage", "오류가 발생했습니다. 다시 시도해 주세요.");
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

			        // 서비스 호출
			        SchoolService schoolService = SchoolService.getInstance();
			        School schooldata = schoolService.selectByUserId(userId);

			        // 이미 데이터가 있는 경우 업데이트
			        if (schooldata != null) {
			            School school = new School(userId, type, level, schoolName, schoolLevel, major, startDate, endDate);
			            schoolService.update(school);
			           
			        } else {
			            School school = new School(userId, type, level, schoolName, schoolLevel, major, startDate, endDate);
			            schoolService.insert(school);			        
			        }
			    } catch (NumberFormatException e) {
			        
			        req.setAttribute("errorMessage", "유효하지 않은 입력 값이 있습니다. 다시 시도해 주세요.");
			    } catch (DateTimeParseException e) {
			        // 날짜 형식 오류 처리
			        req.setAttribute("errorMessage", "날짜 형식이 잘못되었습니다. 다시 시도해 주세요.");
			    } catch (Exception e) {
			        req.setAttribute("errorMessage", "학교 정보 처리 중 오류가 발생했습니다. 다시 시도해 주세요.");
			    }
			
	  	
	  	
			 	// 자격증
			  	LicenseService licenseService = LicenseService.getInstance();

			  	// 동적으로 입력된 자격증 항목 처리
			  	int licenseCount = Integer.parseInt(req.getParameter("licenseCount")); // 추가된 자격증의 개수를 가져옵니다.

			  	for (int i = 0; i < licenseCount; i++) {
			  	    // 각 자격증에 대한 값들을 개별적으로 가져옵니다.
			  	    String license = req.getParameter("license" + i);
			  	    String acuisitionDate = req.getParameter("acuisition" + i);
			  	    String score = req.getParameter("score" + i);
			  	    String type1 = req.getParameter("licenseType" + i);

			  	   

			  	    // 취득일을 LocalDate로 변환
			  	    LocalDate acuisition = LocalDate.parse(acuisitionDate); // 취득일
			  	    Integer scoreValue = (score == null || score.trim().isEmpty()) ? null : Integer.parseInt(score); // 점수
			  	    int typeValue = Integer.parseInt(type1); // 자격증 구분 값

			  	    // LicenseForInsert 객체 생성 및 데이터베이스 삽입
			  	    boolean isExist = licenseService.isLicenseExist(userId, license);
			  	    LicenseForInsert licenseForInsert = new LicenseForInsert(userId, typeValue, license, acuisition, scoreValue);
			  	    if (isExist) {
			          licenseService.update(licenseForInsert);
			      } else {
			          licenseService.insert(licenseForInsert);
			      }
			  } 
			  	
			  	


        //경력
				String exCom = req.getParameter("exCom");
				LocalDate startDate1 = LocalDate.parse(req.getParameter("startDate1"));
				LocalDate endDate1 = LocalDate.parse(req.getParameter("endDate1"));
				String jobType1 = req.getParameter("jobType1");

				WorkHistoryService workHistoryService = WorkHistoryService.getInstance();
				WorkHistory workdata = workHistoryService.selectByUserId(userId);
				
				if (workdata != null) {
					WorkHistoryForInsert workHistory = new WorkHistoryForInsert(userId, exCom, startDate1, endDate1, jobType1);
					workHistoryService.update(workHistory);
				} else {
					WorkHistoryForInsert workHistory = new WorkHistoryForInsert(userId, exCom, startDate1, endDate1, jobType1);
					workHistoryService.insert(workHistory);
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