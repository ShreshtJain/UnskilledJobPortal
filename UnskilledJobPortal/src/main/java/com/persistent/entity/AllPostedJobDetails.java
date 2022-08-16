package com.persistent.entity;

public class AllPostedJobDetails {
	
	private String jobId;
	
	private String categoryName;
	
	private String workArea;
	
	private String workDescription;
	
	private String status;

	private String dateOfPost;
	
	private String lastDate;
	
	private String jobType;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(String dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public AllPostedJobDetails() {
		super();
	}

	public AllPostedJobDetails(String jobId, String categoryName, String workArea, String workDescription,
			String status, String dateOfPost, String lastDate, String jobType) {
		super();
		this.jobId = jobId;
		this.categoryName = categoryName;
		this.workArea = workArea;
		this.workDescription = workDescription;
		this.status = status;
		this.dateOfPost = dateOfPost;
		this.lastDate = lastDate;
		this.jobType = jobType;
	}

	@Override
	public String toString() {
		return "AllPostedJobDetails [jobId=" + jobId + ", categoryName=" + categoryName + ", workArea=" + workArea
				+ ", workDescription=" + workDescription + ", status=" + status + ", dateOfPost=" + dateOfPost
				+ ", lastDate=" + lastDate + ", jobType=" + jobType + "]";
	}
	
	
	

}
