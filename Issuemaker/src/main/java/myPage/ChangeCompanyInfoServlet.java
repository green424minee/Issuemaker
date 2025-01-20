package myPage;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matching.NoticeService;
import member.Company;
import member.CompanyService;
import member.Guest0Service;
import member.Guest1Service;
import util.GetCookie;

@WebServlet("/changeCompanyInfo")
public class ChangeCompanyInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기업 정보 수정 링크 클릭했을 때
		GetCookie co = GetCookie.getInstance();
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
		String otherAddress = req.getParameter("otherAddress");
		String comBirthStr = req.getParameter("comBirth"); // comBirth는 문자열로 받아온 후 변환
		String comSizeStr = req.getParameter("comSize"); //
		String comWeb = req.getParameter("comWeb");
		
		GetCookie co = GetCookie.getInstance();
		String comId = co.getCookieUserId(req);
		
		// 비밀번호와 비밀번호 확인이 다를 때 
		if (!pw.equals(pwAgain)) {
			req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
			doGet(req, resp);
			return;
		}
		
		long comNo = 0;
	    LocalDate comBirth = null;
	    int comSize = 0;
		
	    try {
	        comNo = Long.parseLong(comNoStr);  // comNo를 long 타입으로 변환
	        comBirth = LocalDate.parse(comBirthStr);  // comBirth를 LocalDate 타입으로 변환
	        comSize = Integer.parseInt(comSizeStr);  // comSize를 int 타입으로 변환
	    } catch (NumberFormatException e) {
	        req.setAttribute("errorMessage", "Invalid input for company number, birth date, or company size.");
	        req.getRequestDispatcher("/WEB-INF/views/login/changeCompanyInfo.jsp").forward(req, resp);
	        return;
	    }
	    
	    // guest 테이블 -> comId로 pw 수정(update)
	    Guest1Service ser1 = Guest1Service.getInstance();
	    int num1 = ser1.updateInfo(comId, pwAgain);
	    System.out.println(num1);
	    // company 테이블 -> comId로 다른 컬럼 수정(update)
	    CompanyService sercom = CompanyService.getInstance();
	    Company company = new Company(comId, comName, comNo, comPhone, comCeo, managerEmail, comAddress, otherAddress, comBirth, comSize, comWeb);
	    int num2 = sercom.update(company);
	    System.out.println(num2);
	    // 수정 후 다시 정보보기 테이블로-
	    req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp").forward(req, resp);
	}
}
