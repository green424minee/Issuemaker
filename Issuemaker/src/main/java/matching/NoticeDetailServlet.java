package matching;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.Company;
import member.CompanyService;

@WebServlet("/noticeDetail")
public class NoticeDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
	    NoticeService noticeService = NoticeService.getInstance();
	    Notice notice = noticeService.getNoticeByNo(noticeNo); 
	    
	    String comId = notice.getComId();
	    CompanyService companyService = CompanyService.getInstance();
	    Company company = companyService.getCompanyBycomId(comId);
	    

	    req.setAttribute("notice", notice); 
	    req.setAttribute("company", company);
	    
		req.getRequestDispatcher("/WEB-INF/views/company/noticeDetail.jsp")
		.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("/noticeSetting");
	}
}
