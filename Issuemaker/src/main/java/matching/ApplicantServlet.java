package matching;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GetCookie;

@WebServlet("/applicant")
public class ApplicantServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GetCookie co = GetCookie.getInstance();
		String comId = co.getCookieUserId(req);
		
		// 기업에 지원한 이력서들
		NoticeService ser = NoticeService.getInstance();
		List<Apply> notices = ser.getResumeByNotice(comId);
		req.setAttribute("notice", notices);
		
		req.getRequestDispatcher("/WEB-INF/views/company/applicant.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
