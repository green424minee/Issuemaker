package myPage;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userPage")
public class myPageServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if ("user".equals(c.getName())) {
				user = c.getValue();
			}
		}
		
		// 이력서 받아오기
		myPageService ser = myPageService.getInstance();
		List<Resume> resume = ser.selectResume(user);
		req.setAttribute("resume", resume);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
