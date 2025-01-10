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
		System.out.println("사용자 요청 발생: " + req.getRequestURI());
		
		req.getRequestDispatcher("/WEB-INF/views/login/userJoin.jsp")
			.forward(req, resp);
	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userPwOK = request.getParameter("userPwOK");
        String userName = request.getParameter("userName");
        String userBirthStr = request.getParameter("userBirth");
        String userPhone = request.getParameter("userPhone");
        String userEmail = request.getParameter("userEmail");
        String userAddress = request.getParameter("userAddress");
        
        
        
        if (!userPw.equals(userPwOK)) {
            request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            request.getRequestDispatcher("/WEB-INF/views/login/userJoin.jsp")
                .forward(request, response);
            return;
        }
        
        LocalDate userBirth = LocalDate.parse(userBirthStr);
        
        Guest0Service ser = Guest0Service.getInstance();
        ser.insert(userId, userPwOK);
        UserService service = UserService.getInstance();
        User user = new User(userId, userName, userBirth, userPhone, userEmail, userAddress);
        service.insert(user);
        
        
        request.getRequestDispatcher("/WEB-INF/views/login/login.jsp")
            .forward(request, response);
    }
}