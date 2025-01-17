package matching;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import search.JobMapper;
import util.DBUtil;
import util.GetCookie;


@WebServlet("/noticeNew")
public class NoticeServlet extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try (SqlSession session = DBUtil.getSqlSession()) {
    		JobMapper jobmapper = session.getMapper(JobMapper.class);
    		List <String> jobList = jobmapper.selectAll();
    	
    	
    	
    		req.setAttribute("jobList", jobList);
    		req.getRequestDispatcher("/WEB-INF/views/company/noticeNew.jsp")
    		.forward(req, resp);
    		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GetCookie co = new GetCookie();
		String comId = co.getCookieUserId(req);
		
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        LocalDate postDate = LocalDate.parse(req.getParameter("postDate"));
        LocalDate deadLine = LocalDate.parse(req.getParameter("deadLine"));
        String salaryParam = req.getParameter("salary");
        Integer salary = (salaryParam != null && !salaryParam.isEmpty()) ? Integer.parseInt(salaryParam) : null;
        String jobType = req.getParameter("jobType");
        String exTermParam = req.getParameter("exTerm");
        Integer exTerm =(exTermParam != null && !exTermParam.isEmpty()) ? Integer.parseInt(exTermParam) : null;
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
        
        req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp")
        .forward(req, resp);
    }
}
