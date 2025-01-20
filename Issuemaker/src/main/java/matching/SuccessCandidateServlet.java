package matching;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GetCookie;

@WebServlet("/successCandidate")
public class SuccessCandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GetCookie co = GetCookie.getInstance();
		String comId = co.getCookieUserId(req);
		
		// apply 테이블에 기업 공고들이 포함된 행
		ApplyService ser = ApplyService.getInstance();
		List<Apply> apply = ser.selectNotices(comId);
		
		req.setAttribute("apply", apply);
		req.getRequestDispatcher("/WEB-INF/views/company/successCandidate.jsp").forward(req, resp);
	}
}
