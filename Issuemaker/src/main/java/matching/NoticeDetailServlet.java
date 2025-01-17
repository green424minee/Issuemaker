package matching;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.Company;
import member.CompanyService;
import util.GetCookie;

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
        
        
        String comLicense = notice.getComLicense(); 
        String[] licenses = comLicense.split(", "); 
        
      
        
        req.setAttribute("notice", notice); 
        req.setAttribute("company", company);
        req.setAttribute("licenses", licenses); 
        
        GetCookie co = new GetCookie();
        String currentComId = co.getCookieUserId(req);
        req.setAttribute("currentComId", currentComId); 
        
        req.getRequestDispatcher("/WEB-INF/views/company/noticeDetail.jsp")
        .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetCookie co = new GetCookie();
        String action = req.getParameter("action");
        String noticeNo = req.getParameter("noticeNo");
        
        String currentComId = co.getCookieUserId(req);
        
        NoticeService noticeService = NoticeService.getInstance();
        Notice notice = noticeService.getNoticeByNo(noticeNo);
        
        if (notice != null) {
            String noticeComId = notice.getComId();
            
            if (action.equals("수정")) {
                if (noticeComId.equals(currentComId)) {
                    resp.sendRedirect("/noticeSetting?no=" + noticeNo);
                } else {
                    req.setAttribute("errorMessage", "수정 권한이 없습니다.");
                    req.getRequestDispatcher("/WEB-INF/views/companyDetail.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("errorMessage", "공지사항을 찾을 수 없습니다.");
            req.getRequestDispatcher("/WEB-INF/views/companyPage.jsp").forward(req, resp);
        }
    }
}
