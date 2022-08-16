package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.persistent.entity.AppliedJobDetails;

@SpringBootTest

public class AppliedJobDetailsEntityTest {

	@Test
	public void LocationTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String location ="ABC Road";
		
		ajd.setLocation(location);
		String result=ajd.getLocation() ;
		assertEquals(location, result);
		
	}
	
	@Test
	public void JobIDTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		int id =101;
		
		ajd.setJobId(id);
		int result=ajd.getJobId() ;
		
		
		assertEquals(id, result);
		
	}
	
	@Test
	public void AadharTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String aadhar ="0000 1111 2222 3333";
		
		ajd.setAadhar(aadhar);
		String result=ajd.getAadhar() ;
		
		
		assertEquals(aadhar, result);
		
	}
	
	@Test
	public void CategoryTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String cat ="random value";
		
		ajd.setCategory(cat);
		String result=ajd.getCategory() ;
		
		
		assertEquals(cat, result);
		
	}
	
	@Test
	public void OwnerTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String owner ="owner";
		
		ajd.setOwner(owner);
		String result=ajd.getOwner() ;
		
		
		assertEquals(owner, result);
		
	}
	
	@Test
	public void DateofPostTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String str="2015-03-31";
		Date date=Date.valueOf(str);
		
		ajd.setDateOfPost(date);
		Date result=ajd.getDateOfPost() ;
		
		
		assertEquals(date, result);
		
	}
	
	@Test
	public void StatusTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		String status ="StatusValue";
		
		ajd.setStatus(status);
		String result=ajd.getStatus() ;
		
		
		assertEquals(status, result);
		
	}
	
	@Test
	public void AppliedJobDetailsToStringEmptyTest() {
		AppliedJobDetails ajd= new AppliedJobDetails();
		
		assertEquals(ajd.toString(),"AppliedJobDetails [jobId=" + 0 + ", aadhar=null, category=null, owner=null, dateOfPost=null, status=null, location=null]");
		
	}
	
	@Test
	public void AppliedJobDetailsToStringWithObjectTest() {
		
		String str="2015-03-31";
		Date dop=Date.valueOf(str);
		AppliedJobDetails ajd= new AppliedJobDetails(101,"0000 1111 2222 3333","category","owner",dop,"some status","some location");
		
		String result= "AppliedJobDetails [jobId=" + 101 + ", aadhar=" +"0000 1111 2222 3333" + ", category=" + "category" + ", owner="+ "owner" +", dateOfPost="+"2015-03-31"+ ", status="+"some status" +", location="+"some location]";
		
		assertEquals(ajd.toString(),result);
	}
	
	@Test
	public void ParameterizedAppliedJobConstructorTest() {
		
		String str="2015-03-31";
		Date dop=Date.valueOf(str); 
		AppliedJobDetails ajd= new AppliedJobDetails(101,"0000 1111 2222 3333","category","owner",dop,"some status","some location");
		assertEquals(101,ajd.getJobId());
		assertEquals("0000 1111 2222 3333",ajd.getAadhar());
		assertEquals("category",ajd.getCategory());
		assertEquals("owner",ajd.getOwner());
		assertEquals(dop,ajd.getDateOfPost());
		assertEquals("some status",ajd.getStatus());
		assertEquals("some location",ajd.getLocation());
	}
	
}
