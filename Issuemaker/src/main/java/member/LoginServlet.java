package member;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	LoginService ser = LoginService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		List<String> idList = ser.selectId();
		List<String> pwList = ser.selectPw();
		
		if (idList.contains(id) && pwList.contains(pw)){
			Cookie cookie = new Cookie("user", id);
			//cookie.setMaxAge(30 * 60); // 30분 동안 유지
			resp.addCookie(cookie);
			// 기업/개인 나누기
			int type = ser.selectType(id);
			if (type == 0) {
				resp.sendRedirect("/userPage");  // 마이페이지 메인홈(이력서 관리)
			} else {
				resp.sendRedirect("#");  // 기업 메인홈
			}
		} else {                      // 마이페이지로 이동
			req.setAttribute("error", "아이디와 비밀번호를 확인해주세요.");
			doGet(req, resp);//
		}
	}
	
	
}
