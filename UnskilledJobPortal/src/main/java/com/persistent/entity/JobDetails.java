package com.persistent.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.service.CategoryService;

@Entity
@Table(name="JOB_DETAILS")
public class JobDetails {

	@Id
	@Column(name="JOB_ID" , columnDefinition = "NUMBER")
	private int jobId;
	
	@Column(name = "AADHAR_NO" , columnDefinition = "VARCHAR2 (12)")
	private String aadharNo;
	
	@Column(name = "CATEGORY_ID" , columnDefinition = "NUMBER")
	private int categoryId;
	
	@Column(name = "WORK_STATE" , columnDefinition = "VARCHAR2 (30)")
	private String  workState;
	
	@Column(name = "WORK_CITY" , columnDefinition = "VARCHAR2 (30)")
	private String workCity;
	
	@Column(name = "WORK_PINCODE" , columnDefinition = "VARCHAR2 (6)")
	private String workPincode;
	
	@Column(name = "WORK_AREA" , columnDefinition = "VARCHAR2 (50)")
	private String workArea;
	
	@Column(name = "WORK_DESCRIPTION" , columnDefinition = "VARCHAR2 (1000)")
	private String workDescription;
	
	@Column(name="IS_ACTIVE" , columnDefinition = "VARCHAR2(1)  DEFAULT 'T'")
	private boolean isActive;
	
	@Column(name = "ESTIMATED_COST" , columnDefinition = "NUMBER (7)")
	private int estimatedCost;
	
	@Column(name="DATE_OF_POST" , columnDefinition = "DATE DEFAULT SYSDATE" )
	private Date dateOfPost;
	
	@Column(name = "LAST_DATE" , columnDefinition = "DATE ")
	private Date lastDate;
	
	@Column(name = "JOB_TYPE" , columnDefinition = "VARCHAR2 (30)")
	private String jobType;
	
	@Column(name = "JOB_ASSIGNED_TO" , columnDefinition = "VARCHAR2 (12)")
	private String jobAssignedTo;

	public JobDetails() {
		super();
	}

	public JobDetails(int jobId, String aadharNo, int categoryId, String workState, String workCity, String workPincode,
			String workArea, String workDescription, boolean isActive, int estimatedCost, Date dateOfPost,
			Date lastDate, String jobType, String jobAssignedTo) {
		super();
		this.jobId = jobId;
		this.aadharNo = aadharNo;
		this.categoryId = categoryId;
		this.workState = workState;
		this.workCity = workCity;
		this.workPincode = workPincode;
		this.workArea = workArea;
		this.workDescription = workDescription;
		this.isActive = isActive;
		this.estimatedCost = estimatedCost;
		this.dateOfPost = dateOfPost;
		this.lastDate = lastDate;
		this.jobType = jobType;
		this.jobAssignedTo = jobAssignedTo;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkPincode() {
		return workPincode;
	}

	public void setWorkPincode(String workPincode) {
		this.workPincode = workPincode;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobAssignedTo() {
		return jobAssignedTo;
	}

	public void setJobAssignedTo(String jobAssignedTo) {
		this.jobAssignedTo = jobAssignedTo;
	}
	
//	@Autowired
//	CategoryService service;
//	
//	public String getCategoryNameById()
//	{
//		
//		return service.getCategoryById(this.getCategoryId());
//	}
	

	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", aadharNo=" + aadharNo + ", categoryId=" + categoryId + ", workState="
				+ workState + ", workCity=" + workCity + ", workPincode=" + workPincode + ", workArea=" + workArea
				+ ", workDescription=" + workDescription + ", isActive=" + isActive + ", estimatedCost=" + estimatedCost
				+ ", dateOfPost=" + dateOfPost + ", lastDate=" + lastDate + ", jobType=" + jobType + ", jobAssignedTo="
				+ jobAssignedTo + "]";
	}
	
	
	
	
}
