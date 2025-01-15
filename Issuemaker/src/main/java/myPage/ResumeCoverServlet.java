package myPage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cover")
public class ResumeCoverServlet extends HttpServlet {
    ResumeService ser = ResumeService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("resumeNo");
        int resumeNo = Integer.parseInt(no);
        
        Resume resume = ser.selectResume(resumeNo);
        System.out.println(resume);
        byte[] coverLetter = resume.getCoverLetter();
        System.out.println(coverLetter);
        
        String id = resume.getUserId();
        String userName = ser.selectUserName(id);
                
        if (coverLetter != null) {
        	// 응답 헤더 설정
        	resp.setContentType("application/pdf");
        	String encodedFileName = URLEncoder.encode(userName + "_자기소개서.pdf", "UTF-8");
        	resp.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
        	resp.setContentLength(coverLetter.length);
        	resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        	resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        	resp.setDateHeader("Expires", 0); // Proxies.

        	// 응답에 데이터 쓰기
        	try (OutputStream out = resp.getOutputStream()) {
        	    out.write(coverLetter);
        	    out.flush();
        	} catch (IOException e) {
        	    e.printStackTrace(); // 예외 처리
        	}

        } else {
            // 오류 메시지를 설정하고, 원래 페이지로 돌아감
        	req.getSession().setAttribute("errorcover", "등록된 자기소개서가 없습니다.");
        	resp.sendRedirect("/resume?resumeNo=" + resumeNo);
            //req.getRequestDispatcher("/resume?resumeNo=" + resumeNo).forward(req, resp);
        }
    }
}
