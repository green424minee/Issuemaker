package matching;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GetCookie;

@WebServlet("/cancelApply")
public class CancelApplyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
		GetCookie co = GetCookie.getInstance();
		ApplyService ser = ApplyService.getInstance();
		if (ser.deleteApply(noticeNo, co.getCookieUserId(req))) {
			req.setAttribute("result", "지원 취소 완료");
		} else {
			req.setAttribute("result", "지원 취소에 실패했습니다.");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/user/applyResult.jsp").forward(req, resp);
	}
}
