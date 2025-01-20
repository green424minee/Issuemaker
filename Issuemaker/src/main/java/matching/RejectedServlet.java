package matching;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rejected")	// 불합격
public class RejectedServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer noticeNo = Integer.parseInt(req.getParameter("notice"));
		Integer resumeNo = Integer.parseInt(req.getParameter("resume"));
		
		// Apply.result = 2로 변경
		ApplyService ser = ApplyService.getInstance();
		ser.updateResult2(noticeNo, resumeNo);
		
		resp.sendRedirect("/applicant");
	}
}
