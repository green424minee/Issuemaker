package myPage;

import member.Company;
import member.User;

public class FavorCompany {
	private User user;
	private Company company;
	public FavorCompany(User user, Company company) {
		super();
		this.user = user;
		this.company = company;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "FavorCompany [user=" + user + ", company=" + company + "]";
	}
}
