package myPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matching.Apply;
import matching.Notice;

@WebServlet("/noticeList")
public class NoticeListServlet extends HttpServlet {
	NoticeListService ser = NoticeListService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if ("user".equals(c.getName())) {
				user = c.getValue();
			}
		}
		
		List<Integer> resumeNo = ser.selectResumeNo(user);  // user의 이력서 일련번호
		List<Notice> noticeList = new ArrayList<>();
		for (Integer a : resumeNo) {
		    List<Integer> noticeNo = ser.selectApply(a); // 이력서 일련번호가 포함된 행의 공고번호
		    for (Integer b : noticeNo) {
		        Notice notice = ser.selectNotice(b);
		       //int view = ser.selectView(b, a); // 열람여부
		        
		        System.out.println(notice);
		        if (notice != null) {
		            noticeList.add(notice);
		        }
		    }
		}
		req.setAttribute("noticeList", noticeList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/noticeList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
