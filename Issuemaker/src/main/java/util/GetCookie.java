package util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import matching.NoticeService;

public class GetCookie {
	public String getCookieUserId(HttpServletRequest req) {
		Cookie[] cookie = req.getCookies();
		if (cookie != null) {
			for (Cookie c : cookie) {
				if ("user".equals(c.getName())) {
					return c.getValue();
				} 
			}
		}
		return null;
	}
	
	public int getCookieUserType(HttpServletRequest req) {
		NoticeService ser = NoticeService.getInstance();
		int check = 2;
		Cookie[] cookie = req.getCookies();
		if (cookie != null) {
			for (Cookie c : cookie) {
				if ("user".equals(c.getName())) {
					check = ser.getType(c.getValue());
				} 
			}
		}
		return check;
	}
}
