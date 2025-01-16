package matching;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/noticeSetting")
public class NoticeSettingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");
      
        NoticeService service = NoticeService.getInstance();
        Notice notice = service.getNoticeByNo(no); 
        
        req.setAttribute("notice", notice);
        req.getRequestDispatcher("/WEB-INF/views/company/noticeSetting.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String no = req.getParameter("no");
        String context = req.getParameter("context");
        String deadLineStr = req.getParameter("deadLine");
        
        System.out.println(deadLineStr);
        LocalDate deadLine = LocalDate.parse(deadLineStr);
     
        NoticeService ser = NoticeService.getInstance();
        Notice existingNotice = ser.getNoticeByNo(no);
        
        existingNotice.setContext(context);
        existingNotice.setDeadLine(deadLine);
        
        ser.update(existingNotice);
        
        req.setAttribute("notice", existingNotice);
        req.getRequestDispatcher("/WEB-INF/views/company/noticeDetail.jsp").forward(req, resp);
    }

}


