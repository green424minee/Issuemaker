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
        GetCookie co = new GetCookie();
        myPageService ser = myPageService.getInstance();
        String user = co.getCookieUserId(req);
        System.out.println(user);
        
		List<Resume> resume = ser.selectResume(user);
		req.setAttribute("resume", resume);
		req.getRequestDispatcher("/WEB-INF/views/company/selectResume.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션 객체 얻기

	}
}
