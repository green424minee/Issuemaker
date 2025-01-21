package search;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matching.Notice;
import matching.NoticeService;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String findType = req.getParameter("findType");
	    String keyword = req.getParameter("keyword");

	    // 직업별 검색
	    if ("1".equals(findType)) {
	        try {
	            JobService jobService = JobService.getInstance();
	            List<Notice> notices = jobService.getJobType(keyword); // 직업별 검색
	            req.setAttribute("jobNotices", notices);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    // 지역별 검색
	    else if ("2".equals(findType)) {
	        try {
	            AreaService areaService = AreaService.getInstance();
	            List<Notice> notices = areaService.getArea(keyword); // 지역별 검색
	            req.setAttribute("areaNotices", notices); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // 검색 결과 JSP로 포워딩
	    req.getRequestDispatcher("/search.jsp").forward(req, resp);
		}

	}

	
