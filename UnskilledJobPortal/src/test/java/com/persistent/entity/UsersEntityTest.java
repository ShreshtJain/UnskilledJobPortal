package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersEntityTest {

	//user.setUserId()
	//user.getUserId()
	@Test
	public void userIdTest() {
		Users user=new Users();
		int userId=1;
		
		user.setUserId(userId);
		int result=user.getUserId();
		
		assertEquals(userId, result);
		
	}
	
	//user.getAadhar()
	//user.setAadhar()
	@Test
	public void userAadharTest() {
		Users user=new Users();
		String aadhar="111122223333";
		
		user.setAadhar(aadhar);
		String result=user.getAadhar();
		
		assertEquals(aadhar, result);
		
	}
	
	//user.setFirstName()
	//user.getFirstName()
	@Test
	public void userFirstNameTest() {
		Users user=new Users();
		String firstName="First";
		
		user.setFirstName(firstName);
		String result=user.getFirstName();
		
		assertEquals(firstName, result);
		
	}
	
	//user.setLastName()
	//user.getLastName()
	@Test
	public void userLastNameTest() {
		Users user=new Users();
		String lastName="Last";
		
		user.setLastName(lastName);
		String result=user.getLastName();
		
		assertEquals(lastName, result);
	}
	
	//user.setGender()
	//user.getGender()
	@Test
	public void userGenderTest() {
		Users user=new Users();
		String gender="M";
		
		user.setGender(gender);
		String result=user.getGender();
		
		assertEquals(gender, result);
		
	}
	
	//user.setPassword()
	//user.getPassword()
	@Test
	public void userPasswordTest() {
		Users user=new Users();
		String password="12345678";
		
		user.setPassword(password);
		String result=user.getPassword();
		
		assertEquals(password, result);
		
	}
	
	//user.setContact()
	//user.getContact()
	@Test
	public void userContactTest() {
		Users user=new Users();
		String contact="9876543210";
		
		user.setContact(contact);;
		String result=user.getContact();
		
		assertEquals(contact, result);
		
	}
	
	//user.setAddress()
	//user.getAddress()
	@Test
	public void userAddressTest() {
		Users user=new Users();
		String address="Pune";
		
		user.setAddress(address);;
		String result=user.getAddress();
		
		assertEquals(address, result);
		
	}
	
	//user.setRoles()
	//user.getRoles()
	@Test
	public void userRolesTest() {
		Users user=new Users();
		String role="ROLE_ADMIN";
		
		user.setRoles(role);
		String result=user.getRoles();
		
		assertEquals(role, result);
		
	}
	
	//Test the Users toString() method for empty object
	@Test
	public void testUsersToStringEmptyObject() {
		Users user=new Users();
		assertEquals(user.toString(),"Users [userId=" + 0 + ", aadhar=null, firstName=null, lastName=null, gender=null, password=null, contact=null, address=null, roles=null]");
		
	}
	
	//Test the Users toString() method for  object with data
	@Test
	public void testUsersToStringWithObject() {
		Users user=new Users(1,"111122223333","First","Last","M","12345678","9876543210","Pune","ROLES_USER");
		
		String result="Users [userId=" + 1 + ", aadhar=" + "111122223333" + ", firstName=" + "First"
				+ ", lastName=" + "Last" + ", gender=" + "M" + ", password=" + "12345678"+ ", contact=" + "9876543210"
				+ ", address=" + "Pune" + ", roles=" + "ROLES_USER" + "]";
		
		
		assertEquals(user.toString(),result);

		
	}
	
	
	/*Test parameterized constructor Users(int userId, String aadhar, String firstName,
	  	String lastName, String gender, String password,
		String contact, String address, String roles)*/
	@Test
	public void testUsersParametrisedConstructor() {
		Users user=new Users(1,"111122223333","First","Last","M","12345678","9876543210","Pune","ROLES_ADMIN");
		assertEquals(1, user.getUserId());
		assertEquals("111122223333", user.getAadhar());
		assertEquals("First", user.getFirstName());
		assertEquals("Last", user.getLastName());
		assertEquals("M", user.getGender());
		assertEquals("12345678", user.getPassword());
		assertEquals("9876543210", user.getContact());
		assertEquals("Pune", user.getAddress());
		assertEquals("ROLES_ADMIN", user.getRoles());
	
	}
}