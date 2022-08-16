package com.persistent.dao;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entity.Users;

public interface IUsersDAO extends CrudRepository<Users, String> {

	@Query(value="SELECT * FROM users WHERE Aadhar_No = ?", nativeQuery = true)
	  Users findByAadhar(String aadharNo);
	
	@Query(value="SELECT aadhar_no FROM users WHERE user_id = ?", nativeQuery = true)
	  String findAadharByUserId(int userId);

	Users findByUserId(int id);

}
