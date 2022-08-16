package com.persistent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IAllAppliedJobDAO;
import com.persistent.entity.AppliedUserDetails;
import com.persistent.entity.Users;
import com.persistent.dao.IUsersDAO;
import com.persistent.entity.AllAppliedJob;

@Service("allApplliedJobService")
public class AllAppliedJobService {

	@Autowired
	private IAllAppliedJobDAO dao;	

	@Autowired
	private UsersService userService;
	
	
	public void applyJob(int job_id,int userId)
	{
		AllAppliedJob job=new AllAppliedJob();
		job.setjobId(job_id);
		job.setAadharWorker(userService.getUserAadharUsingUserId(userId));
		System.out.println(job);
		dao.save(job);
	}
	
	
	public List<String> getAllWhoApplied(int jobId)
	{
		System.out.println("In get all who applied");
		List<String> list= dao.findAllUserAadhar(jobId);
		System.out.println("List"+list);
		return list;
	}
	
	
	public List<AppliedUserDetails> getDetailsOfAppliedUser(List<String> usersAadharNos,String jobId)
	{
		List<AppliedUserDetails> appliedUserDetailsList=new ArrayList<>();
		
		for(String aadhar:usersAadharNos)
		{
			Users user=userService.getUserByAadharNo(aadhar);
			
			AppliedUserDetails aud=new AppliedUserDetails();
			
			aud.setAadharNo(aadhar);
			aud.setAddress(user.getAddress());
			
			if(user.getGender().equalsIgnoreCase("M"))
				aud.setGender("Male");
			else
				aud.setGender("Female");
			aud.setJobId(jobId);
			
			aud.setFullName(user.getFirstName()+" "+user.getLastName());
			aud.setMobileNo(user.getContact());
			
			appliedUserDetailsList.add(aud);
			
		}
		System.out.println("AUD"+appliedUserDetailsList);
		return appliedUserDetailsList;
	}
	
	
	
}
