package com.persistent.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JobDetailsTest {
	
	JobDetails jobDetails = new JobDetails();
	
	//testing working of getters and setters of jobId 
	@Test
	public void jobIdTest()
	{
		int jobId = 1;
		
		jobDetails.setJobId(jobId);
		int result = jobDetails.getJobId();
		
		assertEquals(jobId, result);
	}
	
	//testing working of "aadharNo" element of JobDetails
	@Test
	public void addharNoTest()
	{
		String aadharNo = "123456789987";
		
		jobDetails.setAadharNo(aadharNo);
		
		String result = jobDetails.getAadharNo();
		
		assertEquals(aadharNo, result);
	}
	
	//testing caterogyId element
	@Test 
	public void categoryIdTest()
	{
		int categoryId = 2;
		
		jobDetails.setCategoryId(categoryId);
		
		int result = jobDetails.getCategoryId();
		
		assertEquals(categoryId, result);
	}
	
	//testing workState element
	@Test
	public void workStateTest()
	{
		String workState = "Jharkhand";
		
		jobDetails.setWorkState(workState);
		
		String result = jobDetails.getWorkState();
		
		assertEquals(workState, result);
	}
	
	//testing workCity element
	@Test
	public void workCityTest()
	{
		String workCity = "Ranchi";
		
		jobDetails.setWorkCity(workCity);
		
		String result = jobDetails.getWorkCity();
		
		assertEquals(workCity, result);
	}
	
	
	//test workPincode element
	@Test
	public void workPincodeTest()
	{
		String workPincode = "823001";
		
		jobDetails.setWorkPincode(workPincode);
		
		String result = jobDetails.getWorkPincode();
		
		assertEquals(workPincode, result);
	}
	
	//test workArea element
	@Test
	public void workAreaTest()
	{
		String workArea = "Opposite to sp kothi";
		
		jobDetails.setWorkArea(workArea);
		
		String result = jobDetails.getWorkArea();
		
		assertEquals(workArea, result);
	}
	
	//test workDescription element
	@Test
	public void workDescriptionTest()
	{
		String workDescription = "In an open area";
		
		jobDetails.setWorkDescription(workDescription);
		
		String result = jobDetails.getWorkDescription();
		
		assertEquals(workDescription, result);
	}
	
	//test isActive element
	@Test
	public void isActiveTest()
	{
		boolean isActive = true;
		
		jobDetails.setActive(true);
		
		boolean result = jobDetails.isActive();
		
		assertEquals(isActive, result);
	}
	
	//test estimatedCost element
	@Test
	public void estimatedCostTest()
	{
		int estimatedCost = 3000;
		
		jobDetails.setEstimatedCost(estimatedCost);
		
		int result = jobDetails.getEstimatedCost();
		
		assertEquals(estimatedCost, result);
	}
	
	//test dateOfPost element
	@Test 
	public void dateOfPostTest()
	{ 
		Date dateOfPost  = new Date(13,11,25);
		
		jobDetails.setDateOfPost(dateOfPost);
		
		Date result = jobDetails.getDateOfPost();
		
		assertEquals(dateOfPost, result);
	}
	
	//test lastDate element 
	@Test
	public void lastDateTest()
	{
		Date lastDate = new Date(13,11,25);
		
		jobDetails.setLastDate(lastDate);
		
		Date result = jobDetails.getLastDate();
		
		assertEquals(lastDate, result);
		
	}
	
	//test jobType element 
	@Test 
	public void jobTypeTest()
	{
		String jobType = "Cooli";
		
		jobDetails.setJobType(jobType);
		
		String result = jobDetails.getJobType();
		
		assertEquals(jobType, result);
	}
	
	//test jobAssignedTo element 
	@Test
	public void jobAssignedToTest()
	{
		String jobAssignedTo = "Sarkar";
		
		jobDetails.setJobAssignedTo(jobAssignedTo);
		
		String result = jobDetails.getJobAssignedTo();
		
		assertEquals(jobAssignedTo, result);
	}
	
	
	//test Constructor with paramaterized constructor
	@Test
	public void paramaterizedConstructorTest()
	{
		JobDetails jobDetails = new JobDetails(1, "123456789987", 12, "Jhar", "Gaya", "823001", "jaslf", "helloooo", true, 2000, new Date(12, 12, 12), new Date(12, 12, 12), "Cooli", "Nik");
		
		assertEquals(1, jobDetails.getJobId());
		assertEquals("123456789987", jobDetails.getAadharNo());
		assertEquals(12, jobDetails.getCategoryId());
		assertEquals("Jhar", jobDetails.getWorkState());
		assertEquals("Gaya", jobDetails.getWorkCity());
		assertEquals("823001", jobDetails.getWorkPincode());
		assertEquals("jaslf", jobDetails.getWorkArea());
		assertEquals("helloooo", jobDetails.getWorkDescription());
		assertEquals(true, jobDetails.isActive());
		assertEquals(2000, jobDetails.getEstimatedCost());
		assertEquals(new Date(12, 12, 12), jobDetails.getDateOfPost());
		assertEquals(new Date(12, 12, 12), jobDetails.getLastDate());
		assertEquals("Cooli", jobDetails.getJobType());
		assertEquals("Nik", jobDetails.getJobAssignedTo());
	}
	
	//test toString of JobDetails class
	@Test
	public void toStringTest()
	{
		String str = "JobDetails [jobId=1, aadharNo=123456789987, categoryId=12, workState=Jhar, workCity=Gaya, workPincode=823001, workArea=jaslf, workDescription=helloooo, isActive=true, estimatedCost=2000, dateOfPost=1913-01-12, lastDate=1913-01-12, jobType=Cooli, jobAssignedTo=Nik]";
		
		JobDetails jobDetails = new JobDetails(1, "123456789987", 12, "Jhar", "Gaya", "823001", "jaslf", "helloooo", true, 2000, new Date(12, 12, 12), new Date(12, 12, 12), "Cooli", "Nik");
		
		String result = jobDetails.toString();
		
		assertEquals(str, result);
	}
	
	
	
	
	
	
	
	
	
}
