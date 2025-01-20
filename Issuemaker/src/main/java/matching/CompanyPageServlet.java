package matching;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GetCookie;

@WebServlet("/companyPage")
public class CompanyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	GetCookie co = GetCookie.getInstance();
    	String comId = co.getCookieUserId(req);
    	
    	CompanyPageService ser = CompanyPageService.getInstance();
    	List<Notice> notice = ser.noticeByComId(comId);
    	req.setAttribute("notice", notice);
    	
    	req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp")
    	.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	super.doPost(req, resp);
    }
}
