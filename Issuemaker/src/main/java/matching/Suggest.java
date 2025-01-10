package matching;

import member.Company;
import member.User;

public class Suggest {
	private int no;
	private Company company;
	private User user;
	
	public Suggest(int no, Company company, User user) {
		super();
		this.no = no;
		this.company = company;
		this.user = user;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Suggest [no=" + no + ", company=" + company + ", user=" + user + "]";
	}
}
