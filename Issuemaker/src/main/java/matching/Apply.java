package matching;

import myPage.Resume;

public class Apply {
	private int notice;
	private int resume;
	private int view;
	private int result;
	
	public Apply(int notice, int resume, int view, int result) {
		super();
		this.notice = notice;
		this.resume = resume;
		this.view = view;
		this.result = result;
	}

	public Resume getResumeDetail() {
		NoticeService ser = NoticeService.getInstance();
		return ser.getResume(resume);
	}
	public Notice getNoticeDetail() {
		NoticeService ser = NoticeService.getInstance();
		return ser.getNotice(notice);
	}
	
	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	public int getResume() {
		return resume;
	}

	public void setResume(int resume) {
		this.resume = resume;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Apply [notice=" + notice + ", resume=" + resume + ", view=" + view + ", result=" + result + "]";
	}
	
}
