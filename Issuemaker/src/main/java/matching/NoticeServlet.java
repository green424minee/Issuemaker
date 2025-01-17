package matching;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
            List<String> jobList = jobmapper.selectAll();
            req.setAttribute("jobList", jobList);
            req.getRequestDispatcher("/WEB-INF/views/company/noticeNew.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "An error occurred while retrieving job list.");
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetCookie co = new GetCookie();
        String comId = co.getCookieUserId(req);
        
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        LocalDate postDate = LocalDate.parse(req.getParameter("postDate"));
        LocalDate deadLine = LocalDate.parse(req.getParameter("deadLine"));
        Integer salary = parseInteger(req.getParameter("salary"));
        String jobType = req.getParameter("jobType");
        Integer exTerm = parseInteger(req.getParameter("exTerm"));
        String workday = req.getParameter("workday");
        Integer type = Integer.parseInt(req.getParameter("type"));
        Integer schoolLevel = Integer.parseInt(req.getParameter("schoolLevel"));
        String major = req.getParameter("major");
        
        // comLicense 처리
        String comLicense = req.getParameter("comLicense");
        List<String> comLicenseList = new ArrayList<>();
        if (comLicense != null && !comLicense.trim().isEmpty()) {
            String[] licenses = comLicense.split(",");
            for (String license : licenses) {
                comLicenseList.add(license.trim());
            }
        }
        
        // comLicenseList가 비어있지 않으면 null이 아닌 값으로 설정
        String com = comLicenseList.isEmpty() ? null : String.join(", ", comLicenseList);

        if (major != null && major.trim().isEmpty()) {
            major = null;
        }
        
        NoticeService noticeSer = NoticeService.getInstance();   
        NoticeForInsert notice = new NoticeForInsert(comId, title, context, postDate, deadLine, salary, jobType, exTerm, workday, type, schoolLevel, major, com);
        noticeSer.insert(notice);
        resp.sendRedirect(req.getContextPath() + "/companyPage");
    }
    

    private Integer parseInteger(String param) {
	        if (param != null && !param.isEmpty()) {
	            return Integer.parseInt(param);
	        }
	        return null;
	    }
}
