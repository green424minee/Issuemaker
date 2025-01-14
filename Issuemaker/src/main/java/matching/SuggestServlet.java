package matching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/suggest")
public class SuggestServlet extends HttpServlet{
	SuggestService ser = SuggestService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if ("user".equals(c.getName())) {
				user = c.getValue();
			}
		}
		
		List<Suggest> sugList = null;
		sugList = ser.selectSuggest(user);  // user가 제안받은 suggest
		
		System.out.println(sugList);
		req.setAttribute("sugList", sugList);
		req.getRequestDispatcher("WEB-INF/views/mypage/suggest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("#");  // 기업별 공고 리스트페이지
	}
}
