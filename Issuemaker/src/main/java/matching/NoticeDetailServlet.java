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
		String noticeNo = req.getParameter("no"); 
	    NoticeService noticeService = NoticeService.getInstance();
	    Notice notice = noticeService.getNoticeByNo(noticeNo); 
	    
	    String comId = req.getParameter("comId");
	    CompanyService companyService = CompanyService.getInstance();
	    Company company = companyService.getCompanyBycomId(comId);
	    

	    req.setAttribute("notice", notice); 
	    req.setAttribute("company", company);
	    
		req.getRequestDispatcher("/WEB-INF/views/company/noticeDetail.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comId = "test";
/*	      Cookie[] cookies = req.getCookies();
	      for (Cookie c : cookies) {
	         if ("user".equals(c.getName())) {
	            comId = c.getValue();
	         }
	      }
*/
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        LocalDate postDate = LocalDate.parse(req.getParameter("postDate"));
        LocalDate deadLine = LocalDate.parse(req.getParameter("deadLine"));
        Integer salary = req.getParameter("salary") != null ? Integer.parseInt(req.getParameter("salary")) : null;
        String jobType = req.getParameter("jobType");
        Integer exTerm = req.getParameter("exTerm") != null ? Integer.parseInt(req.getParameter("exTerm")) : null;
        String workday = req.getParameter("workday");
        int type = Integer.parseInt(req.getParameter("type"));
        int schoolLevel = Integer.parseInt(req.getParameter("schoolLevel"));
        String major = req.getParameter("major");
        
        String comName = req.getParameter("comName");
        String comLicense = req.getParameter("comLicense");
        
        NoticeService noticeSer = NoticeService.getInstance();
        Notice notice = new Notice(comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major);
        noticeSer.insert(notice);
        
        CompanyService companySer = CompanyService.getInstance();
        Company company = new Company(comId, comName, 0, null, null, null, null, null, 0, null); 
        companySer.insert(company);
        
        ComLicenseService comLicenseSer = ComLicenseService.getInstance();
        ComLicense comLicenses = new ComLicense(comId, comLicense);
        comLicenseSer.insert(comLicenses);
		
		
	    req.setAttribute("notice", notice); 
	    req.setAttribute("company", company);
	    req.setAttribute("comLicense", comLicense);
//		resp.sendRedirect(req.getContextPath() + "/noticeDetail?no=" + notice.getNo() + "&comId=" + comId);
		req.getRequestDispatcher("/WEB-INF/views/company/noticeDetail.jsp")
		.forward(req, resp);
	}
	

}
