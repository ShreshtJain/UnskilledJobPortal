package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppliedUserDetailsTest {

	//aud.setJobId()
	//aud.getJobId()
	@Test
	public void userJobIdTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String id="101";
		
		aud.setJobId(id);
		String result=aud.getJobId();
		
		assertEquals(id, result);
		
	}
	
	//aud.setAadharNo()
	//aud.getAadharNo()
	@Test
	public void userAadharTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String aadhar="1111 2222 3333";
		
		aud.setAadharNo(aadhar);
		String result=aud.getAadharNo();
		
		assertEquals(aadhar, result);
		
	}

	//aud.setFullName()
	//aud.getFullName()
	@Test
	public void userFullNameTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String fullname="Full Name";
		
		aud.setFullName(fullname);
		String result=aud.getFullName();
		
		assertEquals(fullname, result);
	}

	//aud.setGender()
	//aud.getGender()
	@Test
	public void userGenderTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String gender="Male";
		
		aud.setGender(gender);
		String result=aud.getGender();
		
		assertEquals(gender, result);
	}

	//aud.setMobileNo()
	//aud.getMobileNo()
	@Test
	public void userMobileNoTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String mobno="9876543210";
		
		aud.setMobileNo(mobno);
		String result=aud.getMobileNo();
		
		assertEquals(mobno, result);
	}

	//aud.setAddress()
	//aud.getAddress()
	@Test
	public void userAddressTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String addr="ABC Road";
		
		aud.setAddress(addr);
		String result=aud.getAddress();
		
		assertEquals(addr, result);
	}
	
	//Test the AppliedUsersDetails toString() method for  object for empty object
	@Test
	public void testAppliedUsersDetailsToStringEmptyObject() {
		AppliedUserDetails aud=new AppliedUserDetails();
		assertEquals(aud.toString(),"AppliedUserDetails [jobId=null, aadharNo=null, fullName=null, gender=null, mobileNo=null, address=null]");
		
	}
	
	
	//Test the AppliedUsersDetails toString() method for  object with data
	@Test
	public void testAppliedUsersDetailsToStringWithObject() {
		AppliedUserDetails aud=new AppliedUserDetails();
		aud.setAadharNo("1111 2222 3333");
		aud.setAddress("ABC Road");
		aud.setFullName("Full Name");
		aud.setGender("Male");
		aud.setJobId("101");
		aud.setMobileNo("9876543210");
		
		String result="AppliedUserDetails [jobId="+"101"+", aadharNo="+"1111 2222 3333"+", fullName="+"Full Name"+", gender="+"Male"+", mobileNo="+"9876543210"+", address="+"ABC Road]";                                              
		
		assertEquals(aud.toString(),result);
	}
	
	/*Test the parameterized constructor AppliedUserDetails(String jobId, 
	 	String aadharNo, String fullName, String gender, String mobileNo, String address) */
	@Test
	public void testUsersParametrisedConstructor() 
	{
		AppliedUserDetails awd=new AppliedUserDetails("101","111122223333","Full Name","Male","9876543210","Pune");
		assertEquals("101", awd.getJobId());
		assertEquals("111122223333", awd.getAadharNo());
		assertEquals("Full Name", awd.getFullName());
		assertEquals("Male", awd.getGender());
		assertEquals("9876543210", awd.getMobileNo());
		assertEquals("Pune", awd.getAddress());

	}
}
