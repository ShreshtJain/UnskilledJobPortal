package com.persistent.dao;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails,Integer> {

	
	//used this query because of auto generated value of job id is applied at db end
	@Modifying
	@Transactional
	@Query(value = "insert into job_details (aadhar_no,category_id,date_of_post,estimated_cost,job_type,last_date,work_area,work_city,work_description,work_pincode,work_state) values (?1 ,?2 ,?3 ,?4 ,?5 ,?6 ,?7 ,?8 ,?9 ,?10 ,?11 ) ", nativeQuery = true)
		int insertJobDetails(String aadharNo,int categoryId,Date dateOfPost,int estimatedCost,String jobType,Date lastDate,String workArea,String workCity,String workDescription,String workPincode,String workState);
	
	
	@Query(value="SELECT * FROM Job_Details WHERE Aadhar_No = ?1 ORDER BY JOB_ID DESC", nativeQuery = true)
	  List<JobDetails> findAllById(String aadharNo);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE job_details set job_assigned_to =?1,is_active='F' where job_id = ?2", nativeQuery = true)
		int setJobAssignedToOfJobId(String aadharNo,int jobId);
	
	
	@Query(value="SELECT job_assigned_to FROM Job_Details WHERE job_id = ?1", nativeQuery = true)
	  String findSelectedWorkerAadharNo(int jobId);

	JobDetails findByJobId(int id);
	
	

	@Query(value="SELECT * FROM JOB_DETAILS WHERE is_active='T'",nativeQuery=true)
	public List<JobDetails> getAllJobs();
	
	
}
