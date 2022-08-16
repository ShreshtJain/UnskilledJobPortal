package com.persistent.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AllAppliedJobTest {
	jobId jobid = new jobId();
	
	//jobId class parametarized constructor test
	@Test
	public void jobIdParamaetrizedConstructorTest()
	{
		jobId jobID = new jobId(1, "Nik");
		
		assertEquals(1, jobID.getjobId());
		assertEquals("Nik", jobID.getaadharWorker());
	}
	
	//test jobId element of jobId class
	@Test 
	public void jobIdTest()
	{
		int jobId = 1;
		
		jobid.setjobId(jobId);
		
		int result = jobid.getjobId();
		
		assertEquals(jobId, result);
	}
	
	//test setaadharWorker element of jobId class
	@Test
	public void setaadharWorkerTest()
	{
		String aadharWorker = "Nik";
		
		jobid.setaadharWorker(aadharWorker);
		
		String result = jobid.getaadharWorker();
		
		assertEquals(aadharWorker, result);
	}
	
	
	//Testing for AllAppliedJob class starts here
	
	AllAppliedJob  allAppliedJob = new AllAppliedJob();
	
	//test for parametarized constructor of AllAppliedJob class
	@Test
	public void testOfParametarizedConstructorOfAllAppliedJobClass()
	{
		AllAppliedJob allAppliedJob = new AllAppliedJob(1, "Nik");
		
		assertEquals(1, allAppliedJob.getjobId());
		assertEquals("Nik", allAppliedJob.getAadharWorker());
	}
	
	//test jobId element of AllAppliedJob class
		@Test 
		public void jobIdOfAllAppliedJobTest()
		{
			int jobId = 1;
			
			allAppliedJob.setjobId(jobId);
			
			int result = allAppliedJob.getjobId();
			
			assertEquals(jobId, result);
		}
		
		//test setaadharWorker element of AllAppliedJob class
		@Test
		public void setAadharWorkerAllAppliedJobTest()
		{
			String aadharWorker = "Nik";
			
			allAppliedJob.setAadharWorker(aadharWorker);
			
			String result = allAppliedJob.getAadharWorker();
			
			assertEquals(aadharWorker, result);
		}
	
		
		//test of toString method of AllAppliedJob class
		@Test
		public void AllAppliedJobToString()
		{
			String str = "AllAppliedJob [jobId=1, aadharWorker=Nik]";
			
			AllAppliedJob allAppliedJob = new AllAppliedJob(1, "Nik");
			
			assertEquals(str, allAppliedJob.toString());
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
