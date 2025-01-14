package member;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/companyPage")
public class CompanyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comId = req.getParameter("comId");
      
        CompanyService service = CompanyService.getInstance();
        Company company = service.getCompanyById(comId); 
        
        req.setAttribute("company", company);
        req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comId = "test"; 
/*	      Cookie[] cookies = req.getCookies();
	      for (Cookie c : cookies) {
	         if ("user".equals(c.getName())) {
	            comId = c.getValue();
	         }
	      }
*/
        String comPhone = req.getParameter("comPhone");
        String managerEmail = req.getParameter("managerEmail");
        String comAddress = req.getParameter("comAddress");
        String comSizeStr = req.getParameter("comSize");
        String comWeb = req.getParameter("comWeb");

        int comSize = 0;

        try {
            comSize = Integer.parseInt(comSizeStr);
        } catch (NumberFormatException e) {
           
            req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp").forward(req, resp);
            return;
        }

        CompanyService service = CompanyService.getInstance();
        Company existingCompany = service.getCompanyById(comId); 

        existingCompany.setComPhone(comPhone);
        existingCompany.setManagerEmail(managerEmail);
        existingCompany.setComAddress(comAddress);
        existingCompany.setComSize(comSize);
        existingCompany.setComWeb(comWeb);

        service.update(existingCompany);

        req.setAttribute("company", existingCompany);
        req.getRequestDispatcher("/WEB-INF/views/company/companyPage.jsp").forward(req, resp);
    }
}
