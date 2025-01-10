package myPage;

import matching.Notice;
import member.User;

public class Scrap {
	private User user;
	private Notice notice;
	
	public Scrap(User user, Notice notice) {
		super();
		this.user = user;
		this.notice = notice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Scrap [user=" + user + ", notice=" + notice + "]";
	}
}
