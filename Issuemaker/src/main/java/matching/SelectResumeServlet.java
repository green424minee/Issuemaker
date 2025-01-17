package matching;

import java.io.IOException;
import java.util.List;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPage.Resume;
import myPage.myPageService;
import util.GetCookie;

@WebServlet("/selectResume")
public class SelectResumeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String user = req.getParameter("user");
		String noticeNo = req.getParameter("noticeNo");
		GetCookie co = new GetCookie();
		String user = co.getCookieUserId(req);
        myPageService ser = myPageService.getInstance();
		List<Resume> resume = ser.selectResume(user);
		req.setAttribute("noticeNo", noticeNo);
		req.setAttribute("resume", resume);
		req.getRequestDispatcher("/WEB-INF/views/company/selectResume.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 선택한 이력서
		String noticeNo = req.getParameter("noticeNo");  // 지원하는 공고 번호
		int notice = Integer.parseInt(noticeNo);
		String resumeNo = req.getParameter("resumeNo");  // 지원할 이력서
		int resume = Integer.parseInt(resumeNo);
		
		// apply 테이블에 값 넣기
		ApplyService ser = ApplyService.getInstance();
		ser.insertApply(notice, resume);
		
		req.getRequestDispatcher("/WEB-INF/views/user/applyResult.jsp").forward(req, resp);
	}
}
