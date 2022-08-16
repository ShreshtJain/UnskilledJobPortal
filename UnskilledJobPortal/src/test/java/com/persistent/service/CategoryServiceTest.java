package com.persistent.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//------------------------------------------------------------------------------------
//use this otherwise when you run , run as junit test nothing will happen
import org.junit.jupiter.api.Test;

//---------------------------------------------------------------------------------------

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.persistent.dao.ICategoryDAO;
import com.persistent.entity.Category;
import com.persistent.service.CategoryService;

//@RunWith(SpringRunner.class)

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

	//private CategoryService categoryService=new CategoryService();
	
	 
	     
	  @MockBean
	  ICategoryDAO dao;

	  @InjectMocks
	  CategoryService categoryService;
	  
	 
	 
	  
	@Test
	public void testGetCategoryNameById() {
		
		Category cat= new Category(1,"Maid");
		
		when(dao.findById(1)).thenReturn(cat);
		 
		 
		 String name = categoryService.getCategoryNameById(1);
		 
		 assertEquals("Maid", cat.getCategoryName());	
	}
	
	@Test
	public void addCategory() {
		
	 Category category = new Category(1,"Maid");
     
     categoryService.addCategory(category);
     
	 verify(dao, times(1)).save(category);
	}
	
	
	

	@Test
	public void testGetAllCategories() {
		List<Category> categoriesList=new ArrayList<>();
		categoriesList.add(new Category(1,"Maid"));
		categoriesList.add(new Category(2,"Cook"));
		categoriesList.add(new Category(3,"Watchman"));
		categoriesList.add(new Category(4,"Driver"));
		
		when(dao.findAll()).thenReturn(categoriesList);
		 
		assertEquals(categoryService.getAllCategories(), categoriesList);
	}
	
	
	
	
	@Test
	public void testGetAllJobType() {
		
		List<String> jobTypeList = new ArrayList<>();

		jobTypeList.add("One Day");
		jobTypeList.add("Two Days");
		jobTypeList.add("Three Days");
		jobTypeList.add("One Week");
		jobTypeList.add("Fifteen Days");
		jobTypeList.add("Monthly");
		
		
		assertEquals(categoryService.getAllJobType(),jobTypeList);
		
		

	}
	
	
	
	@Test
	public void testGetAllStates() {
		List<String> statesList = new ArrayList<>();

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
		
		assertEquals(categoryService.getAllStates(),statesList);


	}
	
	
	@Test
	public void testGetCategoryById() {
		
		Category cat= new Category(1,"Maid");
		
		when(dao.findByCategoryId(1)).thenReturn(cat);
		 
		 
		 String name = categoryService.getCategoryById(1);
		 
		 assertEquals("Maid", name);	
		 
	}
	
	
// left for future scope .....
	
//	@Test
//	public void deleteCategoryById_thenDeletingShouldBeSuccessful() {
//		 
//		Category cat=new Category(1,"Maid");
//		
//		 // Given that an item with CHECKED_ITEM_ID is removed
//		 categoryService.deleteCategory(cat.getCategoryId());
//		
//		 // Verify that the repository is used to delete the item
//		 verify(dao).deleteById(cat.getCategoryId());
//		
//	} 
}
