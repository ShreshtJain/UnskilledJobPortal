package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest


public class AllPostedJobDetailTest {
	//AllPostedJobDetails.setJobId()
		//AllPostedJobDetails.getJobId()
		@Test
		public void AllPostedJobDetailsTypeJobId() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setJobId("s");
			String result=obj.getJobId();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setCategoryName()
		//AllPostedJobDetails.getCategoryName()
		@Test
		public void AllPostedJobDetailsTypeCategoryName() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setCategoryName("s");
			String result=obj.getCategoryName();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setWorkArea()
		//AllPostedJobDetails.getWorkArea()
		@Test
		public void AllPostedJobDetailsTypeWorkArea() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setWorkArea("s");
			String result=obj.getWorkArea();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setWorkDescription()
		//AllPostedJobDetails.getWorkDescription()
		@Test
		public void AllPostedJobDetailsTypeWorkDescrition() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setWorkDescription("s");
			String result=obj.getWorkDescription();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setJobId()
		//AllPostedJobDetails.setJobId()
		@Test
		public void AllPostedJobDetailsTypestatus() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setStatus("s");
			String result=obj.getStatus();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setDateOfPost()
		//AllPostedJobDetails.getDateOfPost()
		@Test
		public void AllPostedJobDetailsTypedateOfPost() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setDateOfPost("s");
			String result=obj.getDateOfPost();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setLastDate()
		//AllPostedJobDetails.getLastDate()
		@Test
		public void AllPostedJobDetailsTypeLastDate() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setLastDate("s");
			String result=obj.getLastDate();

			assertEquals(str, result);

		}

		//AllPostedJobDetails.setJobId()
		//AllPostedJobDetails.setJobId()
		@Test
		public void AllPostedJobDetailsTypeJobType() {
			AllPostedJobDetails obj = new AllPostedJobDetails();
			String str="s";

			obj.setJobType("s");
			String result=obj.getJobType();

			assertEquals(str, result);

		}

		//Test constructor Massage(String content,String type)
		@Test
		public void TestAllPostedJobDetailsConstructorParametrisedWithParameters() {
			AllPostedJobDetails obj = new AllPostedJobDetails("s" ,"s" ,"s" ,"s" ,"s" ,"s" ,"s" ,"s");
			assertEquals("s", obj.getJobId());
			assertEquals("s", obj.getCategoryName());
			assertEquals("s", obj.getWorkArea());
			assertEquals("s", obj.getWorkDescription());
			assertEquals("s", obj.getStatus());
			assertEquals("s", obj.getDateOfPost());
			assertEquals("s", obj.getLastDate());
			assertEquals("s", obj.getJobType());

		}

		//Test the toString method for empty object
		@Test
		public void TestAllPostedJobDetailsToStringEmptyObject() {
			AllPostedJobDetails obj = new AllPostedJobDetails();

			assertEquals(obj.toString(),"AllPostedJobDetails [jobId=" + null + ", categoryName=" + null + ", workArea=" + null
					+ ", workDescription=" + null + ", status=" + null + ", dateOfPost=" + null
					+ ", lastDate=" + null + ", jobType=" + null + "]");

		}

		//Test the toString method for  object with data
		@Test
		public void TestAllPostedJobDetailsToStringWithObject() {
			AllPostedJobDetails obj = new AllPostedJobDetails("s" ,"s" ,"s" ,"s" ,"s" ,"s" ,"s" ,"s");


			//	Case 2: Use string and add with + sign manually
			String res="AllPostedJobDetails [jobId=s, categoryName=s, workArea=s, workDescription=s, status=s, dateOfPost=s, lastDate=s, jobType=s]";


			assertEquals(obj.toString(),res);


		}
}
