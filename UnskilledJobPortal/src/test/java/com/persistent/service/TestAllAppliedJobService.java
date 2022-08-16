package com.persistent.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import com.persistent.dao.IAllAppliedJobDAO;
import com.persistent.dao.IUsersDAO;
import com.persistent.entity.AllAppliedJob;
import com.persistent.entity.AppliedUserDetails;
import com.persistent.entity.Users;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class TestAllAppliedJobService {

	@InjectMocks
	AllAppliedJobService service;
	
	@Mock
	IAllAppliedJobDAO dao;	

	@Mock
	UsersService userService;
	
	@Mock
	IUsersDAO userDao;
	
	@Test
	public void applyJob()
	{
		AllAppliedJob job=new AllAppliedJob(1,"111122223333");
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		
		service.applyJob(1,1);
		
	}
	
	@Test
	public void getAllWhoApplied()
	{
		ArrayList<String> list=new ArrayList<>();
		list.add("111122223333");
		list.add("222211113333");
		
		when(dao.findAllUserAadhar(1)).thenReturn(list);
		
		final List<String> appliedUserList=service.getAllWhoApplied(1);
		
		assertThat(appliedUserList).isNotNull();
		
		assertThat(appliedUserList).contains("222211113333");
		
	}
	
	@Test
	public void getDetailsOfAppliedUser()
	{
		List<AppliedUserDetails> appliedUserDetailsList=new ArrayList<>();
				
		List<String> usersAadharNos=new ArrayList<>();
		
		usersAadharNos.add("111122223333");
		usersAadharNos.add("222211113333");
		
		String jobId="1";
		
		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1, "111122223333", "Ritika", "Jadhav", "F", "ritika",
				"8871958134", "Ayodhya Bypass, Bhopal", "ROLE_USER"));
		
		when(userService.getUserByAadharNo("222211113333")).thenReturn(new Users(2, "222211113333", "Shrikant", "Jadhav", "M", "shrikant",
				"8871958134", "Ayodhya Bypass, Bhopal", "ROLE_USER"));
		
		appliedUserDetailsList=service.getDetailsOfAppliedUser(usersAadharNos, jobId);
		
			

		
	//Testing....	
		assertThat(appliedUserDetailsList).isNotNull();
		
		assertEquals(2, appliedUserDetailsList.size());
	
		
	}
	
}
