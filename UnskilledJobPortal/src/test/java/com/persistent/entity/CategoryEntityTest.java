package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryEntityTest {

	//category.setCategoryName()
	//category.getCategoryName()
	@Test
	public void categoryNameTest() {
		Category category=new Category();
		String categoryName="Maid";
		
		category.setCategoryName("Maid");
		String result=category.getCategoryName();
		
		
		assertEquals(categoryName, result);
		
	}
	
	//category.setCategoryId()
	//category.getCategoryId()
	@Test
	public void categoryIdTest() {
		Category category=new Category();
		int categoryId=1;
		
		category.setCategoryId(categoryId);
		int result=category.getCategoryId();
		
		assertEquals(categoryId, result);
		
	}

	//Test constructor category(int categoryId,String categoryName)
	@Test
	public void TestCategoryConstructorParametrisedWithParametersNameAndId() {
		Category category=new Category(1,"Maid");
		assertEquals(1, category.getCategoryId());
		assertEquals("Maid", category.getCategoryName());
	
	}
	
	//Test constructor category(String categoryName)
	@Test
	public void TestCategoryConstructorParametrisedWithParameterName() {
		Category category=new Category(1,"Maid");
		assertEquals("Maid", category.getCategoryName());
	
	}
	
	//Test the toString method for empty object
	@Test
	public void TestCategoryToStringEmptyObject() {
		Category category=new Category();
		assertEquals(category.toString(),"Category [categoryId="+0+", categoryName=null]");
		
	}
	
	//Test the toString method for  object with data
	@Test
	public void TestCategoryToStringWithObject() {
		Category category=new Category(1,"Maid");
		
		
//		Case : we can use StringBuilder for this
//		StringBuilder sb=new StringBuilder();
//		sb.append("Category [categoryId=");
//		sb.append(1);
//		sb.append(", categoryName=");
//		sb.append("Maid");
//		sb.append("]");
//		
//		assertEquals(category.toString(),new String(sb));
		
	//	Case 2: Use string and add with + sign manually
		String res="Category [categoryId="
				+"1"
				+", categoryName="
				+"Maid"
				+"]";
		
		
		assertEquals(category.toString(),res);

		
	}
	
	
	
}
