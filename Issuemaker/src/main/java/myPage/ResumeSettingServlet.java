package myPage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resumesetting")
public class ResumeSettingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*String userId = "";
 		Cookie[] cookies = req.getCookies();
 		for (Cookie c : cookies) {
 			if ("user".equals(c.getName())) {
 				userId = c.getValue();
 			}
 		}*/
 		
 		String userId ="qwer1234";
        SchoolService schoolservice = SchoolService.getInstance();
        School school = schoolservice.selectByUserId(userId);
        

        /*ResumeService resumeService = ResumeService.getInstance();
        int resumeNo = Integer.parseInt(req.getParameter("no")); // 이력서 번호를 파라미터로 받음
        Resume resume = resumeService.selectResume(resumeNo);*/
		
        
		//WorkHistoryService workHistoryService = WorkHistoryService.getInstance();
		
		//WorkHistory workHistory = workHistoryService.selectNo(historyNo);
		
		LicenseService licenseService = LicenseService.getInstance();
		String no3 = req.getParameter("no");
		int licenseNo = Integer.parseInt(no3);
		License license = licenseService.selectNo(licenseNo);
		
		req.setAttribute("school", school);
		//req.setAttribute("resume", resume);
		//req.setAttribute("workHistory", workHistory);
		req.setAttribute("license", license);
        req.getRequestDispatcher("/WEB-INF/views/mypage/resumeSetting.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
