package com.persistent.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostJobFormTest {
	
	 PostJobForm postJobForm = new  PostJobForm();
	
	//test for PostJobForm parametarized class
	@Test
	public void PostJobFormParametarizedClassTest()
	{
		PostJobForm postJobForm = new PostJobForm("12", "Jharkhand", "Gaya", 823001, "sp kothi", "TO carry heavy load", 2000, "12-12-12", "Cooli");
		
		assertEquals("12", postJobForm.getCategoryId());
		assertEquals("Jharkhand", postJobForm.getWorkState());
		assertEquals("Gaya", postJobForm.getWorkCity());
		assertEquals(823001, postJobForm.getWorkPincode());
		assertEquals("sp kothi", postJobForm.getWorkArea());
		assertEquals("TO carry heavy load", postJobForm.getWorkDescription());
		assertEquals(2000, postJobForm.getEstimatedCost());
		assertEquals("12-12-12", postJobForm.getLastDate());
		assertEquals("Cooli", postJobForm.getJobType());
	}
	
	//test toString method of PostJobForm class
	@Test
	public void PostJobFormToStringTest()
	{
		String str = "PostJobForm [categoryId=12, workState=Jharkhand, workCity=Gaya, workPincode=823001, workArea=sp kothi, workDescription=TO carry heavy load, estimatedCost=2000, lastDate=12-12-12, jobType=Cooli]";
		
		PostJobForm postJobForm = new PostJobForm("12", "Jharkhand", "Gaya", 823001, "sp kothi", "TO carry heavy load", 2000, "12-12-12", "Cooli");
		
		assertEquals(str, postJobForm.toString());
	}
	
	//test categoryId element 
	@Test
	public void categoryIdTest()
	{
		String categoryId = "12";
		
		postJobForm.setCategoryId(categoryId);
		
		String result = postJobForm.getCategoryId();
		
		assertEquals(categoryId, result);
	}
	
	
	//test WorkState 
	@Test
	public void workStateTest()
	{
		String workState = "Jharkhand";
		
		postJobForm.setWorkState(workState);
		
		String result = postJobForm.getWorkState();
		
		assertEquals(workState, result);
	}
	
	//test WorkCity
	@Test
	public void workCityTest()
	{
		String workCity = "Gaya";
		
		postJobForm.setWorkCity(workCity);
		
		String result = postJobForm.getWorkCity();
		
		assertEquals(workCity, result);
	}
	
	//test WorkPincode
	@Test
	public void workPincodeTest()
	{
		int workPincode = 823001;
		
		postJobForm.setWorkPincode(workPincode);
		
		int result = postJobForm.getWorkPincode();
		
		assertEquals(workPincode, result);
	}
	
	//test workArea
	@Test
	public void workAreaTest()
	{
		String workArea = "sp kothi";
		
		postJobForm.setWorkArea(workArea);
		
		String result = postJobForm.getWorkArea();
		
		assertEquals(workArea, result);
	}
	
	
	//test workDescription
	@Test 
	public void workDescriptionTest()
	{
		String workDescription = "to carry heavy loads on head";
		
		postJobForm.setWorkDescription(workDescription);
		
		String result = postJobForm.getWorkDescription();
		
		assertEquals(workDescription, result);
	}
	
	//test estimatedCost
	@Test
	public void estimatedCostTest()
	{
		int estimatedCost = 2000;
		
		postJobForm.setEstimatedCost(estimatedCost);
		
		int result = postJobForm.getEstimatedCost();
		
		assertEquals(estimatedCost, result);
	}
	
	//test lastDate
	@Test
	public void lastDateTest()
	{
		String lastDate = "12-12-12";
		
		postJobForm.setLastDate(lastDate);
		
		String result = postJobForm.getLastDate();
		
		assertEquals(lastDate, result);
	}
	
	//test jobType
	@Test
	public void jobTypeTest()
	{
		String jobType = "Coolie";
		
		postJobForm.setJobType(jobType);
		
		String result = postJobForm.getJobType();
		
		assertEquals(jobType, result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
