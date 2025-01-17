package myPage;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.Guest0Service;
import member.User;
import member.UserService;
import util.GetCookie;

@WebServlet("/changeUserInfo")
public class ChangeUserInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원 정보 수정 링크 클릭했을 때
		GetCookie co = new GetCookie();
		String userId = co.getCookieUserId(req);
		
		// 로그인한 유저의 개인정보 가져오기
		ResumeService ser = ResumeService.getInstance();
		User user = ser.selectUser(userId);
		req.setAttribute("userInfo", user);
		req.getRequestDispatcher("/WEB-INF/views/mypage/changeUserInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정하기 링크 클릭했을 때
        String userPw = req.getParameter("userPw");
        String pw = req.getParameter("userPwOK");
        String userName = req.getParameter("userName");
        String userBirthStr = req.getParameter("userBirth");
        
        String userPhone = req.getParameter("userPhone");
        String userEmail = req.getParameter("userEmail");
        String userAddress = req.getParameter("userAddress");
        
        GetCookie co = new GetCookie();
		String userId = co.getCookieUserId(req);
		
        // 비밀번호와 비밀번호 확인이 다를 때 
		if (!userPw.equals(pw)) {
            req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            doGet(req, resp);
            return;
        }
		
		// 유저 생일 String -> LocalDate
		LocalDate userBirth = LocalDate.parse(userBirthStr);
		
		// guest 테이블 -> userId로 pw 수정(update)
		Guest0Service ser = Guest0Service.getInstance();
		ser.updateInfo(userId, pw);
		
		// user 테이블 -> userId로 다른 컬럼 수정(update)
		UserService userSer = UserService.getInstance();
		User user = new User(userId, userName, userBirth, userPhone, userEmail, userAddress);
		userSer.updateInfo(user);
		
		// 수정 후 다시 정보보기 테이블로-
		req.getRequestDispatcher("/WEB-INF/views/mypage/userPage.jsp").forward(req, resp);
	}
	
}
