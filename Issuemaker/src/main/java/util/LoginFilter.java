package util;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/userPage", "/noticeList", "/suggest", "/selectResume"})
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest httpreq = (HttpServletRequest) request;
	        HttpServletResponse httpresp = (HttpServletResponse) response;

	        // 쿠키 가져오기
	        Cookie[] cookies = httpreq.getCookies();
	        boolean isLoggedIn = false;

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if ("user".equals(cookie.getName())) { // 쿠키 이름 확인
	                    isLoggedIn = true;
	                    break;
	                }
	            }
	        }

	        // 로그인 상태에 따라 필터링
	        if (isLoggedIn) {
	            chain.doFilter(request, response); // 로그인 상태이면 계속 진행
	        } else {
	            httpresp.sendRedirect("/login"); // 로그인 페이지로 리다이렉트
	        }
	}
}
