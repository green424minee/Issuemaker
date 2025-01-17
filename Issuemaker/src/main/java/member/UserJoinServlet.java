package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userJoin")
public class UserJoinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/userJoin.jsp")
			.forward(req, resp);
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String userPwOK = req.getParameter("userPwOK");
        String userName = req.getParameter("userName");
        String userBirthStr = req.getParameter("userBirth");
        String userPhone = req.getParameter("userPhone");
        String userEmail = req.getParameter("userEmail");
        String userAddress = req.getParameter("userAddress");
        
        
        
        if (!userPw.equals(userPwOK)) {
            req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            req.getRequestDispatcher("/WEB-INF/views/login/userJoin.jsp")
                .forward(req, resp);
            return;
        }
        
        LocalDate userBirth = LocalDate.parse(userBirthStr);
        
        Guest0Service ser = Guest0Service.getInstance();
        ser.insert(userId, userPwOK);
        
        UserService service = UserService.getInstance();
        User user = new User(userId, userName, userBirth, userPhone, userEmail, userAddress);
        service.insert(user);
        
        
        resp.sendRedirect("/login");
    }
}