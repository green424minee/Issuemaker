package myPage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matching.NoticeService;
import member.Company;
import util.GetCookie;

@WebServlet("/changeCompanyInfo")
public class ChangeCompanyInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기업 정보 수정 링크 클릭했을 때
		GetCookie co = new GetCookie();
		String comId = co.getCookieUserId(req);
		
		// 로그인한 기업의 정보 가져오기
		NoticeService ser = NoticeService.getInstance();
		Company com = ser.selectCom(comId);
		req.setAttribute("comInfo", com);
		req.getRequestDispatcher("/WEB-INF/views/company/changeCompanyInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정하기 링크 클릭했을 때
		String pw = req.getParameter("pw");
		String pwAgain = req.getParameter("pwAgain");
		String comName = req.getParameter("comName");
		String comNoStr = req.getParameter("comNo");
		String comPhone = req.getParameter("comPhone");
		String comCeo = req.getParameter("comCeo");
		String managerEmail = req.getParameter("managerEmail");
		String comAddress = req.getParameter("comAddress");
		String comBirthStr = req.getParameter("comBirth"); // comBirth는 문자열로 받아온 후 변환
		String comSizeStr = req.getParameter("comSize"); //
		String comWeb = req.getParameter("comWeb");
		
		GetCookie co = new GetCookie();
		String comid = co.getCookieUserId(req);
		
		// 비밀번호와 비밀번호 확인이 다를 때 
				if (!pw.equals(pwAgain)) {
		            req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
		            doGet(req, resp);
		            return;
		        }
	}
	
}
