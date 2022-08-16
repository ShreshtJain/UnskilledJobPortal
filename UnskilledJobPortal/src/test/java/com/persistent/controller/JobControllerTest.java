package com.persistent.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.test.web.servlet.MockMvc;

import com.persistent.service.CategoryService;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@SpringBootTest
@AutoConfigureMockMvc
public class JobControllerTest {

	@Autowired
	private JobController jobController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Mock
	private JobService jobService;
	
	@Mock
	private CategoryService categoryService;
	
	@Mock
	private UsersService userService;
	
	@BeforeEach
	public void setupAuthentication(){
	    SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken("GUEST","USERNAME", AuthorityUtils.createAuthorityList("USER", "ADMIN")));
	}
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(jobController).isNotNull();
	}
	
	

	@Test
	public void JobControllerTest() throws Exception {
		
		
		mockMvc.perform(post("/job_post")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/login"));
		
		//mockMvc.perform(post("/Apply_job")).andExpect(status().isOk()).andExpect(view().name("apply_job"));	
		
	}
	
}
