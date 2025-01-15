package matching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import search.AreaService;

@WebServlet("/areaDetail")
public class AreaDetailServlet extends HttpServlet {
	AreaService ser = AreaService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String area = req.getParameter("area");
		req.setAttribute("area", area);
		
		// 각 회사의 주소 앞글자가 area와 같은 회사의 공고 리스트
		List<Notice> noticeList = ser.getComId(area);
		req.setAttribute("noticeList", noticeList);
		
		
		req.getRequestDispatcher("/areaDetail.jsp").forward(req, resp);
	}
}
