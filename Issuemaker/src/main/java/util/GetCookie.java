package util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import matching.NoticeService;
import matching.SuggestService;

public class GetCookie {
	private static final GetCookie instance = new GetCookie();
	private GetCookie() {}
	
	public static GetCookie getInstance() {
		return instance;
	}
	
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
