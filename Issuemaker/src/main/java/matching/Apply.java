package matching;

import myPage.Resume;

public class Apply {
	private Notice notice;
	private Resume resume;
	private int view;
	private int result;
	
	public Apply(Notice notice, Resume resume, int view, int result) {
		super();
		this.notice = notice;
		this.resume = resume;
		this.view = view;
		this.result = result;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
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
