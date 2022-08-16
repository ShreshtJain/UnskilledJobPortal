package com.persistent.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.ui.Model;

import com.persistent.entity.Users;
import com.persistent.service.AllAppliedJobService;
import com.persistent.service.CategoryService;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@SpringBootTest
@AutoConfigureMockMvc
public class AppliedJobControllerTest {

	@Autowired
	private AppliedJobController appliedController ; 
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UsersService userService;
	
	@Mock
	private JobService jobService;
	
	@Mock
	Model model;
	
	@BeforeEach
	public void setupAuthentication(){
	    SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken("GUEST","USERNAME", AuthorityUtils.createAuthorityList("USER", "ADMIN")));
	}
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(appliedController).isNotNull();
	}
	

	@Test
	public void AppliedControllerTest() throws Exception {
		
		
		mockMvc.perform(post("/Apply_job")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/login"));
		
		//mockMvc.perform(post("/Apply_job")).andExpect(status().isOk()).andExpect(view().name("apply_job"));	
		
	}
	
	@Test
	public void Apply_job() throws Exception
	{
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1,"111122223333","Ritika","Jadhav","F","ritika","8871958133","Ayodhya Bypass , Bhopal","ROLE_USER"));

		
		when(jobService.getAadharByJobId(1)).thenReturn("111122223333");
		
		MockHttpServletRequestBuilder request = post("/do_register").flashAttr("owner", "Ritika Jadhav") ;
		this.mockMvc.perform(request).andExpect(status().isOk()) ; 
	}
	
	@Test
	public void applyJob() throws Exception
	{
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1,"111122223333","Ritika","Jadhav","F","ritika","8871958133","Ayodhya Bypass , Bhopal","ROLE_USER"));

		

//		MockHttpServletRequestBuilder request = post("/jobApplied").param("job_id", 1) ;
//		this.mockMvc.perform(request).andExpect(status().isOk()) ; 
//			mockMvc.perform(get("/jobApplied")).andExpect(status().isOk()).andExpect(view().name("/all_applied_jobs"));
	}
//	
//	@Test
//	public void viewMyAppliedJob()
//	{
//		
//	}
	
}
