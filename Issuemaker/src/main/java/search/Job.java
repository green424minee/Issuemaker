package search;

public class Job {
	private String jobType;

	public Job(String jobType) {
		super();
		this.jobType = jobType;
	}
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Override
	public String toString() {
		return "Job [jobType=" + jobType + "]";
	}
	
}
