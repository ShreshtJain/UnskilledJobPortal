package com.persistent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

class jobId implements Serializable
{
	private int jobId;
	private String aadharWorker;
	public jobId() {
		super();
	}
	
	
	public jobId(int jobId, String aadharWorker) {
		super();
		this.jobId = jobId;
		this.aadharWorker = aadharWorker;
	}
	
	public int getjobId() {
		return jobId;
	}
	public void setjobId(int jobId) {
		this.jobId = jobId;
	}
	public String getaadharWorker() {
		return aadharWorker;
	}
	public void setaadharWorker(String aadharWorker) {
		this.aadharWorker = aadharWorker;
	}
	
}


@Entity
@IdClass(jobId.class)
@Table(name="ALL_APPLIED_JOB")
public class AllAppliedJob {

	@Id
	@Column(name="JOB_ID" , columnDefinition = "NUMBER")
	private int jobId;
	
	@Id
	@Column(name="AADHAR_WORKER" , columnDefinition = "VARCHAR2 (12)")
	private String aadharWorker;
	
	public AllAppliedJob() {
		super();
	}
	
	public AllAppliedJob(int jobId, String aadharWorker) {
		super();
		this.jobId = jobId;
		this.aadharWorker = aadharWorker;
	}
	
	public int getjobId() {
		return jobId;
	}
	public void setjobId(int jobId) {
		this.jobId = jobId;
	}
	public String getAadharWorker() {
		return aadharWorker;
	}
	public void setAadharWorker(String aadharWorker) {
		this.aadharWorker = aadharWorker;
	}
	
	@Override
	public String toString() {
		return "AllAppliedJob [jobId=" + jobId + ", aadharWorker=" + aadharWorker + "]";
	}
	
	
	
}
