
package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Users;

@Service("usersService")
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	public Users registerUser(Users u)
	{
		return dao.save(u);
	}
	
	public Users getUserByAadharNo(String aadharNo)
	{
		return dao.findByAadhar(aadharNo);
	}
	
	public String getUserAadharUsingUserId(int userId)
	{
		return dao.findAadharByUserId(userId);
	}
	
	//for appliedJobController to fetch name of logged users
	public String getNameById(int id)
	{
		Users u=dao.findByUserId(id);		
		return u.getFirstName()+" "+u.getLastName();
	}

	
}
