package com.persistent.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class PostJobForm {	
	
	@NotBlank(message = "Please select the work category")
	private String categoryId ;
	
	@NotBlank(message="Please select the work State")
	 private String workState;
	
	@NotBlank(message = "Please enter work city name" )
	private String workCity;
	
	@Min(value=100000, message = "Please enter valid pincode" )
	@Max(value=999999, message = "Please enter valid pincode" )
	private int workPincode;
	
	@NotBlank(message="Please enter the Work Area")
	private String workArea;
	
	@Size(min=15, max = 900,message = "Please enter a work description of 15 letters or more" )
	private String workDescription;
	
	@Min(value = 1, message = "Please enter the cost more than or equal to 100")
	private int estimatedCost;
	
	@NotBlank(message="Please enter the deadline")
	private String lastDate ;
	
	@NotBlank(message = "Please choose job type" )
	private String jobType ;
	 
	 
	 
	public PostJobForm() {
	}


	public PostJobForm(String categoryId, String workState, String workCity, int workPincode, String workArea,
			String workDescription, int estimatedCost, String lastDate, String jobType) {
		super();
		this.categoryId = categoryId;
		this.workState = workState;
		this.workCity = workCity;
		this.workPincode = workPincode;
		this.workArea = workArea;
		this.workDescription = workDescription;
		this.estimatedCost = estimatedCost;
		this.lastDate = lastDate;
		this.jobType = jobType;
	}
	
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
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
	public int getWorkPincode() {
		return workPincode;
	}
	public void setWorkPincode(int workPincode) {
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
	public int getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
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


	@Override
	public String toString() {
		return "PostJobForm [categoryId=" + categoryId + ", workState=" + workState + ", workCity=" + workCity
				+ ", workPincode=" + workPincode + ", workArea=" + workArea + ", workDescription=" + workDescription
				+ ", estimatedCost=" + estimatedCost + ", lastDate=" + lastDate + ", jobType=" + jobType + "]";
	}  
	 
}
