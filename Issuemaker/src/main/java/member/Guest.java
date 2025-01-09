package member;

public class Guest {
	
	private int no;
	private String id;
	private String pw;
	private int type;
	
	public Guest(int no, String id, String pw, int type) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.type = type;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Guest [no=" + no + ", id=" + id + ", pw=" + pw + ", type=" + type + "]";
	}
	
}
