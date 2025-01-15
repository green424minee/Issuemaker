package search;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matching.Notice;
import matching.NoticeForInsert;
import matching.NoticeService;
import member.Company;
import member.CompanyService;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IndexService ser = IndexService.getInstance();
		
		List<Notice> notice = ser.getNoticeByAll();
		req.setAttribute("notice", notice);

	    
		req.getRequestDispatcher("/index.jsp")
		.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("noticeNo");
	    resp.sendRedirect("/noticeDetail?noticeNo=" + no);
		
	}
	
	

}
