package matching;

import java.util.List;

public class ComLicense {
	private String comId;
	private String comLicense;
	
	public ComLicense(String comId, String comLicense) {
		super();
		this.comId = comId;
		this.comLicense = comLicense;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getComLicense() {
		return comLicense;
	}

	public void setComLicense(String comLicense) {
		this.comLicense = comLicense;
	}

	@Override
	public String toString() {
		return "ComLicense [comId=" + comId + ", comLicense=" + comLicense + "]";
	}
	
	
}
