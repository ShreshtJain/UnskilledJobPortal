package com.persistent.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

//import org.junit.runner.RunWith;

import org.junit.jupiter.api.Test;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class TestUserService {

	@InjectMocks
	UsersService service;
	
	@Mock
	IUsersDAO dao;
	

	
	@Test
	public void registerUserTest()
	{
		Users user=new Users(1, "111122223333", "Ritika", "Jadhav", "F", "ritika",
				"8871957145", "Ayodhya Bypass, Bhopal", "ROLE_USER");
		service.registerUser(user);
		
		verify(dao,times(1)).save(user);

	}
	
	@Test
	public void getUserByAadharNoTest()
	{
		when(dao.findByAadhar("111122223333")).thenReturn(new Users(1, "111122223333", "Ritika", "Jadhav", "F", "ritika",
				"8871958134", "Ayodhya Bypass, Bhopal", "ROLE_USER"));
		
//		when(service.getUserByAadharNo("111122223333")).thenReturn(new Users(1, "111122223333", "Ritika", "Jadhav", "F", "ritika",
//				"8871958134", "Ayodhya Bypass, Bhopal", "ROLE_USER"));
		
		Users user=service.getUserByAadharNo("111122223333");
		
		assertEquals("Ritika",user.getFirstName() );
		assertEquals("Jadhav",user.getLastName() );
		assertEquals("ROLE_USER",user.getRoles() );
		assertEquals("ritika",user.getPassword() ); 
		assertEquals("F",user.getGender() );
	}
	
	@Test
	public void getNameById()
	{	
		when(dao.findByUserId(1)).thenReturn(new Users(1, "111122223333", "Ritika", "Jadhav", "F", "ritika",
				"8871958134", "Ayodhya Bypass, Bhopal", "ROLE_USER"));
		String name=service.getNameById(1);
		
		assertEquals("Ritika Jadhav", name);
		
	}
	
	@Test
	public void getUserAadharUsingUserId()
	{
		when(dao.findAadharByUserId(1)).thenReturn("111122223333");
		
		String aadhar=service.getUserAadharUsingUserId(1);
		
		assertEquals("111122223333", aadhar);
	}
	
	
	
}
