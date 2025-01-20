package matching;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/accepted")	// 합격
public class AcceptedServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer noticeNo = Integer.parseInt(req.getParameter("notice"));
		Integer resumeNo = Integer.parseInt(req.getParameter("resume"));
		
		// Apply.result = 1로 변경
		ApplyService ser = ApplyService.getInstance();
		ser.updateResult1(noticeNo, resumeNo);
		
		resp.sendRedirect("/applicant");
	}
}
