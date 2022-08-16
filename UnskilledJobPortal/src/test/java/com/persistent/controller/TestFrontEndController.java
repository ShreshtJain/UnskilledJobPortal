package com.persistent.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import com.persistent.service.UsersService;


@SpringBootTest
@AutoConfigureMockMvc
public class TestFrontEndController {

	@Autowired
	private TestControllerForFrontEnd testController ;
	
	@Mock
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UsersService userService;
	
	@Mock
	Model model;
	
	@BeforeEach
	public void setupAuthentication(){
	    SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken("GUEST","USERNAME", AuthorityUtils.createAuthorityList("USER", "ADMIN")));
	}
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(testController).isNotNull();
	}
	

	@Test
	public void testControllerTest() throws Exception {
	
		//when(userService.updateUserProfile(user)).thenReturn(user);
		
		mockMvc.perform(get("/homepage")).andExpect(status().isOk()).andExpect(view().name("homepage"));
		
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
		
		mockMvc.perform(get("/all_job_list")).andExpect(status().isOk()).andExpect(view().name("all_job_list"));	
		
	}
	
	@Test
	public void profile() throws Exception
	{
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1,"111122223333","Ritika","Jadhav","F","ritika","8871958133","Ayodhya Bypass , Bhopal","ROLE_USER"));

		Users user=new Users();
		
		user.setUserId(1);
		user.setAadhar("111122223333");
		user.setFirstName("Ritika");
		user.setLastName("Jadhav");
		user.setContact("8871957133");
		user.setAddress("Ayodhya Bypass Road , Bhopal");
		user.setGender("F");
		user.setPassword(passwordEncoder.encode("ritika"));
		user.setRoles("ROLE_USER");
		
		MockHttpServletRequestBuilder request = get("/profile").flashAttr("user", user) ;
		this.mockMvc.perform(request).andExpect(status().is3xxRedirection()) ;
	}
	
	
	@Test
	public void Update_profile() throws Exception
	{
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1,"111122223333","Ritika","Jadhav","F","ritika","8871958133","Ayodhya Bypass , Bhopal","ROLE_USER"));

		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
		
		Users user=new Users();
		
		user.setUserId(1);
		user.setAadhar("111122223333");
		user.setFirstName("Ritika");
		user.setLastName("Jadhav");
		user.setContact("8871957133");
		user.setAddress("Ayodhya Bypass Road , Bhopal");
		user.setGender("F");
		user.setPassword(passwordEncoder.encode("ritika"));
		user.setRoles("ROLE_USER");
		
		MockHttpServletRequestBuilder request = get("/profile_update").flashAttr("user", user) ;
		//this.mockMvc.perform(request).andDo(print()).andExpect(status().isOk()) ; 
	}
	
	
	@Test
	public void updateproess() throws Exception
	{
		when(userService.getUserAadharUsingUserId(1)).thenReturn("111122223333");
//		when(userService.getUserByAadharNo("111122223333")).thenReturn(new Users(1,"111122223333","Ritika","Jadhav","F","ritika","8871958133","Ayodhya Bypass , Bhopal","ROLE_USER"));
//		this.mockMvc.perform(request).andExpect(status().isOk()) ;

		Users user=new Users();
		
		user.setUserId(1);
		user.setAadhar("111122223333");
		user.setFirstName("Ritika");
		user.setLastName("Jadhav");
		user.setContact("8871957133");
		user.setAddress("Ayodhya Bypass Road , Bhopal");
		user.setGender("F");
		user.setPassword(passwordEncoder.encode("ritika"));
		user.setRoles("ROLE_USER");
		
		MockHttpServletRequestBuilder request = post("/profile").flashAttr("user", user) ;
		//this.mockMvc.perform(request).andDo(print()).andExpect(status().isOk()) ; 
//		this.mockMvc.perform(request).andExpect(status().is3xxRedirection()) ;
	}
	
	
	
}
