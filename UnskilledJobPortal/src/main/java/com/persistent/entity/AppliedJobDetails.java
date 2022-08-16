package com.persistent.entity;

import java.sql.Date;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.persistent.service.AllAppliedJobService;
//import com.persistent.service.JobService;

public class AppliedJobDetails {

	private int jobId;
	private String aadhar;
	private String category;
	private String owner;
	private Date dateOfPost;
	private String location;
	
	private String status;
		
	public AppliedJobDetails() {
		super();
	}
	public AppliedJobDetails(int jobId, String aadhar, String category, String owner, Date dateOfPost, String status, String location) {
		super();
		this.jobId = jobId;
		this.aadhar = aadhar;
		this.category = category;
		this.owner = owner;
		this.dateOfPost = dateOfPost;
		this.status = status;
		this.location=location;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getDateOfPost() {
		return dateOfPost;
	}
	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AppliedJobDetails [jobId=" + jobId + ", aadhar=" + aadhar + ", category=" + category + ", owner="
				+ owner + ", dateOfPost=" + dateOfPost + ", status=" + status + ", location=" + location + "]";
	}
	
	
	
	
}
