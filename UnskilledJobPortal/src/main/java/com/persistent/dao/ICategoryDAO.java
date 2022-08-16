package com.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.entity.Category;

public interface ICategoryDAO extends CrudRepository<Category, Integer> {
	
	List<Category> findAll();
	Category findById(int id);

	Category findByCategoryId(int id);
	
	
}
