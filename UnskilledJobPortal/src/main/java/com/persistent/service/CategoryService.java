package com.persistent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.ICategoryDAO;
import com.persistent.entity.Category;

@Service("categoryService")
public class CategoryService {

	@Autowired
	private ICategoryDAO dao;
	
	public List<Category> getAllCategories()
	{
		System.out.println("In getAllCategories");
		return dao.findAll();
	}
	
	public void addCategory(Category categoryName)
	{
		System.out.println("In addCategory");
		dao.save(categoryName);
	}
	
	public List<String> getAllStates()
	{
		List<String> statesList=new ArrayList<>();
		
		//states name for dropdown
		
		statesList.add("Andhra Pradesh");
		statesList.add("Arunachal Pradesh");
		statesList.add("Assam");
		statesList.add("Bihar");
		statesList.add("Chhattisgarh");
		statesList.add("Goa");
		statesList.add("Gujarat");
		statesList.add("Haryana");
		statesList.add("Himachal Pradesh");
		statesList.add("Jammu and Kashmir");
		statesList.add("Jharkhand");
		statesList.add("Karnataka");
		statesList.add("Kerala");
		statesList.add("Madhya Pradesh");
		statesList.add("Maharashtra");
		statesList.add("Manipur");
		statesList.add("Meghalaya");
		statesList.add("Mizoram");
		statesList.add("Nagaland");
		statesList.add("Odisha");
		statesList.add("Pumjab");
		statesList.add("Rajasthan");
		statesList.add("Sikkim");
		statesList.add("Tamil Nadu");
		statesList.add("Telangana");
		statesList.add("Tripura");
		statesList.add("Uttar Pradesh");
		statesList.add("Uttarakhand");
		statesList.add("West Bengal");
		
		return statesList;

	}
	
	public List<String> getAllJobType()
	{
		List<String> jobTypeList=new ArrayList<>();
		
		//jobTypes for dropdown
		
		jobTypeList.add("One Day");
		jobTypeList.add("Two Days");
		jobTypeList.add("Three Days");
		jobTypeList.add("One Week");
		jobTypeList.add("Fifteen Days");
		jobTypeList.add("Monthly");
		
		return jobTypeList;
	}
	public String getCategoryNameById(int categoryId)
	{
		return dao.findById(categoryId).getCategoryName();
	}
	
	public String getCategoryById(int id)
	{
		return dao.findByCategoryId(id).getCategoryName();
	}

	
// left for future scope .......
	
//	public void deleteCategory(int categoryId) {
//		dao.deleteById(categoryId);
//	}
	
}
