package matching;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.GetCookie;


@WebServlet("/noticeNew")
public class NoticeServlet extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/company/noticeNew.jsp")
		.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GetCookie co = new GetCookie();
		String comId = co.getCookieUserId(req);
		
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
        String comLicense = req.getParameter("comLicense");
        
        List<String> comLicenseList = new ArrayList<>();
        if (comLicense != null && !comLicense.isEmpty()) {
            String[] licenses = comLicense.split(",");
            for (String license : licenses) {
                comLicenseList.add(license.trim()); 
            }
        }
        
        ComLicenseService comLicenseSer = ComLicenseService.getInstance();
        
        for (String license : comLicenseList) {
            ComLicense comLicenses = new ComLicense(comId, license); 
            comLicenseSer.insert(comLicenses);
        }

        NoticeService noticeSer = NoticeService.getInstance();
        NoticeForInsert notice = new NoticeForInsert(comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major); 

        noticeSer.insert(notice); 
        
        req.getRequestDispatcher("/WEB-INF/views/company/noticeNew.jsp")
        .forward(req, resp);
    }
}
