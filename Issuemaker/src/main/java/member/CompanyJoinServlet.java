package member;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/companyJoin")
public class CompanyJoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/companyJoin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comId = req.getParameter("comId");
		String pw = req.getParameter("pw");
		String pwAgain = req.getParameter("pwAgain");
		String comName = req.getParameter("comName");
		String comNoStr = req.getParameter("comNo");
		String comPhone = req.getParameter("comPhone");
		String comCeo = req.getParameter("comCeo");
		String managerEmail = req.getParameter("managerEmail");
		String comAddress = req.getParameter("comAddress");
		String comBirthStr = req.getParameter("comBirth"); // comBirth는 문자열로 받아온 후 변환
		String comSizeStr = req.getParameter("comSize"); //
		String comWeb = req.getParameter("comWeb");
		
		
		 if (!pw.equals(pwAgain)) {
	            req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
	            req.getRequestDispatcher("/WEB-INF/views/login/CompanyJoin.jsp")
	                .forward(req, resp);
	            return;
	        }
		
		long comNo = 0;
	    LocalDate comBirth = null;
	    int comSize = 0;
		
	    try {
	        comNo = Long.parseLong(comNoStr);  // comNo를 long 타입으로 변환
	        comBirth = LocalDate.parse(comBirthStr);  // comBirth를 LocalDate 타입으로 변환
	        comSize = Integer.parseInt(comSizeStr);  // comSize를 int 타입으로 변환
	    } catch (NumberFormatException e) {
	        req.setAttribute("error", "Invalid input for company number, birth date, or company size.");
	        req.getRequestDispatcher("/WEB-INF/views/login/companyJoin.jsp").forward(req, resp);
	        return;
	    }
	    
        Guest1Service ser = Guest1Service.getInstance();
        ser.insert(comId, pwAgain);
	    
	    Company company = new Company(comId, comName, comNo, comPhone, comCeo, managerEmail, comAddress, comBirth, comSize, comWeb);
	    CompanyService service = CompanyService.getInstance();
	    service.insert(company);
		  
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
	
}
