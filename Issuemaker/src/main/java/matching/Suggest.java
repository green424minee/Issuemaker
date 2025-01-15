package matching;

import java.time.LocalDate;

import member.Company;
import member.User;

public class Suggest {
	SuggestService ser = SuggestService.getInstance();
	
	private int no;
	private String company;
	private String user;
	private LocalDate suggestDate;
	
	private String comName;
	
	public Suggest(int no, String company, String user, LocalDate suggestDate) {
		super();
		this.no = no;
		this.company = company;
		this.user = user;
		this.suggestDate = suggestDate;
		comName = ser.selectComName(company);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return comName + " " + suggestDate;
	}
}
