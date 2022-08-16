package com.persistent.entity;

public class AppliedUserDetails {

	private String jobId;
	private String aadharNo;	
	private String fullName;
	private String gender;
	private String mobileNo;
	private String address;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public AppliedUserDetails() {
		super();
	}
	public AppliedUserDetails(String jobId, String aadharNo, String fullName, String gender, String mobileNo,
			String address) {
		super();
		this.jobId = jobId;
		this.aadharNo = aadharNo;
		this.fullName = fullName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.address = address;
	}
	@Override
	public String toString() {
		return "AppliedUserDetails [jobId=" + jobId + ", aadharNo=" + aadharNo + ", fullName=" + fullName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
	
	
	
	
}
