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
		String typeStr = req.getParameter("type"); // 개인 or 기업
		int type = ("개인회원".equals(typeStr)) ? 0 : 1;
		System.out.println(type);
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Guest guest = ser.selectGuest(id);
		if (guest == null) {
			req.setAttribute("error", "아이디를 확인해주세요.");
			doGet(req, resp);
		} else {
			if (!guest.getPw().equals(pw)) {
				req.setAttribute("error", "비밀번호를 확인해주세요.");
				doGet(req, resp);
			} else if (guest.getPw().equals(pw) && guest.getType() == type) {
				Cookie cookie = new Cookie("user", id);
				//cookie.setMaxAge(30 * 60); // 30분 동안 유지
				resp.addCookie(cookie);
				if (type == 0) {
					resp.sendRedirect("/userPage"); // 마이페이지
				} else {
					resp.sendRedirect("/companyPage");  // 기업 메인페이지
				}
			} else {
				req.setAttribute("error", "회원 종류를 확인해주세요.");
				doGet(req, resp);
			}
		}
		
		/*
		if (idList.contains(id) && pwList.contains(pw)){
			Cookie cookie = new Cookie("user", id);
			//cookie.setMaxAge(30 * 60); // 30분 동안 유지
			resp.addCookie(cookie);
			// 기업/개인 나누기
			type = ser.selectType(id);
			if (type == 0) {
				resp.sendRedirect("/userPage");  // 마이페이지 메인홈(이력서 관리)
			} else {
				resp.sendRedirect("#");  // 기업 메인홈
			}
		} else {                      // 마이페이지로 이동
			
		}
		*/
	}
	
	
}
