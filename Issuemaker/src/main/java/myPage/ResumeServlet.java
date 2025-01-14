package myPage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.User;

@WebServlet("/resume")
public class ResumeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("resumeNo");
		int resumeNo = Integer.parseInt(no);
		
		ResumeService ser = ResumeService.getInstance();
		Resume resume = ser.selectResume(resumeNo);
		req.setAttribute("resume", resume);
		
		// 이력서 사진
		byte[] userPhoto = resume.getUserPhoto();
		String Photo;
		if (userPhoto != null) {
			Photo = Base64.getEncoder().encodeToString(userPhoto);
		} else {
			Photo = null;
		}
		req.setAttribute("photo", Photo);
		
		// 유저 이름
		String id = resume.getUser();
		String userName = ser.selectUserName(id);
		req.setAttribute("userName", userName);
		
		// 희망 직무
		String type = resume.getJobType();
		req.setAttribute("type", type);
		
		// 경력
		List<WorkHistory> list = ser.selectWork(id);
		List<String> history = new ArrayList<>();
		for (WorkHistory l : list) {
			String exCom = l.getExCom();
			long yearsBetween = ChronoUnit.YEARS.between(l.getStartDate(), l.getEndDate());
			history.add(exCom + " " + yearsBetween);
		}
		req.setAttribute("history", history);
		
		// 최종학력
		School school = ser.selectSchool(id);
		req.setAttribute("school", school);
		
		// 자격증
		List<License> listLi = ser.selectLicense(id);
		req.setAttribute("listLi", listLi);
		
		// 자기소개서 보기
		// 포트폴리오 보기

		req.getRequestDispatcher("/WEB-INF/views/mypage/resume.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if (action.equals("수정")) {
			resp.sendRedirect("#"); // 이력서 수정
		} else if (action.equals("삭제")) {
			
		}
		
	}
	
}
