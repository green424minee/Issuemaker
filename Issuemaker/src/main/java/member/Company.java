package member;

import java.sql.Date;

public class Company {
	
	private String comId;
	private String comName;
	private long comNo;
	private String comPhone;
	private String comCeo;
	private String managerEmail;
	private String comAddress;
	private Date comBirth;
	private int comSize;
	private String comWeb;
	
	public Company(String comId, String comName, long comNo, String comPhone, String comCeo, String managerEmail,
			String comAddress, Date comBirth, int comSize, String comWeb) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.comNo = comNo;
		this.comPhone = comPhone;
		this.comCeo = comCeo;
		this.managerEmail = managerEmail;
		this.comAddress = comAddress;
		this.comBirth = comBirth;
		this.comSize = comSize;
		this.comWeb = comWeb;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public long getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public String getComPhone() {
		return comPhone;
	}
	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	public String getComCeo() {
		return comCeo;
	}
	public void setComCeo(String comCeo) {
		this.comCeo = comCeo;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getComAddress() {
		return comAddress;
	}
	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	public Date getComBirth() {
		return comBirth;
	}
	public void setComBirth(Date comBirth) {
		this.comBirth = comBirth;
	}
	public int getComSize() {
		return comSize;
	}
	public void setComSize(int comSize) {
		this.comSize = comSize;
	}
	public String getComWeb() {
		return comWeb;
	}
	public void setComWeb(String comWeb) {
		this.comWeb = comWeb;
	}
	@Override
	public String toString() {
		return "Company [comId=" + comId + ", comName=" + comName + ", comNo=" + comNo + ", comPhone=" + comPhone
				+ ", comCeo=" + comCeo + ", managerEmail=" + managerEmail + ", comAddress=" + comAddress + ", comBirth="
				+ comBirth + ", comSize=" + comSize + ", comWeb=" + comWeb + "]";
	}
	
	

}
