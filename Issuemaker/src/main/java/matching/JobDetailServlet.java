package matching;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import search.JobService;

@WebServlet("/jobDetail")
public class JobDetailServlet extends HttpServlet {
	JobService ser = JobService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job = req.getParameter("job");
		req.setAttribute("job", job);
		
		List<Notice> noticeList = ser.getNotice(job);
		req.setAttribute("noticeList", noticeList);
		
		req.getRequestDispatcher("/jobDetail.jsp").forward(req, resp);
	}
	
	
}
