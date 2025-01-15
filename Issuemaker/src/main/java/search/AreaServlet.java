package search;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/area")
public class AreaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    AreaService ser = AreaService.getInstance();
	    
	
	    List<String> areaName = ser.getAreaByAll();
	    
	    req.setAttribute("area", areaName);
	    req.getRequestDispatcher("/area.jsp")
	       .forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.sendRedirect("/areaDetail");
	}
	
	

}
